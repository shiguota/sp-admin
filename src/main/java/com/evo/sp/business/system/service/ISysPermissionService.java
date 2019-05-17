package com.evo.sp.business.system.service;

import com.evo.sp.business.system.entity.SysPermission;
import com.baomidou.mybatisplus.extension.service.IService;
import com.evo.sp.business.system.entity.vo.SysPermissionVo;
import com.evo.sp.common.result.Result;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 权限表 服务类
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
public interface ISysPermissionService extends IService<SysPermission> {

    /**
     *
     * 根据角色编码获取权限
     */
    List<SysPermission> queryPermissionsByCode(String roleCode);
    
    /**
     *
     * 新增权限
     */
    Result savePermission(SysPermissionVo sysPermissionVo);

    /**
     *
     * 根据菜单获取权限
     */
    Result queryPerByMenuId(String menuId);

    /**
     *
     *根据当前登录用户以及菜单id，获取该菜单下，当前用户拥有的权限
     * @param menuId 菜单id
     * @param userId 用户id
     */
    Result queryPerByMenuUser(String menuId,String userId);

    /**
     *
     * 获取当前登录账号以及被勾选账号的某个菜单的权限差集
     */
    Result queryPerByMenuUserDifSet(SysPermissionVo sysPermissionVo);

    /**
     *
     * 新增（返回id）
     */
    Map<String, Object> savePerBackId(SysPermission sysPermission);
    
    /**
     *
     * 修改
     */
   boolean modifyPermission(SysPermission sysPermission);


   /**
    *
    * 查询角色权限
    */
   Result queryPerByUIdMIdRId(SysPermissionVo sysPermissionVo);

}
