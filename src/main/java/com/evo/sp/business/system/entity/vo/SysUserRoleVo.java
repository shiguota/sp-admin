package com.evo.sp.business.system.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.evo.sp.common.BaseEntity;
import com.evo.sp.common.BaseEntityVo;
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
public class SysUserRoleVo extends BaseEntityVo {

    private static final long serialVersionUID = 1L;

    /**
     *
     * id
     */
    private String  id;

    /**
     * 角色id
     */
    private String sysRoleId;

    /**
     * 用户表id
     */
    private String sysUserId;

    /**
     *
     * 角色id集合
     */
    private String[] roleId;

    public String[] getRoleId() {
        return roleId;
    }

    public void setRoleId(String[] roleId) {
        this.roleId = roleId;
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
