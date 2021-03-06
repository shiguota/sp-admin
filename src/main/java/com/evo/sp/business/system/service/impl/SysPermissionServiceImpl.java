package com.evo.sp.business.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.evo.sp.business.system.entity.SysMenuPermission;
import com.evo.sp.business.system.entity.SysPermission;
import com.evo.sp.business.system.entity.vo.SysPermissionVo;
import com.evo.sp.business.system.mapper.SysMenuPermissionMapper;
import com.evo.sp.business.system.mapper.SysPermissionMapper;
import com.evo.sp.business.system.service.ISysPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.ex.SaveException;
import com.evo.sp.common.ex.SpAssert;
import com.evo.sp.common.result.Result;
import com.evo.sp.common.result.ResultEnum;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements ISysPermissionService {


    @Autowired
    private SysPermissionMapper sysPermissionMapper;
    @Autowired
    private SysMenuPermissionMapper sysMenuPermissionMapper;

    /**
     * 根据角色编码获取权限
     *
     * @param roleCode
     */
    @Override
    public List<SysPermission> queryPermissionsByCode(String roleCode) {
        return sysPermissionMapper.queryPermissionsByCode(roleCode);
    }

    /**
     * 新增权限
     * @param sysPermissionVo
     */
    @Transactional
    @Override
    public Result savePermission(SysPermissionVo sysPermissionVo) {
        //创建需要保存的权限对象
        SysPermission sysPermission = new SysPermission();
        //校验权限参数
        SpAssert.isNull(sysPermissionVo);
        //校验权限名称
        SpAssert.isNull(sysPermissionVo.getPerName());
        //校验权限编码
        SpAssert.isNull(sysPermissionVo.getPerCode());
        //执行新增操作
        BeanUtils.copyProperties(sysPermissionVo,sysPermission);
        if (sysPermissionMapper.insert(sysPermission) == SpConstantInter.CURDVAL) {
            //判断新增权限的同时，是否指定该权限属于某个菜单
            if (SpAssert.isNotNull(sysPermissionVo)) {
                //获取菜单权限对象
                SysMenuPermission sysMenuPermission = sysPermissionVo.getSysMenuPermission();
                //设置菜单权限对象中的权限id
                sysMenuPermission.setSysPermissionId(sysPermission.getId());
                //校验菜单权限对象中的菜单id是否为空
                SpAssert.isNull(sysMenuPermission.getSysMenuId());
                //执行保存操作
                if (sysMenuPermissionMapper.insert(sysMenuPermission) != SpConstantInter.CURDVAL) {
                    throw new SaveException();
                }
            }
        }else{
            throw new SaveException();
        }
        return null;
    }

    /**
     * 根据菜单获取权限
     *
     * @param menuId
     */
    @Override
    public Result queryPerByMenuId(String menuId) {
        SpAssert.isNull(menuId);
        return new Result(sysPermissionMapper.queryPerByMenuId(menuId));
    }

    /**
     * 获取用户拥有的菜单权限
     *
     * @param menuId  菜单id
     * @param userId 用户id
     */
    @Override
    public Result queryPerByMenuUser(String menuId, String userId) {
        SpAssert.isNull(userId);
        return new Result(sysPermissionMapper.queryPerByMenuUser(menuId,userId));
    }

    /**
     * 获取当前登录账号以及被勾选账号的某个菜单的权限差集
     * @param sysPermissionVo
     */
    @Override
    public Result queryPerByMenuUserDifSet(SysPermissionVo sysPermissionVo) {
        SpAssert.isNull(sysPermissionVo);
        SpAssert.isNull(sysPermissionVo.getMenuId());
        SpAssert.isNull(sysPermissionVo.getLUserId());
        SpAssert.isNull(sysPermissionVo.getUserId());
        return new Result(sysPermissionMapper.queryPerByMenuUserDifSet(sysPermissionVo));
    }

    /**
     * 新增（返回id）
     *
     * @param sysPermission
     */
    @Override
    public Map<String, Object> savePerBackId(SysPermission sysPermission) {
        //当前是否存在相同code以及name的权限信息
        if (!SpAssert.isNotNull(getOne(new QueryWrapper<SysPermission>().eq(SpConstantInter.SYS_PERMISSION_CODE,sysPermission.getPerCode()),false))) {
            if (!SpAssert.isNotNull(getOne(new QueryWrapper<SysPermission>().eq(SpConstantInter.SYS_PERMISSION_NAME,sysPermission.getPerName()),false))) {
                if (!save(sysPermission)) {
                    throw new SaveException();
                }
            }else{
                throw new SaveException(ResultEnum.PERMISSION_SAVE_NAME.getValue(), ResultEnum.PERMISSION_SAVE_NAME.getName());
            }
        }else{
            throw new SaveException(ResultEnum.PERMISSION_SAVE_CODE.getValue(), ResultEnum.PERMISSION_SAVE_CODE.getName());
        }
        Map<String,Object> map = new HashMap<>();
        map.put(SpConstantInter.TABLE_ID,sysPermission.getId());
        return map;
    }

    /**
     * 修改
     *
     * @param sysPermission
     */
    @Override
    public boolean modifyPermission(SysPermission sysPermission) {
        if (!SpAssert.isNotNull(getOne(new QueryWrapper<SysPermission>().eq(SpConstantInter.SYS_PERMISSION_NAME,sysPermission.getPerName()),false))) {
            return updateById(sysPermission);
        }else{
            throw new SaveException(ResultEnum.PERMISSION_SAVE_NAME.getValue(), ResultEnum.PERMISSION_SAVE_NAME.getName());
        }
    }

    /**
     * 查询角色权限
     *
     * @param sysPermissionVo
     */
    @Override
    public Result queryPerByUIdMIdRId(SysPermissionVo sysPermissionVo) {
        //校验参数
        SpAssert.isNull(sysPermissionVo);
        SpAssert.isNull(sysPermissionVo.getUserId());
        SpAssert.isNull(sysPermissionVo.getMenuId());
        SpAssert.isNull(sysPermissionVo.getRoleId());
        return new Result(sysPermissionMapper.queryPerByUIdMIdRId(sysPermissionVo));
    }
}
