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
public class SpPermissions extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名称
     */
    private String name;

    /**
     * 创建用户id
     */
    private String createUserId;


    /**
     * 更新用户id
     */
    private String updateUserId;

    /**
     * 权限标识
     */
    private String permissionsTag;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String getPermissionsTag() {
        return permissionsTag;
    }

    public void setPermissionsTag(String permissionsTag) {
        this.permissionsTag = permissionsTag;
    }
}
