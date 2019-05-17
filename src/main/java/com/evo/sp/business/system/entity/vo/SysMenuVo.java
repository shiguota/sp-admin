package com.evo.sp.business.system.entity.vo;

import com.evo.sp.business.system.entity.SysMenuPermission;
import com.evo.sp.business.system.entity.SysPermission;
import com.evo.sp.common.BaseEntity;
import com.evo.sp.common.BaseEntityVo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
public class SysMenuVo extends BaseEntityVo {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单表id
     */
    private String id;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单编码
     */
    private String menuCode;

    /**
     * 图标
     */
    private String menuIcon;

    /**
     * 连接
     */
    private String menuPath;

    /**
     * 排序
     */
    private String sort;

    /**
     * 父id
     */
    private String pid;

    /**
     *
     *字典表id
     */
    private String systemDictionaryId;

    /**
     *
     * 级别
     */
    private Integer level;
    
    /**
     *
     *  菜单权限集合
     */
    private List<SysMenuPermission> sysMenuPermission;
    
    /**
     *
     * 权限集合
     */
    private List<SysPermission> pers;

    public List<SysPermission> getPers() {
        return pers;
    }

    public void setPers(List<SysPermission> pers) {
        this.pers = pers;
    }

    public List<SysMenuPermission> getSysMenuPermission() {
        return sysMenuPermission;
    }

    public void setSysMenuPermission(List<SysMenuPermission> sysMenuPermission) {
        this.sysMenuPermission = sysMenuPermission;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getMenuPath() {
        return menuPath;
    }

    public void setMenuPath(String menuPath) {
        this.menuPath = menuPath;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getSystemDictionaryId() {
        return systemDictionaryId;
    }

    public void setSystemDictionaryId(String systemDictionaryId) {
        this.systemDictionaryId = systemDictionaryId;
    }
}
