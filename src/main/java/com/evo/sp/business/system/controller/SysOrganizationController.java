package com.evo.sp.business.system.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evo.sp.business.system.entity.SysOrganization;
import com.evo.sp.business.system.entity.vo.SysOrganizationVo;
import com.evo.sp.business.system.service.ISysOrganizationService;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.ex.SpAssert;
import com.evo.sp.common.parameter.PageRequestParameter;
import com.evo.sp.common.result.Result;
import com.evo.sp.common.tree.Tree;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.evo.sp.common.BaseController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
@Api(tags = "组织（机构）")
public class SysOrganizationController extends BaseController {

    //顶级节点名称
    private final String TOP_NODE_NAME = "所有机构";

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
    
    /**
     *
     * 查询组织机构(分页)
     */
    @RequestMapping(value = SpConstantInter.SYS_ORGANIZATION_PAGE,method = RequestMethod.POST)
    public Result queryListPage(@RequestBody PageRequestParameter<SysOrganizationVo> pageRequestParameter){
        return iSysOrganizationService.queryListPage(pageRequestParameter);
    }

    /**
     *
     * 查询组织机构（树形）
     */
    @RequestMapping(value = SpConstantInter.SYS_ORGANIZATION_TREE,method = RequestMethod.POST)
    public Result queryListTree(){
        return queryTreeData(iSysOrganizationService.queryListTree(),TOP_NODE_NAME);
    }
}
