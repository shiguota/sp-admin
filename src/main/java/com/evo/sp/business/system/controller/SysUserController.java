package com.evo.sp.business.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.evo.sp.business.system.entity.SysUser;
import com.evo.sp.business.system.entity.SysUserInfo;
import com.evo.sp.business.system.entity.vo.SysUserVo;
import com.evo.sp.business.system.service.ISysUserInfoService;
import com.evo.sp.business.system.service.ISysUserService;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.ex.SpAssert;
import com.evo.sp.common.parameter.PageRequestParameter;
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
 * 用户表 前端控制器
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
@RestController
@RequestMapping(SpConstantInter.SYS_USER)
@Api(tags = "用户")
public class SysUserController extends BaseController {

    @Autowired
    private ISysUserService iSysUserService;
    @Autowired
    private ISysUserInfoService iSysUserInfoService;

    /**
     *
     * 新增角色
     */
    @RequestMapping(value = SpConstantInter.SYS_USER_SAVE,method = RequestMethod.POST)
    public Result saveUser(@RequestBody SysUserVo sysUserVo){
        //验证参数
        SpAssert.isNull(sysUserVo);
        SysUserInfo sysUserInfo = sysUserVo.getInfo();
        SpAssert.isNull(sysUserInfo);
        //判断新增用户详情是否成功
        if (iSysUserInfoService.save(sysUserInfo)) {
            sysUserVo.setSysUserInfoId(sysUserInfo.getId());
            //如果成功添加用户详情信息，再次新增用户基础信息
            return save(sysUserVo, iSysUserService);
        }
        return new Result(false);
    }

    /**
     *
     * 删除角色（根据id）
     */
    @RequestMapping(value = SpConstantInter.SYS_USER_DEL,method = RequestMethod.POST)
    public Result delUser(String id){
        return del(id,iSysUserService);
    }

    /**
     *
     * 修改角色（根据id）
     */
    @RequestMapping(value = SpConstantInter.SYS_USER_MODIFY,method = RequestMethod.POST)
    public Result modifyUser(@RequestBody SysUser sysUser){
        SpAssert.isNull(sysUser.getId());
        return modify(sysUser,iSysUserService);
    }
    /**
     *
     * 根据id查询一条记录
     *
     */
    @RequestMapping(value = SpConstantInter.SYS_USER_QUERY_ONE,method = RequestMethod.POST)
    public Result queryOne(String id){
        return iSysUserService.queryUserById(id);
    }
    /**
     *
     * 获取权限列表（分页查询）
     */
    @RequestMapping(value = SpConstantInter.SYS_USER_PAGE,method = RequestMethod.POST)
    public Result queryListPage(@RequestBody PageRequestParameter<SysUserVo> pageRequestParameter){
        return iSysUserService.queryUserByOrg(pageRequestParameter.pageInstance(),pageRequestParameter.parameterInstance());
    }
}
