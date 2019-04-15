package com.evo.sp.business.system.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.evo.sp.business.system.entity.SysMenuPermission;
import com.evo.sp.common.BaseEntity;
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
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysPermissionVo extends BaseEntity {

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
     *
     *  菜单权限表
     */
    private SysMenuPermission sysMenuPermission;

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
}
