package com.evo.sp.business.system.controller;


import com.evo.sp.business.system.entity.SysMenu;
import com.evo.sp.business.system.service.ISysMenuService;
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
 *  前端控制器
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
@RestController
@RequestMapping()
public class SysMenuController extends BaseController {

    @Autowired
    private ISysMenuService iSysMenuService;
    /**
     *
     * 新增
     */
    @RequestMapping(value = SpConstantInter.SYS_MENU_SAVE,method = RequestMethod.POST)
    public Result saveMenu(@RequestBody SysMenu sysMenu){
        return save(sysMenu,iSysMenuService);
    }

    /**
     *
     * 删除
     */
    @RequestMapping(value = SpConstantInter.SYS_MENU_DEL,method = RequestMethod.POST)
    public Result delMenu(Serializable id){
        return del(id,iSysMenuService);
    }

    /**
     *
     *修改
     */
    @RequestMapping(value = SpConstantInter.SYS_MENU_MODIFY,method = RequestMethod.POST)
    public Result modifyMenu(@RequestBody SysMenu sysMenu){
        return modify(sysMenu,iSysMenuService);
    }
}
