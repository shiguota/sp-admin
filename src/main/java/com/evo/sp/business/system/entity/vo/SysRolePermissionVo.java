package com.evo.sp.business.system.entity.vo;

import com.evo.sp.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色权限表
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */

public class SysRolePermissionVo  {

    /**
     * 角色权限表id
     */
    private String[] sysMenuHasSysPermissionId;

    /**
     * 角色id
     */
    private String sysRoleId;

    public String[] getSysMenuHasSysPermissionId() {
        return sysMenuHasSysPermissionId;
    }

    public void setSysMenuHasSysPermissionId(String[] sysMenuHasSysPermissionId) {
        this.sysMenuHasSysPermissionId = sysMenuHasSysPermissionId;
    }

    public String getSysRoleId() {
        return sysRoleId;
    }

    public void setSysRoleId(String sysRoleId) {
        this.sysRoleId = sysRoleId;
    }
}
