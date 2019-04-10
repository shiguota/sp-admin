package com.evo.sp.business.system.controller;


import com.evo.sp.business.system.entity.SysArea;
import com.evo.sp.business.system.service.ISysAreaService;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.result.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.evo.sp.common.BaseController;

import javax.xml.bind.ValidationEvent;
import java.io.Serializable;

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


    @Autowired
    private ISysAreaService iSysAreaService;

    /**
     *
     * 新增区域
     */
    @RequestMapping(value = SpConstantInter.SYS_AREA_SAVE,method = RequestMethod.POST)
    public Result saveArea(@RequestBody SysArea sysArea){
        return save(sysArea,iSysAreaService);
    }
    
    /**
     *
     * 删除
     */
    @RequestMapping(value = SpConstantInter.SYS_AREA_DEL,method = RequestMethod.POST)
    public Result delArea(Serializable id){
        return del(id,iSysAreaService);
    }

    /**
     *
     *修改
     */
    @RequestMapping(value = SpConstantInter.SYS_AREA_NODIFY,method = RequestMethod.POST)
    public Result modifyArea(@RequestBody SysArea sysArea){
        return modify(sysArea,iSysAreaService);
    }


}
