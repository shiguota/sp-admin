package com.evo.sp.business.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.evo.sp.business.system.entity.SysRolePermission;
import com.evo.sp.business.system.entity.vo.SysRolePermissionVo;
import com.evo.sp.business.system.mapper.SysRolePermissionMapper;
import com.evo.sp.business.system.service.ISysRolePermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.ex.SaveException;
import com.evo.sp.common.ex.SpAssert;
import com.evo.sp.common.result.Result;
import com.sun.xml.internal.xsom.impl.scd.SCDParserConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 角色权限表 服务实现类
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
@Service
public class SysRolePermissionServiceImpl extends ServiceImpl<SysRolePermissionMapper, SysRolePermission> implements ISysRolePermissionService {


    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;

    /**
     * 批量保存
     *
     * @param sysRolePermissionVo
     */
    @Override
    @Transactional
    public Result saveBatch(SysRolePermissionVo sysRolePermissionVo) {
        //校验参数
        SpAssert.isNull(sysRolePermissionVo);
        SpAssert.isNull(sysRolePermissionVo.getSysRoleId());
        SpAssert.isNull(sysRolePermissionVo.getSysMenuHasSysPermissionId());
        //创建角色权限集合
        List<SysRolePermission> sysRolePermissions = new ArrayList<>();
        QueryWrapper<SysRolePermission> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SpConstantInter.SYS_ROLE_PERMISSION_ROLEID,sysRolePermissionVo.getSysRoleId());
        //清空当前角色拥有的权限
        if (sysRolePermissionMapper.delete(queryWrapper) == SpConstantInter.CURDVAL) {
            //获取权限数组
            String[] sysMenuHasSysPermissionId = sysRolePermissionVo.getSysMenuHasSysPermissionId();
            //遍历菜单权限数组
            for (String s : sysMenuHasSysPermissionId) {
                sysRolePermissions.add(new SysRolePermission(s,sysRolePermissionVo.getSysRoleId()));
            }
        }
        if (!super.saveBatch(sysRolePermissions)) {
            throw new SaveException();
        }
        return new Result(true);
    }
}
