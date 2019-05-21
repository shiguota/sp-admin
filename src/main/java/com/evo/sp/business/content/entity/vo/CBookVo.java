package com.evo.sp.business.content.entity.vo;

import com.evo.sp.common.BaseEntity;
import com.evo.sp.common.BaseEntityVo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 绘本表
 * </p>
 *
 * @author sgt
 * @since 2019-05-20
 */
public class CBookVo extends BaseEntityVo {

    private static final long serialVersionUID = 1L;

    /**
     * 图书表id
     */
    private String id;

    /**
     * 序号
     */
    private String number;

    /**
     * 名称
     */
    private String name;

    /**
     * 作者(人物表管理)
     */
    private String actor;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 编辑
     */
    private String editor;

    /**
     * 简介
     */
    private String desc;

    /**
     * 适合年龄段
     */
    private String ageAppropriate;

    /**
     * 适用群体
     */
    private String suitsCrowd;

    /**
     * 出版社
     */
    private String press;

    /**
     * 出版日期
     */
    private LocalDateTime publicationData;

    /**
     * 语言
     */
    private String language;

    /**
     * 数量
     */
    private Integer count;

    /**
     * 供应商
     */
    private String supplier;

    /**
     * 是否录音
     */
    private Integer isRecord;

    /**
     * 创建人id
     */
    private String userId;


}
