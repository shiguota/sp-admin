package com.evo.sp.business.content.entity;

import java.time.LocalDateTime;
import com.evo.sp.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 栏目绘本关联表
 * </p>
 *
 * @author sgt
 * @since 2019-05-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class RefBookColumn extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 绘本id
     */
    private String bookId;
    /**
     *
     * id
     */
    private String id;

    /**
     * 栏目id
     */
    private String columnId;


}
