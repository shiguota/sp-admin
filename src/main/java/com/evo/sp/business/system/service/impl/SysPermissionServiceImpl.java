package com.evo.sp.business.system.service.impl;

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
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
     * 根据用户账号以及菜单id，获取该菜单下，当前用户拥有的权限
     *
     * @param menuId  菜单id
     * @param account 用户账号
     */
    @Override
    public Result queryPerByMenuUser(String menuId, String account) {
        SpAssert.isNull(menuId);
        SpAssert.isNull(account);
        return new Result(sysPermissionMapper.queryPerByMenuUser(menuId,account));
    }

    /**
     * 获取当前登录账号以及被勾选账号的某个菜单的权限差集
     * @param sysPermissionVo
     */
    @Override
    public Result queryPerByMenuUserDifSet(SysPermissionVo sysPermissionVo) {
        SpAssert.isNull(sysPermissionVo);
        SpAssert.isNull(sysPermissionVo.getMenuId());
        SpAssert.isNull(sysPermissionVo.getLAccount());
        SpAssert.isNull(sysPermissionVo.getAccount());
        return new Result(sysPermissionMapper.queryPerByMenuUserDifSet(sysPermissionVo));
    }
}
