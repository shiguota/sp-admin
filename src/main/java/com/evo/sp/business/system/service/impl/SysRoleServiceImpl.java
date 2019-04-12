package com.evo.sp.business.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evo.sp.business.system.entity.SysRole;
import com.evo.sp.business.system.entity.vo.SysRoleVo;
import com.evo.sp.business.system.mapper.SysRoleMapper;
import com.evo.sp.business.system.service.ISysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.evo.sp.common.ex.SpAssert;
import com.evo.sp.common.result.Result;
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
    public List<SysRole> queryRoleByAccount(String account) {
        return sysRoleMapper.getRoleByAccount(account);
    }

    /**
     * 根据组织（机构）id查询角色
     *
     * @param sysRoleVo
     */
    @Override
    public Result queryByNameOrg(Page page,SysRoleVo sysRoleVo) {
        SpAssert.isNull(sysRoleVo.getOrgId());
        return new Result(sysRoleMapper.queryByNameOrg(sysRoleVo));
    }
}
