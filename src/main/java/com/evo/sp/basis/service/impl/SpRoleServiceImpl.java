package com.evo.sp.basis.service.impl;

import com.evo.sp.basis.entity.SpRole;
import com.evo.sp.basis.mapper.SpRoleMapper;
import com.evo.sp.basis.service.ISpRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.evo.sp.common.SpAssert;
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
public class SpRoleServiceImpl extends ServiceImpl<SpRoleMapper, SpRole> implements ISpRoleService {

    @Autowired
    private SpRoleMapper spRoleMapper;
    @Override
    public List<SpRole> getRoleByUname(String name) throws BaseException {
        SpAssert.isNull(name);
        List<SpRole> roleByUnames = spRoleMapper.getRoleByUname(name);
        return roleByUnames;
    }
}
