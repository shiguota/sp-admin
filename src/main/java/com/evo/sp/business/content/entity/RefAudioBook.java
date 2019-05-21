package com.evo.sp.business.content.entity;

import java.time.LocalDateTime;
import com.evo.sp.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 绘本与音频关联表
 * </p>
 *
 * @author sgt
 * @since 2019-05-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class RefAudioBook extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 音频id
     */
    private String audioId;

    /**
     * 绘本id
     */
    private String bookId;

    /**
     * id
     */
    private String id;


}
