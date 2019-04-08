package com.evo.sp.business.system.entity;

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
 * @since 2019-04-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SystemMenu extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单编码
     */
    private String code;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 菜单连接
     */
    private String path;

    /**
     * 状态
     */
    private Integer state;

    /**
     * 排序
     */
    private Integer sort;

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


}
