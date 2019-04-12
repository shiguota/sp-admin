package com.evo.sp.business.system.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.evo.sp.business.system.entity.SystemLog;
import com.evo.sp.business.system.service.ISysLogService;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.parameter.PageRequestParameter;
import com.evo.sp.common.result.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.evo.sp.common.BaseController;

import java.util.List;

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
@Api(tags = "日志")
public class SysLogController extends BaseController {

    @Autowired
    private ISysLogService iSystemLogService;

    /**
     *
     * 新增日志
     */
    @RequestMapping(value = SpConstantInter.SYS_LOG_SAVE,method = RequestMethod.POST)
    public Result saveLog(@RequestBody SystemLog systemLog){
        return save(systemLog,iSystemLogService);
    }

    /**
     *
     * 删除日志(单条)
     */
    @RequestMapping(value = SpConstantInter.SYS_LOG_DEL,method = RequestMethod.POST)
    public Result delLog(String id){
        return del(id,iSystemLogService);
    }

    /**
     *
     * 删除日志（批量）
     */
    @RequestMapping(value = SpConstantInter.SYS_LOG_DELS,method = RequestMethod.POST)
    public Result delslOG(@RequestBody List<String> ids){
        return dels(ids,iSystemLogService);
    }
    /**
     *
     * 查询日志列表（分页查询）
     */
    @RequestMapping(value = SpConstantInter.SYS_LOG_PAGE,method = RequestMethod.POST)
    public Result queryListPage(@RequestBody PageRequestParameter<SystemLog> pageRequestParameter){
        IPage iPage = pageRequestParameter.pageInstance();
        return queryListPage(iPage,pageRequestParameter.parameterInstance(),iSystemLogService);
    }
}
