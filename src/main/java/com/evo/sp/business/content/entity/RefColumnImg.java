package com.evo.sp.business.content.entity;

import java.time.LocalDateTime;
import com.evo.sp.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 栏目图片关联表
 * </p>
 *
 * @author sgt
 * @since 2019-05-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class RefColumnImg extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 图片id
     */
    private String imgId;

    /**
     * 栏目id
     */
    private String columnId;

    /**
     * id
     */
    private String id;

}
