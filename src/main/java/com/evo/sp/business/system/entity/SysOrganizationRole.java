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
 * @since 2019-04-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysOrganizationRole extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 组织机构id
     */
    private String sysOrganizationId;

    /**
     * 角色
     */
    private String sysRoleId;


    public String getSysOrganizationId() {
        return sysOrganizationId;
    }

    public void setSysOrganizationId(String sysOrganizationId) {
        this.sysOrganizationId = sysOrganizationId;
    }

    public String getSysRoleId() {
        return sysRoleId;
    }

    public void setSysRoleId(String sysRoleId) {
        this.sysRoleId = sysRoleId;
    }
}
