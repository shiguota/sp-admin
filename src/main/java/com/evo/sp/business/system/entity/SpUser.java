package com.evo.sp.business.system.entity;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2019-04-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SpUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名（登录账号）
     */
    private String name;

    /**
     * 生日
     */
    private LocalDateTime birthday;

    /**
     * 密码
     */
    private String password;

    /**
     * 电话号
     */
    private String phone;

    /**
     * 省份证号
     */
    @TableField("Id_card")
    private String idCard;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 微信账号
     */
    private String wxAccount;

    /**
     * qq账号
     */
    private String qqAccount;

    /**
     * 身高
     */
    private Integer height;

    /**
     * 微信openid
     */
    @TableField("wx_openId")
    private String wxOpenid;

    /**
     * 体重
     */
    private Integer weight;

    /**
     * 民族
     */
    private String national;

    /**
     * 微博账号
     */
    private String wbAccount;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 性别 0女  1男  2保密
     */
    private Integer sex;

    /**
     * 最后登录时间
     */
    private LocalDateTime lastLoginTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getWxAccount() {
        return wxAccount;
    }

    public void setWxAccount(String wxAccount) {
        this.wxAccount = wxAccount;
    }

    public String getQqAccount() {
        return qqAccount;
    }

    public void setQqAccount(String qqAccount) {
        this.qqAccount = qqAccount;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getWxOpenid() {
        return wxOpenid;
    }

    public void setWxOpenid(String wxOpenid) {
        this.wxOpenid = wxOpenid;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public String getWbAccount() {
        return wbAccount;
    }

    public void setWbAccount(String wbAccount) {
        this.wbAccount = wbAccount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public LocalDateTime getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(LocalDateTime lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}
