package com.evo.sp.business.system.service.impl;

import com.evo.sp.business.system.entity.SystemUser;
import com.evo.sp.business.system.mapper.SystemUserMapper;
import com.evo.sp.business.system.service.ISystemUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.evo.sp.common.SpAssert;
import com.evo.sp.common.annotations.SpLogService;
import com.evo.sp.common.ex.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sgt
 * @since 2019-04-01
 */
@Service
public class SystemUserServiceImpl extends ServiceImpl<SystemUserMapper, SystemUser> implements ISystemUserService {

    @Autowired
    private SystemUserMapper spUserMapper;

    @Override
    @SpLogService(description = "这是一个测试")
    public SystemUser userByname(String name) throws BaseException {
        SpAssert.isNull(name);
        SystemUser spUser = spUserMapper.userByname(name);
        return spUser;
    }
}