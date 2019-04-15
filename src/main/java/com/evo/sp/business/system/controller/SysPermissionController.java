package com.evo.sp.business.system.controller;


import com.evo.sp.business.system.entity.SysPermission;
import com.evo.sp.business.system.service.ISysPermissionService;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.result.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.evo.sp.common.BaseController;

import java.io.Serializable;

/**
 * <p>
 * 权限表 前端控制器
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
@RestController
@RequestMapping(SpConstantInter.SYS_PERMISSION)
@Api(tags = "权限")
public class SysPermissionController extends BaseController {

    @Autowired
    private ISysPermissionService iSysPermissionService;

    /**
     * 新增
     */
    @RequestMapping(value = SpConstantInter.SYS_PERMISSION_SAVE, method = RequestMethod.POST)
    public Result savePermission(@RequestBody SysPermission sysPermission) {
        return save(sysPermission, iSysPermissionService);
    }

    /**
     * 删除
     */
    @RequestMapping(value = SpConstantInter.SYS_PERMISSION_DEL, method = RequestMethod.POST)
    public Result delPermission(Serializable id) {
        return del(id, iSysPermissionService);
    }

    /**
     * 修改
     */
    @RequestMapping(value = SpConstantInter.SYS_PERMISSION_MODIFY, method = RequestMethod.POST)
    public Result modifyPermission(@RequestBody SysPermission sysPermission) {
        return modify(sysPermission, iSysPermissionService);
    }
    
    /**
     *
     * 根据菜单获取权限
     */
    @RequestMapping(value = SpConstantInter.SYS_MENU_PER,method = RequestMethod.POST)
    public Result queryPerByMenuId(String menuId){
        return iSysPermissionService.queryPerByMenuId(menuId);
    }
}
