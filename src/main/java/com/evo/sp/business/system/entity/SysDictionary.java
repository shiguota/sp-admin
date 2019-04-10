package com.evo.sp.business.system.entity;

import java.time.LocalDateTime;
import com.evo.sp.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 字典表
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysDictionary extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 字典表id
     */
    private String id;

    /**
     * 名称
     */
    private String dicName;

    /**
     * 编码
     */
    private String dicCode;

    /**
     * 排序
     */
    private Integer dicSort;

    /**
     * 状态
     */
    private Integer state;

    /**
     * 父id
     */
    private String pid;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 级别
     */
    private Integer level;


}
