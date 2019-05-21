package com.evo.sp.business.content.entity;

import java.time.LocalDateTime;
import com.evo.sp.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 视频签表
 * </p>
 *
 * @author sgt
 * @since 2019-05-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class RTag extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String id;
    /**
     * 内容基础表id
     */
    private String videoId;

    /**
     * 字典表id
     */
    private String disId;

    /**
     * 父id
     */
    private String pid;

    /**
     * 编码
     */
    private String code;

    /**
     * 排序
     */
    private Integer sort;


}
