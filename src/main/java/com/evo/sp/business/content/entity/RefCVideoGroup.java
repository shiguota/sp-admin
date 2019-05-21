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
public class RefCVideoGroup extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 视频内容id
     */
    private String cVideoId;

    /**
     * 视频资源组id
     */
    private String groupId;

    /**
     * id
     */
    private String id;

}
