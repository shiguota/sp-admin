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
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
     * @api {post} /sys/menu/save 新增
     * @apiName save
     * @apiGroup Menu
     * @apiHeader {applications/json} ContentType 请求参数为json格式
     * @apiParam {String} menuName  菜单名称.
     * @apiParam {String} menuCode   菜单编码.
     * @apiParam {String} menuIcon   菜单Icon.
     * @apiParam {String} menuPath   菜单路径.
     * @apiParam {String} systemDictionaryId   字典表id.
     * @apiParam {String} pid   菜单pid.
     * @apiParam {Integer} [sort]  排序.
     * @apiSuccess {Object} data 接口返回的数据对象.
     * @apiSuccess {Integer} code 操作编码.
     * @apiSuccess {String} msg 描述(根据code值去码表中查询对应的描述信息).
     * @apiSuccessExample 成功响应:
     * HTTP/1.1 200 OK
     * {
     * "date": true,
     * "code": xxxxx ,
     * "msg": "提示"
     * }
     * @apiError data false.
     * @apiError code 操作编码.
     * @apiError msg 描述(根据code值去码表中查询对应的描述信息).
     * @apiErrorExample 错误响应示例:
     * {
     * "date": false,
     * "code": xxxx,
     * "msg": "xxxxxxxx"
     * }
     */
    @RequestMapping(value = SpConstantInter.SYS_MENU_SAVE, method = RequestMethod.POST)
    public Result saveMenu(@RequestBody SysMenuVo sysMenuVo) {
        return iSysMenuService.menuSave(sysMenuVo);
    }

    /**
     * 删除
     */

    /**
     * @api {post} /sys/menu/del 删除
     * @apiName del
     * @apiGroup Menu
     * @apiHeader {application/x-www-form-urlencoded} ContentType 请求参数为from方式提交
     * @apiParam {String} id   菜单id.
     * @apiSuccess {Object} data 接口返回的数据对象.
     * @apiSuccess {Integer} code 操作编码.
     * @apiSuccess {String} msg 描述(根据code值去码表中查询对应的描述信息).
     * @apiSuccessExample 成功响应:
     * HTTP/1.1 200 OK
     * {
     * "date": true,
     * "code": xxxxx ,
     * "msg": "提示"
     * }
     * @apiError data false.
     * @apiError code 操作编码.
     * @apiError msg 描述(根据code值去码表中查询对应的描述信息).
     * @apiErrorExample 错误响应示例:
     * {
     * "date": false,
     * "code": xxxx,
     * "msg": "xxxxxxxx"
     * }
     */
    @RequestMapping(value = SpConstantInter.SYS_MENU_DEL, method = RequestMethod.POST)
    public Result delMenu(Serializable id) {
        return del(id, iSysMenuService);
    }


    /**
     * @api {post} /sys/menu/modify 修改
     * @apiName modify
     * @apiGroup Menu
     * @apiHeader {applications/json} ContentType 请求参数为json格式
     * @apiParam {String} menuName  菜单名称.
     * @apiParam {String} menuCode   菜单编码.
     * @apiParam {String} menuIcon   菜单Icon.
     * @apiParam {String} menuPath   菜单路径.
     * @apiParam {String} systemDictionaryId   字典表id.
     * @apiParam {String} pid   菜单pid.
     * @apiParam {Integer} [sort]  排序.
     * @apiSuccess {Object} data 接口返回的数据对象.
     * @apiSuccess {Integer} code 操作编码.
     * @apiSuccess {String} msg 描述(根据code值去码表中查询对应的描述信息).
     * @apiSuccessExample 成功响应:
     * HTTP/1.1 200 OK
     * {
     * "date": true,
     * "code": xxxxx ,
     * "msg": "提示"
     * }
     * @apiError data false.
     * @apiError code 操作编码.
     * @apiError msg 描述(根据code值去码表中查询对应的描述信息).
     * @apiErrorExample 错误响应示例:
     * {
     * "date": false,
     * "code": xxxx,
     * "msg": "xxxxxxxx"
     * }
     */
    @RequestMapping(value = SpConstantInter.SYS_MENU_MODIFY, method = RequestMethod.POST)
    public Result modifyMenu(@RequestBody SysMenu sysMenu) {
        return modify(sysMenu, iSysMenuService);
    }


    /**
     * @api {post} /sys/menu/page 查询菜单（分页）
     * @apiName page
     * @apiGroup Menu
     * @apiHeader {applications/json} ContentType 请求参数为json格式
     * @apiParam {Integer} page 当前页.
     * @apiParam {Integer} size 每页行数.
     * @apiParam {String} [menuName]  菜单名称.
     * @apiSuccess {JSONOBJECT} data JSON格式数据.
     * @apiSuccess (data){List} records JSON格式数据（列表数据）.
     * @apiSuccess (data){Integer} total 数据总数.
     * @apiSuccess (data){Integer} size 每页行数.
     * @apiSuccess (data){Integer} current 当前页.
     * @apiSuccess (data){Integer} pages 总页数.
     * @paiSuccess (records) {String} menuName 菜单名称.
     * @paiSuccess (records) {String} menuCode 菜单编码.
     * @paiSuccess (records) {String} menuIcon 菜单Icon.
     * @paiSuccess (records) {String} menuPath 菜单路径.
     * @paiSuccess (records) {Integer} state 状态.
     * @paiSuccess (records) {Integer} sort 排序.
     * @paiSuccess (records) {Date} createTime 创建时间.
     * @paiSuccess (records) {Date} updateTime 修改时间.
     * @apiSuccess {Object} data 接口返回的数据对象.
     * @apiSuccess {Integer} code 操作编码.
     * @apiSuccess {String} msg 描述(根据code值去码表中查询对应的描述信息).
     * @apiSuccessExample 成功响应:
     * HTTP/1.1 200 OK
     * {
     * "date": {},
     * "code": xxxxx ,
     * "msg": "提示"
     * }
     * @apiError data false.
     * @apiError code 操作编码.
     * @apiError msg 描述(根据code值去码表中查询对应的描述信息).
     * @apiErrorExample 错误响应示例:
     * {
     * "date": false,
     * "code": xxxx,
     * "msg": "xxxxxxxx"
     * }
     */
    @RequestMapping(value = SpConstantInter.SYS_MENU_PAGE, method = RequestMethod.POST)
    public Result queryMenuPage(@RequestBody PageRequestParameter<SysMenuVo> pageRequestParameter) {
        return iSysMenuService.queryListPage(pageRequestParameter);
    }


    /**
     * @api {post} /sys/menu/path 查询菜单（用户权限范围内）
     * @apiName path
     * @apiGroup Menu
     * @apiHeader {application/x-www-form-urlencoded} ContentType 请求参数为from方式提交
     * @apiParam {String} userId 用户id.
     * @apiSuccess {Object} data 接口返回的数据对象.
     * @apiSuccess {Integer} code 操作编码.
     * @apiSuccess {String} msg 描述(根据code值去码表中查询对应的描述信息).
     * @apiSuccessExample 成功响应:
     * HTTP/1.1 200 OK
     * {
     * "date": {},
     * "code": xxxxx ,
     * "msg": "提示"
     * }
     * @apiError data false.
     * @apiError code 操作编码.
     * @apiError msg 描述(根据code值去码表中查询对应的描述信息).
     * @apiErrorExample 错误响应示例:
     * {
     * "date": false,
     * "code": xxxx,
     * "msg": "xxxxxxxx"
     * }
     */

    @RequestMapping(value = SpConstantInter.SYS_MENU_PATH, method = RequestMethod.POST)
    @RequiresPermissions("sys:menu:path")
    public Result queryMenus(String userId) {
        //获取当前用户所拥有权限范围内的菜单
        List<Tree<SysMenu>> sysMenus = iSysMenuService.queryMenuPath();
        return queryTreeData(sysMenus, TOP_NODE_NAME);
    }
}
