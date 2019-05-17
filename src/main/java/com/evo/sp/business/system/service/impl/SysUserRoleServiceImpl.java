package com.evo.sp.business.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.evo.sp.business.system.entity.SysRolePermission;
import com.evo.sp.business.system.entity.SysUserRole;
import com.evo.sp.business.system.entity.vo.SysUserRoleVo;
import com.evo.sp.business.system.mapper.SysUserRoleMapper;
import com.evo.sp.business.system.service.ISysUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.ex.DelException;
import com.evo.sp.common.ex.SaveException;
import com.evo.sp.common.ex.SpAssert;
import com.evo.sp.common.result.Result;
import com.evo.sp.common.result.ResultEnum;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 用户角色表 服务实现类
 * </p>
 *
 * @author sgt
 * @since 2019-04-17
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements ISysUserRoleService {

    /**
     * 用户分配角色
     * @param sysUserRoleVo
     */
    @Override
    public Result saveUserRole(SysUserRoleVo sysUserRoleVo) {
        //校验参数
        SpAssert.isNull(sysUserRoleVo);
        SpAssert.isNull(sysUserRoleVo.getRoleId());
        SpAssert.isNull(sysUserRoleVo.getSysUserId());
        //创建角色权限集合
        List<SysUserRole> sysUserRoles = new ArrayList<>();
        QueryWrapper<SysUserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SpConstantInter.SYS_ROLE_PERMISSION_ROLEID,sysUserRoleVo.getSysRoleId());
        //清空当前用户拥有的角色
        if (remove(queryWrapper)) {
            //获取角色数组
            String[] roleId = sysUserRoleVo.getRoleId();
            //遍历角色id数组
            for (String s : roleId) {
                sysUserRoles.add(new SysUserRole(s,sysUserRoleVo.getSysRoleId()));
            }
        }else{
            throw new DelException(ResultEnum.PERMISSION_DEL_FAIL.getValue(),ResultEnum.PERMISSION_DEL_FAIL.getName());
        }
        if (!super.saveBatch(sysUserRoles)) {
            throw new SaveException();
        }
        return null;
    }
}
