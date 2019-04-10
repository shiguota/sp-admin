package com.evo.sp.business.system.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.evo.sp.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 区域表
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysArea extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 区域名称
     */
    private String areaName;

    /**
     * 简称
     */
    private String shortName;

    /**
     * 经度
     */
    private BigDecimal lon;

    /**
     * 纬度
     */
    private BigDecimal lat;

    /**
     * 级别
     */
    private Integer level;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 父id
     */
    private String pid;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
