package com.evo.sp.business.system.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.evo.sp.business.system.entity.SysMenuPermission;
import com.evo.sp.common.BaseEntity;
import com.evo.sp.common.BaseEntityVo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */

public class SysPermissionVo extends BaseEntityVo {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 权限名称
     */
    private String perName;

    /**
     * 权限编码
     */
    private String perCode;

    /**
     * 菜单id
     */
    private String menuId;

    /**
     * 系统当前登录用户id
     */
    private String LUserId;

    /**
     * 用户id
     */
    private String userId;

    /**
     *
     *  角色id
     */
    private String roleId;
    
    /**
     *
     *   权限是否存在（当前角色）
     */
    private String isExist;

    /**
     * 菜单权限表
     */
    private SysMenuPermission sysMenuPermission;


    public String getIsExist() {
        return isExist;
    }

    public void setIsExist(String isExist) {
        this.isExist = isExist;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public SysMenuPermission getSysMenuPermission() {
        return sysMenuPermission;
    }

    public void setSysMenuPermission(SysMenuPermission sysMenuPermission) {
        this.sysMenuPermission = sysMenuPermission;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPerName() {
        return perName;
    }

    public void setPerName(String perName) {
        this.perName = perName;
    }

    public String getPerCode() {
        return perCode;
    }

    public void setPerCode(String perCode) {
        this.perCode = perCode;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getLUserId() {
        return LUserId;
    }

    public void setLUserId(String LUserId) {
        this.LUserId = LUserId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
