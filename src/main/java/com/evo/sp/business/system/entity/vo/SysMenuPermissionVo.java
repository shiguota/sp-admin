package com.evo.sp.business.system.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.evo.sp.common.BaseEntity;
import com.evo.sp.common.BaseEntityVo;
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
public class SysMenuPermissionVo extends BaseEntityVo {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单权限表id
     */
    private String id;
    /**
     * 菜单id
     */
    private String sysMenuId;
    /**
     * 权限id
     */
    private String sysPermissionId;

    /**
     *
     * 权限id数组
     */
    private String[] perIds;

    public String[] getPerIds() {
        return perIds;
    }

    public void setPerIds(String[] perIds) {
        this.perIds = perIds;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSysMenuId() {
        return sysMenuId;
    }

    public void setSysMenuId(String sysMenuId) {
        this.sysMenuId = sysMenuId;
    }

    public String getSysPermissionId() {
        return sysPermissionId;
    }

    public void setSysPermissionId(String sysPermissionId) {
        this.sysPermissionId = sysPermissionId;
    }
}
