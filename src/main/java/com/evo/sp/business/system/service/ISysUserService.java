package com.evo.sp.business.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evo.sp.business.system.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
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
     * 查询用户信息，根据组织（机构）id
     */
    Result queryUserByOrg(Page page, SysUserVo userVo);
    
    /**
     *
     * 查询用户信息通过id
     */
    Result queryUserById(Serializable id);
}
