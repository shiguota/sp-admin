package com.evo.sp.business.content.entity;

import java.time.LocalDateTime;
import com.evo.sp.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 绘本图片关联
 * </p>
 *
 * @author sgt
 * @since 2019-05-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class RefBookImg extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     *
     * id
     */
    private String id;
    /**
     * 绘本表id
     */
    private String bookId;

    /**
     * 图片id
     */
    private String imgId;

}
