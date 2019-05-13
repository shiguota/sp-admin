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
import javafx.scene.input.Mnemonic;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     * @apiParam {Integer} [state]   状态 1可用  0禁用  默认为1.
     * @apiParam {String} pid   菜单pid.
     * @apiParam {Integer} [sort]  排序.
     * @apiParam {Array} [sysMenuPermission]  权限对象.
     * @apiParam (sysMenuPermission){String} sysPermissionId  权限id.
     * @apiSuccess {Object} data 接口返回的数据对象.
     * @apiSuccess {Integer} code 操作编码.
     * @apiSuccess {String} msg 描述(根据code值去码表中查询对应的描述信息).
     * @apiSuccessExample 成功响应:
     * HTTP/1.1 200 OK
     * {
     * "data": true,
     * "code": xxxxx ,
     * "msg": "提示"
     * }
     * @apiError data false.
     * @apiError code 操作编码.
     * @apiError msg 描述(根据code值去码表中查询对应的描述信息).
     * @apiErrorExample 错误响应示例:
     * {
     * "data": false,
     * "code": xxxx,
     * "msg": "xxxxxxxx"
     * }
     */
    @RequestMapping(value = SpConstantInter.SYS_MENU_SAVE, method = RequestMethod.POST)
    public Result saveMenu(@RequestBody SysMenuVo sysMenuVo) {
        return iSysMenuService.menuSave(sysMenuVo);
    }


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
     * "data": true,
     * "code": xxxxx ,
     * "msg": "提示"
     * }
     * @apiError data false.
     * @apiError code 操作编码.
     * @apiError msg 描述(根据code值去码表中查询对应的描述信息).
     * @apiErrorExample 错误响应示例:
     * {
     * "data": false,
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
     * @apiParam {Integer} state   状态  1可用  0禁用.
     * @apiParam {String} pid   菜单pid.
     * @apiParam {Integer} [sort]  排序.
     * @apiSuccess {Object} data 接口返回的数据对象.
     * @apiSuccess {Integer} code 操作编码.
     * @apiSuccess {String} msg 描述(根据code值去码表中查询对应的描述信息).
     * @apiSuccessExample 成功响应:
     * HTTP/1.1 200 OK
     * {
     * "data": true,
     * "code": xxxxx ,
     * "msg": "提示"
     * }
     * @apiError data false.
     * @apiError code 操作编码.
     * @apiError msg 描述(根据code值去码表中查询对应的描述信息).
     * @apiErrorExample 错误响应示例:
     * {
     * "data": false,
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
     * @paiSuccess (records) {Integer} state 状态 1可用  0禁用  默认为1.
     * @paiSuccess (records) {Integer} sort 排序.
     * @paiSuccess (records) {Date} createTime 创建时间.
     * @paiSuccess (records) {Date} updateTime 修改时间.
     * @apiSuccess {Object} data 接口返回的数据对象.
     * @apiSuccess {Integer} code 操作编码.
     * @apiSuccess {String} msg 描述(根据code值去码表中查询对应的描述信息).
     * @apiSuccessExample 成功响应:
     * HTTP/1.1 200 OK
     * {
     * "data": {},
     * "code": xxxxx ,
     * "msg": "提示"
     * }
     * @apiError data false.
     * @apiError code 操作编码.
     * @apiError msg 描述(根据code值去码表中查询对应的描述信息).
     * @apiErrorExample 错误响应示例:
     * {
     * "data": false,
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
     * "data": {},
     * "code": xxxxx ,
     * "msg": "提示"
     * }
     * @apiError data false.
     * @apiError code 操作编码.
     * @apiError msg 描述(根据code值去码表中查询对应的描述信息).
     * @apiErrorExample 错误响应示例:
     * {
     * "data": false,
     * "code": xxxx,
     * "msg": "xxxxxxxx"
     * }
     */

    @RequestMapping(value = SpConstantInter.SYS_MENU_PATH, method = RequestMethod.POST)
    public Result queryMenus(String userId) {
        List<Tree<SysMenu>> sysMenus = iSysMenuService.queryMenuPath(userId);
        return queryTreeData(sysMenus, TOP_NODE_NAME);
    }

    /**
     * @api {post} /sys/menu/tree  菜单树
     * @apiName tree
     * @apiGroup Menu
     * @apiSuccess {JSONOBJECT} data 接口返回的数据对象.
     * @apiSuccess (data){String} id 节点id.
     * @apiSuccess (data){Integer} isOpen 节点是否打开（1 打开，2关闭）.
     * @apiSuccess (data){String} text 节点名称.
     * @apiSuccess (data){Integer} state 状态（1 启用，0 禁用）.
     * @apiSuccess (data){String} parentId 父id.
     * @apiSuccess (data){String} path 路径.
     * @apiSuccess (data){String} icon icon路径.
     * @apiSuccess (data){Integer} level 级别.
     * @apiSuccess (data){String} code 菜单编码.
     * @apiSuccess (data){JSONOBJECT} children 子节点集合.
     * @apiSuccess {Integer} code 操作编码.
     * @apiSuccess {String} msg 描述(根据code值去码表中查询对应的描述信息).
     * @apiSuccessExample 成功响应:
     * HTTP/1.1 200 OK
     * {
     * "date": {
     * "treeId": "0-0",
     * "id": "-1",
     * "text": "首页",
     * "isOpen": null,
     * "checked": true,
     * "attributes": null,
     * "children": [
     * {
     * "id": "8340a0a5023932fc13c99bd0c4013b5b",
     * "text": "字典数据",
     * "isOpen": 2,
     * "children": [],
     * "parentId": "-1",
     * "path": "/dis",
     * "icon": "DIC_ICON",
     * "level": 1,
     * "code": null,
     * "state": 1,
     * "parent": false
     * }
     * ],
     * "parentId": "",
     * "path": "#",
     * "icon": null,
     * "level": 0,
     * "code": null,
     * "state": null,
     * "parent": false
     * },
     * "code": 1007,
     * "msg": "操作成功"
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
    @PostMapping(value = SpConstantInter.SYS_MENU_PERMISSION_TREE)
    public Result queryMenuTree() {
        return queryTreeData(iSysMenuService.queryMenuTree(), TOP_NODE_NAME);
    }

    /**
     * @api {post} /sys/menu/pid  根据pid查询
     * @apiName pid
     * @apiGroup Menu
     * @apiHeader {application/x-www-form-urlencoded} ContentType 请求参数为from方式提交
     * @apiParam {String} pid   父id.
     * @apiSuccess {JSONOBJECT} data 接口返回的数据对象.
     * @apiSuccess (data){String} id 节点id.
     * @apiSuccess (data){Integer} isOpen 节点是否打开（0 打开，1关闭）.
     * @apiSuccess (data){String} text 节点名称.
     * @apiSuccess (data){Integer} state 状态（1 启用，0 禁用）.
     * @apiSuccess (data){String} parentId 父id.
     * @apiSuccess (data){String} path 路径.
     * @apiSuccess (data){String} icon icon路径.
     * @apiSuccess (data){Integer} level 级别.
     * @apiSuccess (data){String} code 菜单编码.
     * @apiSuccess (data){JSONOBJECT} children 子节点集合.
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
    @PostMapping(value = SpConstantInter.SYS_MENU_PID)
    public Result queryMenuByPid(String pid) {
        return new Result(iSysMenuService.queryMenuTreeByPid(pid));
    }

    /**
     * @api {post} /sys/menu/id 根据id查询
     * @apiName id
     * @apiGroup Menu
     * @apiHeader {application/x-www-form-urlencoded} ContentType 请求参数为from方式提交
     * @apiParam {String} id 菜单id.
     * @apiSuccess {Object} data 接口返回的数据对象.
     * @apiSuccess (data){String} id 节点id.
     * @apiSuccess (data){Integer} isOpen 节点是否打开（0 打开，1关闭）.
     * @apiSuccess (data){String} text 节点名称.
     * @apiSuccess (data){Integer} state 状态（1 启用，0 禁用）.
     * @apiSuccess (data){String} parentId 父id.
     * @apiSuccess (data){String} path 路径.
     * @apiSuccess (data){String} icon icon路径.
     * @apiSuccess (data){Integer} level 级别.
     * @apiSuccess (data){String} code 菜单编码.
     * @apiSuccess {Integer} code 操作编码.
     * @apiSuccess {String} msg 描述(根据code值去码表中查询对应的描述信息).
     * @apiSuccessExample 成功响应:
     * HTTP/1.1 200 OK
     * {
     *   "date": {
     *     "createTime": "2019-05-08T16:16:37",
     *     "updateTime": "2019-05-08T16:16:37",
     *     "state": 1,
     *     "id": "8340a0fc13c99bd0fg6fg7dhg6gf7",
     *     "menuName": "系统菜单",
     *     "menuCode": "MENU_CODE",
     *     "menuIcon": "MENU_ICON",
     *     "menuPath": "/menu",
     *     "sort": null,
     *     "pid": "8340a0a5023932fc13c99bd0c4013b5b",
     *     "level": 2,
     *     "isOpen": 2
     *   },
     *   "code": 1007,
     *   "msg": "操作成功"
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
    @PostMapping(value = SpConstantInter.SYS_MENU_ID)
    public Result queryById(String id) {
        return queryById(id, iSysMenuService);
    }


}
