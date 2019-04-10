package com.evo.sp.business.system.entity;

import java.time.LocalDateTime;
import com.evo.sp.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 组织机构表
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysOrganization extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 组织机构表id
     */
    private String id;

    /**
     * 名称
     */
    private String orgName;

    /**
     * 排序字段
     */
    private Integer orgSort;

    /**
     * 级别
     */
    private Integer orgLevel;

    /**
     * 父id
     */
    private String pid;

    /**
     * 状态
     */
    private Integer state;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 区域表id
     */
    private String sysAreaId;


}
