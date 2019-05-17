package com.evo.sp.business.system.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysRolePermission extends BaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     *
     * id
     */
    @TableId(type = IdType.UUID)
    private String id;

    /**
     * 角色权限表id
     */
    private String sysPermissionId;

    /**
     * 角色id
     */
    private String sysRoleId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSysPermissionId() {
        return sysPermissionId;
    }

    public void setSysPermissionId(String sysPermissionId) {
        this.sysPermissionId = sysPermissionId;
    }

    public String getSysRoleId() {
        return sysRoleId;
    }

    public void setSysRoleId(String sysRoleId) {
        this.sysRoleId = sysRoleId;
    }

    public SysRolePermission(String sysPermissionId, String sysRoleId) {
        this.sysPermissionId = sysPermissionId;
        this.sysRoleId = sysRoleId;
    }

    public SysRolePermission(String sysRoleId) {
        this.sysRoleId = sysRoleId;
    }

    public SysRolePermission() {
    }
}
