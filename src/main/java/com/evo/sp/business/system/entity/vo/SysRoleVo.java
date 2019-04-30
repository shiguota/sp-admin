package com.evo.sp.business.system.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.evo.sp.business.system.entity.SysOrganizationRole;
import com.evo.sp.business.system.entity.SysRolePermission;
import com.evo.sp.common.BaseEntity;
import com.evo.sp.common.BaseEntityVo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
public class SysRoleVo extends BaseEntityVo {
    
    /**
     *
     * 角色id
     */
    private String roleId;

    /**
     *
     * 组织（机构）id
     */
    private String orgId;
    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色编码
     */
    private String roleCode;

    /**
     *
     * 角色描述
     */
    private String roleDescription;

    /**
     *
     * 角色权限
     */
    private List<SysRolePermission> sysRolePermission;


    public List<SysRolePermission> getSysRolePermission() {
        return sysRolePermission;
    }

    public void setSysRolePermission(List<SysRolePermission> sysRolePermission) {
        this.sysRolePermission = sysRolePermission;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

}
