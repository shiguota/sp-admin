package com.evo.sp.business.content.entity;

import java.time.LocalDateTime;
import com.evo.sp.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 版权信息表
 * </p>
 *
 * @author sgt
 * @since 2019-05-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class RVideoCopyright extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 制片方
     */
    private String production;

    /**
     * 许可证
     */
    private String license;

    /**
     * 备案号
     */
    private String sn;

    /**
     * 版权方
     */
    private String authorization;

    /**
     * 版权适用范围
     */
    private String authorizationScope;

    /**
     * 版权开始时间
     */
    private LocalDateTime authorizationStart;

    /**
     * 版权结束时间
     */
    private LocalDateTime authorizationEnd;

    /**
     * 视频id
     */
    private String videoId;


}
