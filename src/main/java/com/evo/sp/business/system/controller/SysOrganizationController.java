package com.evo.sp.business.system.controller;


import com.evo.sp.business.system.entity.SysOrganization;
import com.evo.sp.business.system.service.ISysOrganizationService;
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
 * 组织机构表 前端控制器
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
@RestController
@RequestMapping(SpConstantInter.SYS_ORGANIZATION)
public class SysOrganizationController extends BaseController {

    @Autowired
    private ISysOrganizationService iSysOrganizationService;

    /**
     *
     * 新增
     */
    @RequestMapping(value = SpConstantInter.SYS_ORGANIZATION_SAVE,method = RequestMethod.POST)
    public Result saveOrganization(@RequestBody SysOrganization sysOrganization){
        return save(sysOrganization,iSysOrganizationService);
    }

    /**
     *
     * 删除
     */
    @RequestMapping(value = SpConstantInter.SYS_ORGANIZATION_DEL,method = RequestMethod.POST)
    public Result delOrganization(Serializable id){
        return del(id,iSysOrganizationService);
    }

    /**
     *
     *修改
     */
    @RequestMapping(value = SpConstantInter.SYS_ORGANIZATION_MODIFY,method = RequestMethod.POST)
    public Result modifyOrganization(@RequestBody SysOrganization sysOrganization){
        return modify(sysOrganization,iSysOrganizationService);
    }
}
