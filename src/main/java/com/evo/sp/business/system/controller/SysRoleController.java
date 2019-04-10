package com.evo.sp.business.sys.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.evo.sp.business.system.entity.SysRole;
import com.evo.sp.business.system.service.ISysRoleService;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.parameter.PageRequestParameter;
import com.evo.sp.common.result.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.evo.sp.common.BaseController;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
@RestController
@RequestMapping(value = SpConstantInter.SYS_ROLE)
@Api(tags = "角色")
public class SysRoleController extends BaseController {

    @Autowired
    private ISysRoleService iSysRoleService;

    /**
     *
     * 新增角色
     */
    @RequestMapping(value = SpConstantInter.SYS_ROLE_SAVE)
    public Result saveRole(@RequestBody SysRole sysRole){
        return save(sysRole,iSysRoleService);
    }

    /**
     *
     * 删除角色（根据id）
     */
    @RequestMapping(value = SpConstantInter.SYS_ROLE_DEL)
    public Result delRole(String id){
        return del(id,iSysRoleService);
    }

    /**
     *
     * 修改角色
     */
    @RequestMapping(value = SpConstantInter.SYS_ROLE_MODIFY)
    public Result modifyRole(@RequestBody SysRole sysRole){
        return modify(sysRole,iSysRoleService);
    }

    /**
     *
     * 获取权限列表（分页查询）
     */
    @RequestMapping(value = SpConstantInter.SYS_ROLE_PAGES)
    public Result queryListPage(@RequestBody PageRequestParameter<SysRole> pageRequestParameter){
        IPage iPage = pageRequestParameter.pageInstance();
        return queryListPage(iPage,pageRequestParameter.parameterInstance(),iSysRoleService);
    }



}
