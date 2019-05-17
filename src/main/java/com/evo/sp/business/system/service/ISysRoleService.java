package com.evo.sp.business.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evo.sp.business.system.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.evo.sp.business.system.entity.vo.SysRoleVo;
import com.evo.sp.common.result.Result;

import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
public interface ISysRoleService extends IService<SysRole> {
    /**
     *
     * 根据账号获取角色
     */
    List<SysRole> queryRoleByAccount(String account);

    /**
     *
     * 根据组织（机构）id查询角色
     */
    Result queryByNameOrg(Page page,SysRoleVo sysRoleVo);
    
    /**
     *
     * 新增角色
     */
    Result saveRole(SysRoleVo sysRoleVo);
    
    /**
     *
     * 为角色授权
     */
    Result authorizationRole(SysRoleVo sysRoleVo);

    /**
     *
     * 修改角色
     */
    Result modifyRole(SysRoleVo sysRoleVo);
    
    /**
     *
     * 删除角色
     */
    Result delRoles(List<String> ids);

}
