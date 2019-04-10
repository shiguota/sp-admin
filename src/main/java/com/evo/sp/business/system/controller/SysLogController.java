package com.evo.sp.business.system.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.evo.sp.business.system.entity.SystemLog;
import com.evo.sp.business.system.service.ISysLogService;
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
 *  前端控制器
 * </p>
 *
 * @author sgt
 * @since 2019-03-29
 */
@RestController
@RequestMapping(SpConstantInter.SYS_LOG)
public class SysLogController extends BaseController {

    @Autowired
    private ISysLogService iSystemLogService;

    /**
     *
     * 新增日志
     */
    @RequestMapping(value = SpConstantInter.SYS_LOG_SAVE)
    public Result saveLog(@RequestBody SystemLog systemLog){
        return save(systemLog,iSystemLogService);
    }

    /**
     *
     * 删除日志
     */
    @RequestMapping(value = SpConstantInter.SYS_LOG_DEL)
    public Result delLog(String id){
        return del(id,iSystemLogService);
    }

    /**
     *
     * 查询日志列表（分页查询）
     */
    @RequestMapping(value = SpConstantInter.SYS_LOG_PAGES)
    public Result queryListPage(@RequestBody PageRequestParameter<SystemLog> pageRequestParameter){
        IPage iPage = pageRequestParameter.pageInstance();
        return queryListPage(iPage,pageRequestParameter.parameterInstance(),iSystemLogService);
    }
}
