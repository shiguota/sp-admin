package com.evo.sp.business.system.service.impl;

import com.evo.sp.business.system.entity.SystemPermissions;
import com.evo.sp.business.system.mapper.SystemPermissionsMapper;
import com.evo.sp.business.system.service.ISystemPermissionsService;
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
public class SystemPermissionsServiceImpl extends ServiceImpl<SystemPermissionsMapper, SystemPermissions> implements ISystemPermissionsService {


    @Autowired
    private SystemPermissionsMapper systemPermissionsMapper;

    @Override
    public List<SystemPermissions> getPermissionsByRName(String name) throws BaseException {
        SpAssert.isNull(name);
        List<SystemPermissions> permissionsByRName = systemPermissionsMapper.getPermissionsByRName(name);
        return permissionsByRName;
    }
}
