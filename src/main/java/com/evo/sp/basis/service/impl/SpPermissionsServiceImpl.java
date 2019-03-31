package com.evo.sp.basis.service.impl;

import com.evo.sp.basis.entity.SpPermissions;
import com.evo.sp.basis.mapper.SpPermissionsMapper;
import com.evo.sp.basis.service.ISpPermissionsService;
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
public class SpPermissionsServiceImpl extends ServiceImpl<SpPermissionsMapper, SpPermissions> implements ISpPermissionsService {


    @Autowired
    private SpPermissionsMapper spPermissionsMapper;

    @Override
    public List<SpPermissions> getPermissionsByRName(String name) throws BaseException {
        SpAssert.isNull(name);
        List<SpPermissions> permissionsByRName = spPermissionsMapper.getPermissionsByRName(name);
        return permissionsByRName;
    }
}
