package com.evo.sp.business.system.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.evo.sp.business.system.entity.SysUserInfo;
import com.evo.sp.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
public class SysUserVo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户类型
     */
    private Integer userType;

    /**
     * 组织机构表关联id
     */
    private String sysOrganizationId;

    /**
     * 用户信息id
     */
    private String sysUserInfoId;

    /**
     *
     * 用户信息
     */
    private SysUserInfo info;

    public SysUserInfo getInfo() {
        return info;
    }

    public void setInfo(SysUserInfo info) {
        this.info = info;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getSysOrganizationId() {
        return sysOrganizationId;
    }

    public void setSysOrganizationId(String sysOrganizationId) {
        this.sysOrganizationId = sysOrganizationId;
    }

    public String getSysUserInfoId() {
        return sysUserInfoId;
    }

    public void setSysUserInfoId(String sysUserInfoId) {
        this.sysUserInfoId = sysUserInfoId;
    }


    public SysUserVo() {
    }

    public SysUserVo(String account) {
        this.account = account;
    }
}
