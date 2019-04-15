package com.evo.sp.business.system.service;

import com.evo.sp.business.system.entity.SysPermission;
import com.baomidou.mybatisplus.extension.service.IService;
import com.evo.sp.business.system.entity.vo.SysPermissionVo;
import com.evo.sp.common.result.Result;

import java.util.List;

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
}
