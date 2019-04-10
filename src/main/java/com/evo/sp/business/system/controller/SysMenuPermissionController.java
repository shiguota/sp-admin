package com.evo.sp.business.system.controller;


import com.evo.sp.business.system.entity.SysMenuPermission;
import com.evo.sp.business.system.service.ISysMenuPermissionService;
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
 * 菜单权限表 前端控制器
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
@RestController
@RequestMapping(SpConstantInter.SYS_MENU_PERMISSION)
public class SysMenuPermissionController extends BaseController {

    @Autowired
    private ISysMenuPermissionService iSysMenuPermissionService;

    /**
     *
     * 新增
     */
    @RequestMapping(value = SpConstantInter.SYS_MENU_PERMISSION_SAVE,method = RequestMethod.POST)
    public Result saveMenuPermission(@RequestBody SysMenuPermission sysMenuPermission){
        return save(sysMenuPermission,iSysMenuPermissionService);
    }

    /**
     *
     * 删除
     */
    @RequestMapping(value = SpConstantInter.SYS_MENU_PERMISSION_DEL,method = RequestMethod.POST)
    public Result delMenuPermission(Serializable id){
        return del(id,iSysMenuPermissionService);
    }

    /**
     *
     *修改
     */
    @RequestMapping(value = SpConstantInter.SYS_MENU_PERMISSION_MPODIFY,method = RequestMethod.POST)
    public Result modifyMenuPermission(@RequestBody SysMenuPermission sysMenuPermission){
        return modify(sysMenuPermission,iSysMenuPermissionService);
    }
}
