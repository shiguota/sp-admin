package com.evo.sp.business.system.service;

import com.evo.sp.business.system.entity.SysOrganizationRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.evo.sp.common.result.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sgt
 * @since 2019-04-11
 */
public interface ISysOrganizationRoleService extends IService<SysOrganizationRole> {


    /**
     *
     * 删除（根据角色id）
     */
    Result roleDel(String roleId);

    /**
     *
     * 删除 （根据机构id）
     */
    Result orgDel(String orgId);
}
