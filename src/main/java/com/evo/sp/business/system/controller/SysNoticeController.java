package com.evo.sp.business.system.controller;


import com.evo.sp.business.system.entity.SysNotice;
import com.evo.sp.business.system.service.ISysNoticeService;
import com.evo.sp.common.SpConstantInter;
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
 * 通知表 前端控制器
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
@RestController
@RequestMapping(SpConstantInter.SYS_NOTICE)
@Api(tags = "通知")
public class SysNoticeController extends BaseController {

    @Autowired
    private ISysNoticeService iSysNoticeService;


    /**
     *
     * 新增
     */
    @RequestMapping(value = SpConstantInter.SYS_NOTICE_SAVE,method = RequestMethod.POST)
    public Result saveNotice(@RequestBody SysNotice sysNotice){
        return save(sysNotice,iSysNoticeService);
    }

    /**
     *
     * 删除
     */
    @RequestMapping(value = SpConstantInter.SYS_NOTICE_DEL,method = RequestMethod.POST)
    public Result delNotice(Serializable id){
        return del(id,iSysNoticeService);
    }

    /**
     *
     *修改
     */
    @RequestMapping(value = SpConstantInter.SYS_NOTICE_MODIFY,method = RequestMethod.POST)
    public Result modifyNotice(@RequestBody SysNotice sysNotice){
        return modify(sysNotice,iSysNoticeService);
    }
}
