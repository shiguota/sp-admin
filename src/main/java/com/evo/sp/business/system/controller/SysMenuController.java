package com.evo.sp.business.system.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.evo.sp.business.system.entity.SysMenu;
import com.evo.sp.business.system.entity.SysUser;
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
 *  前端控制器
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
    

    /**
     *
     * 查询菜单（分页）
     */
    @RequestMapping(value = SpConstantInter.SYS_MENU_PAGE,method = RequestMethod.POST)
    public Result queryMenuPage(@RequestBody PageRequestParameter pageRequestParameter){
         SysMenu sysMenu = (SysMenu) pageRequestParameter.parameterInstance();
        Wrapper<SysMenu> sysMenuWrapper = new QueryWrapper<>();
        ((QueryWrapper<SysMenu>) sysMenuWrapper).eq(SpConstantInter.PID,sysMenu.getId());
        ((QueryWrapper<SysMenu>) sysMenuWrapper).like(SpConstantInter.SYS_MENU_NAME,sysMenu.getMenuName());
        return queryListPage(pageRequestParameter.pageInstance(),sysMenuWrapper,iSysMenuService);
    }

    /**
     *
     * 查询菜单（树结构）
     */
    @RequestMapping(value = SpConstantInter.SYS_MENU_TREE,method = RequestMethod.POST)
    public Result queryMenuTree(){
        List<Tree<SysMenu>> trees = new ArrayList<>();
        List<SysMenu> list = iSysMenuService.list();
        for (SysMenu sysMenu : list) {
            Tree<SysMenu> sysMenuTree = new Tree<>();
            sysMenuTree.setId(sysMenu.getId());
            sysMenuTree.setParentId(sysMenu.getPid());
            sysMenuTree.setText(sysMenu.getMenuName());
        }
        return queryTreeData(trees,TOP_NODE_NAME);
    }
    
    /**
     *
     * 查询菜单（用户权限范围内）
     */
    @RequestMapping(value = SpConstantInter.STS_MENU_PATH,method = RequestMethod.POST)
    public Result queryMenuPer(){
        SysUser sysUser = (SysUser) SecurityUtils.getSubject().getSession().getAttribute(SpConstantInter.USER);
        if (SpAssert.isNotNull(sysUser)) {
            if (SpAssert.isNotNull(sysUser.getAccount())) {
                List<SysMenu> sysMenus = iSysMenuService.queryMenuPath(sysUser.getAccount());
                return  new Result(sysMenus);
            }
        }
        return new Result(false, ResultEnum.OPERATION_UNKNOWN.getValue(),ResultEnum.OPERATION_UNKNOWN.getName());
    }

}
