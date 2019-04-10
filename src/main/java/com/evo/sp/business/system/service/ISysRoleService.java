package com.evo.sp.business.system.service;

import com.evo.sp.business.system.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

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
    List<SysRole> getRoleByAccount(String account);
}
