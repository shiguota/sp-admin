package com.evo.sp.business.content.entity;

import java.time.LocalDateTime;
import com.evo.sp.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 资源（图）表
 * </p>
 *
 * @author sgt
 * @since 2019-05-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class RImg extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * Id
     */
    private String id;

    /**
     * 名称
     */
    private String imageName;

    /**
     * 简称
     */
    private String shortName;

    /**
     * 创建人id
     */
    private String userId;


}
