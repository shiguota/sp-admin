package com.evo.sp.business.content.entity;

import java.time.LocalDateTime;
import com.evo.sp.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 音频属性表
 * </p>
 *
 * @author sgt
 * @since 2019-05-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class RAudio extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 音频格式
     */
    private String format;

    /**
     * 音频比特率
     */
    private String bitRate;

    /**
     * 音频编码
     */
    private String code;

    /**
     * 声道
     */
    private Integer channel;

    /**
     * 供应商
     */
    private String supplier;


}
