package com.evo.sp.business.system.entity;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import com.evo.sp.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysUserInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private String id;

    /**
     * 生日
     */
    private LocalDateTime birthday;

    /**
     * 电话
     */
    private String phone;

    /**
     * 身份证号
     */
    private String caid;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 微信账号
     */
    private String wxAccount;

    /**
     * Qq账号
     */
    private String qqAccount;

    /**
     * 身高(单位CM)
     */
    private Integer height;

    /**
     * 微信openid
     */
    @TableField("wx_openId")
    private String wxOpenid;

    /**
     * 体重(公斤)
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
     * 电子邮件
     */
    private String email;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 签名
     */
    private String sig;


}
