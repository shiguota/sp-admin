package com.evo.sp.business.system.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.evo.sp.business.system.entity.SystemPermissions;
import com.evo.sp.business.system.service.ISystemPermissionsService;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.parameter.PageRequestParameter;
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
 * 前端控制器
 * </p>
 *
 * @author sgt
 * @since 2019-03-27
 */
@RestController
@RequestMapping(SpConstantInter.SYSTEM_PERMISSION)
@Api(tags = "权限")
public class SystemPermissionsController extends BaseController {

    @Autowired
    private ISystemPermissionsService iSystemPermissionsService;

    /**
    *  新增权限
    */
    @RequestMapping(value = SpConstantInter.SYSTEM_PERMISSION_SAVE, method = RequestMethod.POST)
    public Result savePermission(@RequestBody SystemPermissions systemPermissions) {
        return save(systemPermissions,iSystemPermissionsService);
    }

    /**
    *  删除权限根据id
    */
    @RequestMapping(value = SpConstantInter.SYSTEM_PERMISSION_DEL,method = RequestMethod.POST)
    public Result delPermission(String id){
        return del(id,iSystemPermissionsService);
    }
    
    /**
    * 修改权限
    */
    @RequestMapping(value = SpConstantInter.SYSTEM_PERMISSION_MODIFY,method = RequestMethod.POST)
    public Result modifyPermission(@RequestBody SystemPermissions systemPermissions){
        return modify(systemPermissions,iSystemPermissionsService);
    }
    
    /**
    * 查询权限（获取权限列表）
    */
    @RequestMapping(value = SpConstantInter.SYSTEM_PERMISSION_PAGES,method = RequestMethod.POST)
   public Result listsPermission (@RequestBody PageRequestParameter<SystemPermissions> pageRequestParameter){
        IPage pageInstance = pageRequestParameter.pageInstance();
        return queryListPage(pageInstance, pageRequestParameter.parameterInstance(), iSystemPermissionsService);
   }
}
