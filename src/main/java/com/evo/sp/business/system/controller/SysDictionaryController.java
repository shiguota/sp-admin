package com.evo.sp.business.system.controller;


import com.evo.sp.business.system.entity.SysDictionary;
import com.evo.sp.business.system.service.ISysDictionaryService;
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
 * 字典表 前端控制器
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
@RestController
@RequestMapping(SpConstantInter.SYS_DICTIONNARY)
public class SysDictionaryController extends BaseController {

    @Autowired
    private ISysDictionaryService iSysDictionaryService;

    /**
     *
     * 新增
     */
    @RequestMapping(value = SpConstantInter.SYS_DICTIONNARY_SAVE,method = RequestMethod.POST)
    public Result saveDictionary(@RequestBody SysDictionary sysDictionary){
        return save(sysDictionary,iSysDictionaryService);
    }

    /**
     *
     * 删除
     */
    @RequestMapping(value = SpConstantInter.SYS_DICTIONNARY_DEL,method = RequestMethod.POST)
    public Result delDictionary(Serializable id){
        return del(id,iSysDictionaryService);
    }

    /**
     *
     *修改
     */
    @RequestMapping(value = SpConstantInter.SYS_DICTIONNARY_MODIFY,method = RequestMethod.POST)
    public Result modifyDictionary(@RequestBody SysDictionary sysDictionary){
        return modify(sysDictionary,iSysDictionaryService);
    }

}
