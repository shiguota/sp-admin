package com.evo.sp.business.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evo.sp.business.system.entity.SystemUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.evo.sp.common.ex.BaseException;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author sgt
 * @since 2019-04-01
 */
public interface ISystemUserService extends IService<SystemUser> {
    /**
     *
     * 通过用户名获取密码
     */
    SystemUser userByname(String name) throws BaseException;


}
