package com.evo.sp.business.content.entity.vo;

import com.evo.sp.common.BaseEntity;
import com.evo.sp.common.BaseEntityVo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 视频资源信息表
 * </p>
 *
 * @author sgt
 * @since 2019-05-20
 */
public class RVideoVo extends BaseEntityVo {

    private static final long serialVersionUID = 1L;

    /**
     * 视频属性表id
     */
    private String id;

    /**
     * 视频格式（字典id）
     */
    private String format;

    /**
     * 视频大小
     */
    private String size;

    /**
     * 视频时长
     */
    private String timeLen;

    /**
     * 分辨率
     */
    private String resolution;

    /**
     * 清晰度 （字典管理）
     */
    private Integer clarity;

    /**
     * 片头时长(单位秒)
     */
    private Integer videoOpening;

    /**
     * 片尾时长(单位秒)
     */
    private Integer videoEnding;

    /**
     *
     * 路径
     */
    private String url;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 码率
     */
    private String bitRate;


}
