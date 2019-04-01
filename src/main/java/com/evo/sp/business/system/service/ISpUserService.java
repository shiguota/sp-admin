package com.evo.sp.business.system.service;

import com.evo.sp.business.system.entity.SpUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.evo.sp.common.ex.BaseException;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sgt
 * @since 2019-04-01
 */
public interface ISpUserService extends IService<SpUser> {
    /**
     * @Description: 通过用户名获取密码
     * @Param:
     * @return:
     * @Author: sgt
     * @Date: 2019-03-28
     */
    SpUser userByname(String name) throws BaseException;
}
