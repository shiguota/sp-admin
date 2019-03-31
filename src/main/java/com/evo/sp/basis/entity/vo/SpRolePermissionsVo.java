package com.evo.sp.basis.entity.vo;

import java.io.Serializable;

public class SpRolePermissionsVo implements Serializable {

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
