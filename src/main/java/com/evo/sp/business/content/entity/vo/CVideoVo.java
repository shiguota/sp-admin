package com.evo.sp.business.content.entity.vo;

import com.evo.sp.common.BaseEntity;
import com.evo.sp.common.BaseEntityVo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 视频内容基础信息表
 * </p>
 *
 * @author sgt
 * @since 2019-05-20
 */
public class CVideoVo extends BaseEntityVo {


    /**
     * Id
     */
    private String id;

    /**
     * 中文名称
     */
    private String cnName;

    /**
     * 英文名称
     */
    private String enName;

    /**
     * 制片地区
     */
    private String area;

    /**
     * 上映时间
     */
    private LocalDateTime onlineTime;

    /**
     * 评分
     */
    private Float score;

    /**
     * 简介
     */
    private String desc;

    /**
     * 语言
     */
    private String language;

    /**
     * 可用名
     */
    private String aliasName;

    /**
     * 曾用名
     */
    private String overName;

    /**
     * 创建人id
     */
    private String createUser;


}
