package com.evo.sp.business.system.controller;


import com.evo.sp.business.system.entity.SysRolePermission;
import com.evo.sp.business.system.service.ISysRolePermissionService;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.evo.sp.common.BaseController;

import java.io.Serializable;

/**
 * <p>
 * 角色权限表 前端控制器
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
@RestController
@RequestMapping(SpConstantInter.SYS_ROLE_PERMISSION)
public class SysRolePermissionController extends BaseController {

    @Autowired
    private ISysRolePermissionService iSysRolePermissionService;

    /**
     *
     * 新增
     */
    @RequestMapping(value = SpConstantInter.SYS_ROLE_PERMISSION_SAVE,method = RequestMethod.POST)
    public Result saveRolePermission(@RequestBody SysRolePermission sysRolePermission){
        return save(sysRolePermission,iSysRolePermissionService);
    }

    /**
     *
     * 删除
     */
    @RequestMapping(value = SpConstantInter.SYS_ROLE_PERMISSION_SAVE,method = RequestMethod.POST)
    public Result delRolePermission(Serializable id){
        return del(id,iSysRolePermissionService);
    }

    /**
     *
     *修改
     */
    @RequestMapping(value = SpConstantInter.SYS_ROLE_PERMISSION_SAVE,method = RequestMethod.POST)
    public Result modifyRolePermission(@RequestBody SysRolePermission sysRolePermission){
        return modify(sysRolePermission,iSysRolePermissionService);
    }

}
