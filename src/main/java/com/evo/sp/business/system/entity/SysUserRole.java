package com.evo.sp.business.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.evo.sp.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户角色表
 * </p>
 *
 * @author sgt
 * @since 2019-04-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysUserRole extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     *
     * id
     */
    @TableId(type = IdType.UUID)
    private String  id;

    /**
     * 角色id
     */
    private String sysRoleId;

    /**
     * 用户表id
     */
    private String sysUserId;


    public SysUserRole() {
    }

    public SysUserRole(String sysRoleId, String sysUserId) {
        this.sysRoleId = sysRoleId;
        this.sysUserId = sysUserId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSysRoleId() {
        return sysRoleId;
    }

    public void setSysRoleId(String sysRoleId) {
        this.sysRoleId = sysRoleId;
    }

    public String getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(String sysUserId) {
        this.sysUserId = sysUserId;
    }
}
