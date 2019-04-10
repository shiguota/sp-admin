package com.evo.sp.business.system.entity;

import java.time.LocalDateTime;
import com.evo.sp.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 菜单权限表
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysMenuPermission extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单权限表id
     */
    private String id;

    private Integer sysMenuId;

    private String sysPermissionId;

    /**
     * 状态
     */
    private String state;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
