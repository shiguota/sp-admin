package com.evo.sp.business.system.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.evo.sp.business.system.entity.SystemRole;
import com.evo.sp.business.system.service.ISystemRoleService;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.parameter.PageRequestParameter;
import com.evo.sp.common.result.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.evo.sp.common.BaseController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author sgt
 * @since 2019-03-27
 */
@RestController
@RequestMapping(value = SpConstantInter.SYSTEM_ROLE)
@Api(tags = "角色")
public class SystemRoleController extends BaseController {

    @Autowired
    private ISystemRoleService iSystemRoleService;

    /**
     *
     * 新增角色
     */
    @RequestMapping(value = SpConstantInter.SYSTEM_ROLE_SAVE)
    public Result saveRole(@RequestBody SystemRole systemRole){
        return save(systemRole,iSystemRoleService);
    }

    /**
     *
     * 删除角色（根据id）
     */
    @RequestMapping(value = SpConstantInter.SYSTEM_ROLE_DEL)
    public Result delRole(String id){
        return del(id,iSystemRoleService);
    }

    /**
     *
     * 修改角色
     */
    @RequestMapping(value = SpConstantInter.SYSTEM_ROLE_MODIFY)
    public Result modifyRole(@RequestBody SystemRole systemRole){
        return modify(systemRole,iSystemRoleService);
    }
    
    /**
     *
     * 获取权限列表（分页查询）
     */
    @RequestMapping(value = SpConstantInter.SYSTEM_ROLE_PAGES)
    public Result queryListPage(@RequestBody PageRequestParameter<SystemRole> pageRequestParameter){
        IPage iPage = pageRequestParameter.pageInstance();
        return queryListPage(iPage,pageRequestParameter.parameterInstance(),iSystemRoleService);
    }
    
}
