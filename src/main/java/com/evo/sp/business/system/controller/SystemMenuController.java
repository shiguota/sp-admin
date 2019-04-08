package com.evo.sp.business.system.controller;


import com.evo.sp.business.system.entity.SystemMenu;
import com.evo.sp.business.system.service.ISystemMenuService;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.parameter.PageRequestParameter;
import com.evo.sp.common.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
 * @since 2019-04-08
 */
@RestController
@RequestMapping(SpConstantInter.SYSTEM_MENU)
public class SystemMenuController extends BaseController {


    @Autowired
    private ISystemMenuService iSystemMenuService;

    /**
     *
     * 新增菜单
     */
    @RequestMapping(value = SpConstantInter.SYSTEM_MENU_SAVE)
    public Result saveMenu(@RequestBody SystemMenu systemMenu){
        return save(systemMenu,iSystemMenuService);
    }

    /**
     *
     * 删除菜单
     */
    @RequestMapping(value = SpConstantInter.SYSTEM_MENU_DEL)
    public Result delMune(String id){
        return del(id,iSystemMenuService);
    }

    /**
     *
     * 修改菜单
     */
    @RequestMapping(value = SpConstantInter.SYSTEM_MENU_MODIFY)
    public Result modifyMenu(@RequestBody SystemMenu systemMenu){
        return modify(systemMenu,iSystemMenuService);
    }

    /**
     *
     * 获取菜单列表（分页查询）
     */
    @RequestMapping(value = SpConstantInter.SYSTEM_MENU_PAGES)
    public Result queryListPage(@RequestBody PageRequestParameter<SystemMenu> pageRequestParameter){
        return queryListPage(pageRequestParameter.pageInstance(),pageRequestParameter.parameterInstance(),iSystemMenuService);
    }
}

