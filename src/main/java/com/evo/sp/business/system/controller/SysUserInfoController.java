package com.evo.sp.business.system.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.evo.sp.business.system.entity.SysUserInfo;
import com.evo.sp.business.system.service.ISysUserInfoService;
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
 * 用户信息表 前端控制器
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
@RestController
@RequestMapping(SpConstantInter.SYS_USER_INFO)
public class SysUserInfoController extends BaseController {

    @Autowired
    private ISysUserInfoService iSysUserInfoService;

    /**
     *
     * 新增角色
     */
    @RequestMapping(value = SpConstantInter.SYS_USER_INFO_SAVE)
    public Result saveUserInfo(@RequestBody SysUserInfo sysUserInfo){
        return save(sysUserInfo,iSysUserInfoService);
    }

    /**
     *
     * 删除角色（根据id）
     */
    @RequestMapping(value = SpConstantInter.SYS_USER_INFO_DEL)
    public Result delUserInfo(String id){
        return del(id,iSysUserInfoService);
    }

    /**
     *
     * 修改角色
     */
    @RequestMapping(value = SpConstantInter.SYS_USER_INFO_MODIFY)
    public Result modifyUserInfo(@RequestBody SysUserInfo sysUserInfo){
        return modify(sysUserInfo,iSysUserInfoService);
    }
}
