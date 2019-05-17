package com.evo.sp.business.system.service.impl;

import com.evo.sp.business.system.entity.SysOrganizationRole;
import com.evo.sp.business.system.mapper.SysOrganizationRoleMapper;
import com.evo.sp.business.system.service.ISysOrganizationRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.evo.sp.common.ex.DelException;
import com.evo.sp.common.ex.SpAssert;
import com.evo.sp.common.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sgt
 * @since 2019-04-11
 */
@Service
@SuppressWarnings("all")
public class SysOrganizationRoleServiceImpl extends ServiceImpl<SysOrganizationRoleMapper, SysOrganizationRole> implements ISysOrganizationRoleService {

    @Autowired
    private SysOrganizationRoleMapper sysOrganizationRoleMapper;

    /**
     * 删除（根据角色id）
     *
     * @param roleId
     */
    @Override
    public Result roleDel(String roleId) {
        SpAssert.isNull(roleId);
        SpAssert.isNull(roleId);
        boolean b = removeById(roleId);
        if (!b) {
            throw new DelException();
        }
        return new Result(b);
    }

    /**
     * 删除 （根据机构id）
     *
     * @param orgId
     */
    @Override
    public Result orgDel(String orgId) {
        SpAssert.isNull(orgId);
        boolean b = removeById(orgId);
        if (!b) {
            throw new DelException();
        }
        return new Result(b);
    }
}
