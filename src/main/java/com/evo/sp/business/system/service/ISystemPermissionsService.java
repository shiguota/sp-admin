package com.evo.sp.business.system.service;

import com.evo.sp.business.system.entity.SystemPermissions;
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
public interface ISystemPermissionsService extends IService<SystemPermissions> {

    /**
     * @Description:通过角色名称获取权限
     * @Param: name：角色权限
     * @return: 权限列表
     * @Author: 史国涛
     * @Date: 2019-03-28
     */
    List<SystemPermissions> getPermissionsByRName(String name) throws BaseException;

}