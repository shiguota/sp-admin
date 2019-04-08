package com.evo.sp.business.system.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.evo.sp.business.system.entity.SystemDictionary;
import com.evo.sp.business.system.service.ISystemDictionaryService;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.parameter.PageRequestParameter;
import com.evo.sp.common.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.evo.sp.common.BaseController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author sgt
 * @since 2019-04-08
 */
@RestController
@RequestMapping(SpConstantInter.SYSTEM_DICTIONNARY)
public class SystemDictionaryController extends BaseController {

    @Autowired
    private ISystemDictionaryService iSystemDictionaryService;


    /**
     *
     * 新增
     */
    @RequestMapping(value = SpConstantInter.SYSTEM_DICTIONNARY_SAVE,method = RequestMethod.POST)
    public Result saveDictionnary(@RequestBody SystemDictionary systemDictionary){
        return save(systemDictionary,iSystemDictionaryService);
    }

    /**
     *
     * 删除
     */
    @RequestMapping(value = SpConstantInter.SYSTEM_DICTIONNARY_DEL,method = RequestMethod.POST)
    public Result delDictionary(String id){
        return del(id,iSystemDictionaryService);
    }

    /**
     *
     * 修改字典
     */
    @RequestMapping(value = SpConstantInter.SYSTEM_DICTIONNARY_MODIFY,method = RequestMethod.POST)
    public Result modifyDictionary(@RequestBody SystemDictionary systemDictionary){
        return modify(systemDictionary,iSystemDictionaryService);
    }

    /**
     *
     * 获取字典列表（分页查询）
     */
    @RequestMapping(value = SpConstantInter.SYSTEM_DICTIONNARY_PAGES,method = RequestMethod.POST)
    public Result queryListPage(@RequestBody PageRequestParameter<SystemDictionary> pageRequestParameter){
        IPage iPage = pageRequestParameter.pageInstance();
        return queryListPage(iPage,pageRequestParameter.parameterInstance(),iSystemDictionaryService);
    }
}
