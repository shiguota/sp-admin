package com.evo.sp.business.system.service;

import com.evo.sp.business.system.entity.SysUserRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.evo.sp.business.system.entity.vo.SysUserRoleVo;
import com.evo.sp.common.result.Result;

/**
 * <p>
 * 用户角色表 服务类
 * </p>
 *
 * @author sgt
 * @since 2019-04-17
 */
public interface ISysUserRoleService extends IService<SysUserRole> {

    
    /**
     *
     * 用户分配角色
     */
    Result saveUserRole(SysUserRoleVo sysUserRoleVo);

}
