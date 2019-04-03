package com.evo.sp.business.system.entity.vo;

import java.io.Serializable;

public class SystemRolePermissionsVo implements Serializable {

    /**
     * 权限标识
     */
    private String permissionTag;

    /**
     * 角色名称
     */
    private String roleName;


    public String getPermissionTag() {
        return permissionTag;
    }

    public void setPermissionTag(String permissionTag) {
        this.permissionTag = permissionTag;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
