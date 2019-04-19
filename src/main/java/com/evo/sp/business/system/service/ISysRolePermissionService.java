package com.evo.sp.business.system.service;

import com.evo.sp.business.system.entity.SysRolePermission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 角色权限表 服务类
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
public interface ISysRolePermissionService extends IService<SysRolePermission> {

    /**
     *
     * 批量保存
     */
   boolean saveBatch(List<SysRolePermission> sysRolePermission);
}
