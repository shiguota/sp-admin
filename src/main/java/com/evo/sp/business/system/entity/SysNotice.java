package com.evo.sp.business.system.entity;

import java.time.LocalDateTime;
import com.evo.sp.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 通知表
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysNotice extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 通知表id
     */
    private String id;

    /**
     * 状态
     */
    private Integer state;

    private String template;

    /**
     * 阀值
     */
    private Integer threshold;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 通知类型（关联字典表id）
     */
    private String sysDictionaryId;


}
