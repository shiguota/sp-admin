package com.evo.sp.business.system.mapper;

import com.evo.sp.business.system.entity.SysPermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.evo.sp.business.system.entity.vo.SysPermissionVo;

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

    /**
     *
     * 根据用户账号以及菜单id，获取该菜单下，当前用户拥有的权限
     * @param menuId 菜单id
     * @param account 用户账号
     */
    List<SysPermission> queryPerByMenuUser(String menuId,String account);

    /**
     *
     * 获取当前登录账号以及被勾选账号的某个菜单的权限差集
     */
    List<SysPermission> queryPerByMenuUserDifSet(SysPermissionVo sysPermissionVo);
}
