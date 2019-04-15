package com.evo.sp.business.system.mapper;

import com.evo.sp.business.system.entity.SysPermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 权限表 Mapper 接口
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
public interface SysPermissionMapper extends BaseMapper<SysPermission> {
    /**
     *
     * 根据角色编码获取权限
     */
    List<SysPermission> queryPermissionsByCode(String roleCode);

    /**
     *
     * 根据菜单获取权限
     */
    List<SysPermission> queryPerByMenuId(String menuId);
}
