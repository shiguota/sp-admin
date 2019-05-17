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
    private String[] permissionId;

    /**
     * 角色id
     */
    private String sysRoleId;

    public String[] getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String[] permissionId) {
        this.permissionId = permissionId;
    }

    public String getSysRoleId() {
        return sysRoleId;
    }

    public void setSysRoleId(String sysRoleId) {
        this.sysRoleId = sysRoleId;
    }
}
