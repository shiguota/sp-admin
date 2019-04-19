package com.evo.sp.business.system.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evo.sp.business.system.entity.SysArea;
import com.evo.sp.business.system.entity.vo.SysAreaVo;
import com.evo.sp.business.system.service.ISysAreaService;
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

import javax.xml.bind.ValidationEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 区域表 前端控制器
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
@RestController
@RequestMapping(SpConstantInter.SYS_AREA)
@Api(tags = "区域")
public class SysAreaController extends BaseController {

    //设置顶级节点名称
    public final String TOP_NODE_NAME = "所有区域";

    @Autowired
    private ISysAreaService iSysAreaService;

    /**
     * 新增
     */
    @RequestMapping(value = SpConstantInter.SYS_AREA_SAVE, method = RequestMethod.POST)
    public Result saveArea(@RequestBody SysArea sysArea) {
        return save(sysArea, iSysAreaService);
    }

    /**
     * 删除
     */
    @RequestMapping(value = SpConstantInter.SYS_AREA_DEL, method = RequestMethod.POST)
    public Result delArea(Serializable id) {
        return del(id, iSysAreaService);
    }

    /**
     * 修改
     */
    @RequestMapping(value = SpConstantInter.SYS_AREA_NODIFY, method = RequestMethod.POST)
    public Result modifyArea(@RequestBody SysArea sysArea) {
        return modify(sysArea, iSysAreaService);
    }


    /**
     * 查询区域（树结构）
     */
    @RequestMapping(value = SpConstantInter.SYS_AREA_TREE, method = RequestMethod.POST)
    public Result queryAreaTree() {
        return queryTreeData(iSysAreaService.queryAreaTree(), TOP_NODE_NAME);
    }

    /**
     * 查询区域
     */
    @RequestMapping(value = SpConstantInter.SYS_AREA_QUERY, method = RequestMethod.POST)
    public Result queryArea(@RequestBody SysArea sysArea) {
        QueryWrapper<SysArea> sysAreaWrapper = new QueryWrapper<>();
        sysAreaWrapper.setEntity(sysArea);
        return queryListsByColumn(sysAreaWrapper, iSysAreaService);
    }
    
    /**
     *
     * 查询区域（分页）
     */
    @RequestMapping(value = SpConstantInter.SYS_AREA_PAGE,method = RequestMethod.POST)
    public Result queryListPage(@RequestBody PageRequestParameter<SysAreaVo> sysAreaPageRequestParameter){
        return iSysAreaService.queryListPage(sysAreaPageRequestParameter);
    }


}
