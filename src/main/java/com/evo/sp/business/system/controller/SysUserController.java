package com.evo.sp.business.system.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.evo.sp.business.system.entity.SysUser;
import com.evo.sp.business.system.service.ISysUserService;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.parameter.PageRequestParameter;
import com.evo.sp.common.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.evo.sp.common.BaseController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
@RestController
@RequestMapping(SpConstantInter.SYS_USER)
public class SysUserController extends BaseController {

    @Autowired
    private ISysUserService iSysUserService;

    /**
     *
     * 新增角色
     */
    @RequestMapping(value = SpConstantInter.SYS_USER_SAVE)
    public Result saveUser(@RequestBody SysUser sysUser){
        return save(sysUser,iSysUserService);
    }

    /**
     *
     * 删除角色（根据id）
     */
    @RequestMapping(value = SpConstantInter.SYS_USER_DEL)
    public Result delUser(String id){
        return del(id,iSysUserService);
    }

    /**
     *
     * 修改角色
     */
    @RequestMapping(value = SpConstantInter.SYS_USER_MODIFY)
    public Result modifyUser(@RequestBody SysUser sysUser){
        return modify(sysUser,iSysUserService);
    }

    /**
     *
     * 获取权限列表（分页查询）
     */
    @RequestMapping(value = SpConstantInter.SYS_USER_PAGES)
    public Result queryListPage(@RequestBody PageRequestParameter<SysUser> pageRequestParameter){
        IPage iPage = pageRequestParameter.pageInstance();
        return queryListPage(iPage,pageRequestParameter.parameterInstance(),iSysUserService);
    }

}
