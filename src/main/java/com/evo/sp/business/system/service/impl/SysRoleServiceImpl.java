package com.evo.sp.business.system.service.impl;

import com.evo.sp.business.system.entity.SysRole;
import com.evo.sp.business.system.mapper.SysRoleMapper;
import com.evo.sp.business.system.service.ISysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    /**
     * 根据账号获取角色
     *
     * @param account
     */
    @Override
    public List<SysRole> getRoleByAccount(String account) {
        return sysRoleMapper.getRoleByAccount(account);
    }
}
