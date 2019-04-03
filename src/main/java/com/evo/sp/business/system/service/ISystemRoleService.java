package com.evo.sp.business.system.service;

import com.evo.sp.business.system.entity.SystemRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.evo.sp.common.ex.BaseException;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sgt
 * @since 2019-03-27
 */
public interface ISystemRoleService extends IService<SystemRole> {
    /**
     * @Description:通过用户名称获取当前用户拥有的角色
     * @Param:
     * @return:
     */
    List<SystemRole> getRoleByUname(String name) throws BaseException;
}
