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
public class RefVideoImg extends BaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 图片id
     */
    private String imgId;
    /**
     * id
     */
    private String id;

    /**
     * 视频id
     */
    private String videoId;
}
