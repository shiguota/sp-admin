package com.evo.sp.business.system.controller;


import com.evo.sp.business.system.entity.SysUserRole;
import com.evo.sp.business.system.service.ISysUserRoleService;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.ex.SpAssert;
import com.evo.sp.common.result.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.evo.sp.common.BaseController;

/**
 * <p>
 * 用户角色表 前端控制器
 * </p>
 *
 * @author sgt
 * @since 2019-04-17
 */
@RestController
@RequestMapping(SpConstantInter.SYS_USER_ROLE)
@Api(tags = "用户角色")
public class SysUserRoleController extends BaseController {

    @Autowired
    private ISysUserRoleService iSysUserRoleService;

    /**
     *
     *  新增（为用户授权角色）
     */
    @RequestMapping(value = SpConstantInter.SYS_USER_ROLE_SAVE,method = RequestMethod.POST)
    public Result saveUserRole(@RequestBody SysUserRole sysUserRole){
        SpAssert.isNull(sysUserRole);
        SpAssert.isNull(sysUserRole.getSysRoleId());
        SpAssert.isNull(sysUserRole.getSysUserId());
        return save(sysUserRole,iSysUserRoleService);
    }
    
    /**
     *
     * 删除（取消用户权限角色）
     */
    @RequestMapping(value = SpConstantInter.SYS_USER_ROLE_DEL,method = RequestMethod.POST)
    public Result delUserRole(@RequestBody SysUserRole sysUserRole){
        SpAssert.isNull(sysUserRole);
        SpAssert.isNull(sysUserRole.getSysRoleId());
        SpAssert.isNull(sysUserRole.getSysUserId());
        return del(sysUserRole,iSysUserRoleService);
    }
}
