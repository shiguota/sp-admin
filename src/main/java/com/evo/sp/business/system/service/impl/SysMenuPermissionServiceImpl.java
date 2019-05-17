package com.evo.sp.business.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.evo.sp.business.system.entity.SysMenuPermission;
import com.evo.sp.business.system.entity.SysRolePermission;
import com.evo.sp.business.system.entity.vo.SysMenuPermissionVo;
import com.evo.sp.business.system.mapper.SysMenuPermissionMapper;
import com.evo.sp.business.system.service.ISysMenuPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.ex.DelException;
import com.evo.sp.common.ex.SaveException;
import com.evo.sp.common.ex.SpAssert;
import com.evo.sp.common.result.Result;
import com.evo.sp.common.result.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 菜单权限表 服务实现类
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
@Service
public class SysMenuPermissionServiceImpl extends ServiceImpl<SysMenuPermissionMapper, SysMenuPermission> implements ISysMenuPermissionService {

    @Autowired
    private SysMenuPermissionMapper sysMenuPermissionMapper;

    /**
     * 菜单授权
     * @param sysMenuPermissionVo
     */
    @Override
    public Result saveMenuPermission(SysMenuPermissionVo sysMenuPermissionVo) {
        //校验参数
        SpAssert.isNull(sysMenuPermissionVo);
        SpAssert.isNull(sysMenuPermissionVo.getPerIds());
        SpAssert.isNull(sysMenuPermissionVo.getSysMenuId());
        //创建菜单权限集合
        List<SysMenuPermission> sysRolePermissions = new ArrayList<>();
        QueryWrapper<SysMenuPermission> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SpConstantInter.SYS_MENU_PERMISSION_MENUID,sysMenuPermissionVo.getSysMenuId());
        //清空当前菜单拥有的权限
        if (remove(queryWrapper)) {
            //获取权限数组
            String[] permissionId = sysMenuPermissionVo.getPerIds();
            //遍历菜单权限数组
            for (String s : permissionId) {
                sysRolePermissions.add(new SysMenuPermission(sysMenuPermissionVo.getSysMenuId(),s));
            }
        }else{
            throw new DelException(ResultEnum.PERMISSION_DEL_FAIL.getValue(),ResultEnum.PERMISSION_DEL_FAIL.getName());
        }
        if (!super.saveBatch(sysRolePermissions)) {
            throw new SaveException();
        }
        return new Result(true);
    }
}
