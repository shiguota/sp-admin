package com.evo.sp.business.system.service.impl;

import com.evo.sp.business.system.entity.SysPermission;
import com.evo.sp.business.system.mapper.SysPermissionMapper;
import com.evo.sp.business.system.service.ISysPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements ISysPermissionService {


    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    /**
     * 根据角色编码获取权限
     *
     * @param roleCode
     */
    @Override
    public List<SysPermission> getPermissionsByCode(String roleCode) {
         return sysPermissionMapper.getPermissionsByCode(roleCode);
    }
}
