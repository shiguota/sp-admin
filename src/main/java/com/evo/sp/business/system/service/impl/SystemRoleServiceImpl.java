package com.evo.sp.business.system.service.impl;

import com.evo.sp.business.system.entity.SystemRole;
import com.evo.sp.business.system.mapper.SystemRoleMapper;
import com.evo.sp.business.system.service.ISystemRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.evo.sp.common.ex.SpAssert;
import com.evo.sp.common.ex.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sgt
 * @since 2019-03-27
 */
@Service
public class SystemRoleServiceImpl extends ServiceImpl<SystemRoleMapper, SystemRole> implements ISystemRoleService {

    @Autowired
    private SystemRoleMapper spRoleMapper;
    @Override
    public List<SystemRole> getRoleByUname(String name) throws BaseException {
        SpAssert.isNull(name);
        List<SystemRole> roleByUnames = spRoleMapper.getRoleByUname(name);
        return roleByUnames;
    }
}
