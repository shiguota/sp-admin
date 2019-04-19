package com.evo.sp.business.system.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.evo.sp.business.system.entity.SysMenu;
import com.evo.sp.business.system.entity.SysUser;
import com.evo.sp.business.system.entity.vo.SysMenuVo;
import com.evo.sp.business.system.service.ISysMenuService;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.ex.SpAssert;
import com.evo.sp.common.parameter.PageRequestParameter;
import com.evo.sp.common.result.Result;
import com.evo.sp.common.result.ResultEnum;
import com.evo.sp.common.tree.Tree;
import io.swagger.annotations.Api;
import org.apache.shiro.SecurityUtils;
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
 * 前端控制器
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
@RestController
@RequestMapping(SpConstantInter.SYS_MENU)
@Api(tags = "菜单")
public class SysMenuController extends BaseController {

    //顶级节点名称
    private final String TOP_NODE_NAME = "首页";

    @Autowired
    private ISysMenuService iSysMenuService;

    /**
     * 新增
     */
    @RequestMapping(value = SpConstantInter.SYS_MENU_SAVE, method = RequestMethod.POST)
    public Result saveMenu(@RequestBody SysMenuVo sysMenuVo) {
        return iSysMenuService.menuSave(sysMenuVo);
    }

    /**
     * 删除
     */
    @RequestMapping(value = SpConstantInter.SYS_MENU_DEL, method = RequestMethod.POST)
    public Result delMenu(Serializable id) {
        return del(id, iSysMenuService);
    }

    /**
     * 修改
     */
    @RequestMapping(value = SpConstantInter.SYS_MENU_MODIFY, method = RequestMethod.POST)
    public Result modifyMenu(@RequestBody SysMenu sysMenu) {
        return modify(sysMenu, iSysMenuService);
    }


    /**
     * 查询菜单（分页）
     */
    @RequestMapping(value = SpConstantInter.SYS_MENU_PAGE, method = RequestMethod.POST)
    public Result queryMenuPage(@RequestBody PageRequestParameter<SysMenuVo> pageRequestParameter) {
        return iSysMenuService.queryListPage(pageRequestParameter);
    }

    /**
     * 查询菜单（用户权限范围内）
     */
    @RequestMapping(value = SpConstantInter.SYS_MENU_PATH, method = RequestMethod.POST)
    public Result queryMenus() {
        //获取当前用户所拥有权限范围内的菜单
        List<Tree<SysMenu>> sysMenus = iSysMenuService.queryMenuPath();
        return queryTreeData(sysMenus, TOP_NODE_NAME);
    }
}
