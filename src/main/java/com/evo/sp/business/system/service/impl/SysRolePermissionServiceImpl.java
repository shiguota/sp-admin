package com.evo.sp.business.system.service.impl;

import com.evo.sp.business.system.entity.SysRolePermission;
import com.evo.sp.business.system.mapper.SysRolePermissionMapper;
import com.evo.sp.business.system.service.ISysRolePermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.evo.sp.common.ex.SpAssert;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色权限表 服务实现类
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
@Service
public class SysRolePermissionServiceImpl extends ServiceImpl<SysRolePermissionMapper, SysRolePermission> implements ISysRolePermissionService {


    /**
     * 批量保存
     *
     * @param sysRolePermission
     */
    @Override
    public boolean saveBatch(List<SysRolePermission> sysRolePermission) {
        SpAssert.isNull(sysRolePermission);
        return saveBatch(sysRolePermission);
    }
}
