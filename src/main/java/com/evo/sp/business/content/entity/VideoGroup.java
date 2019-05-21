package com.evo.sp.business.content.entity;

import java.time.LocalDateTime;
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
 * @since 2019-05-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class VideoGroup extends BaseEntity {

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
