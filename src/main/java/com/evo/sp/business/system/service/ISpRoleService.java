package com.evo.sp.business.system.service;

import com.evo.sp.business.system.entity.SpRole;
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
public interface ISpRoleService extends IService<SpRole> {
    /**
     * @Description:通过用户名称获取当前用户拥有的角色
     * @Param:
     * @return:
     * @Author: 史国涛
     * @Date: 2019-03-28
     */
    List<SpRole> getRoleByUname(String name) throws BaseException;
}
