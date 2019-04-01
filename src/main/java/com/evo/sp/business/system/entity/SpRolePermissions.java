package com.evo.sp.business.system.entity;

import java.time.LocalDateTime;
import com.evo.sp.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author sgt
 * @since 2019-03-27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SpRolePermissions extends BaseEntity {

    private static final long serialVersionUID = 1L;


    /**
     * 权限id
     */
    private String permissionsId;

    /**
     * 角色id
     */
    private String roleId;

    /**
     * 创建用户id
     */
    private String createUserId;

    /**
     * 修改用户id
     */
    private String updateSuerId;

    public String getPermissionsId() {
        return permissionsId;
    }

    public void setPermissionsId(String permissionsId) {
        this.permissionsId = permissionsId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getUpdateSuerId() {
        return updateSuerId;
    }

    public void setUpdateSuerId(String updateSuerId) {
        this.updateSuerId = updateSuerId;
    }
}
