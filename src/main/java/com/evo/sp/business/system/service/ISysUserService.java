package com.evo.sp.business.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evo.sp.business.system.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.evo.sp.business.system.entity.vo.SysRoleVo;
import com.evo.sp.business.system.entity.vo.SysUserVo;
import com.evo.sp.common.result.Result;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
public interface ISysUserService extends IService<SysUser> {
    
    
    /**
     *
     * 新增用户
     */
    Result saveUser(SysUserVo sysUserVo);

    /**
     *
     * 查询用户信息，根据组织（机构）id
     */
    Result queryUserByOrg(Page page, SysUserVo userVo);
    
    /**
     *
     * 查询用户信息通过id
     */
    Result queryUserById(String id);

    /**
     *
     * 根据用户id获取账号已存在的角色
     */
    Result queryRoleById(String id);

    /**
     *通过当前登录账号的信息，获取当前账号下的角色（不包括，已经分配给选中的当前账号的角色）
     *
     * @param loginId 当前登录系统的用户id
     * @param seleId  被选中账号的用户id
     */
    Result queryUnRoleById(String loginId,String seleId);
}
