package com.evo.sp.business.content.entity.vo;

import com.evo.sp.common.BaseEntity;
import com.evo.sp.common.BaseEntityVo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author sgt
 * @since 2019-05-20
 */
public class VideoGroupVo extends BaseEntityVo {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;

    /**
     *
     * 资源组名称
     */
    private String name;

    /**
     * 集数
     */
    private Integer countNumber;

    /**
     * 简介
     */
    private String desc;

    /**
     * 类型（字典管理）
     */
    private Integer type;

    /**
     * 上线时间
     */
    private LocalDateTime onlineTime;

    /**
     * 下线时间
     */
    private LocalDateTime offlineTime;

    /**
     * 总集数
     */
    private Integer totalNumber;


}
