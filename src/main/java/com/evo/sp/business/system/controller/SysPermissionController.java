package com.evo.sp.business.system.controller;


import com.evo.sp.business.system.entity.SysPermission;
import com.evo.sp.business.system.entity.vo.SysPermissionVo;
import com.evo.sp.business.system.service.ISysPermissionService;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.result.Result;
import io.swagger.annotations.Api;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.evo.sp.common.BaseController;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 权限表 前端控制器
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
@RestController
@RequestMapping(SpConstantInter.SYS_PERMISSION)
@Api(tags = "权限")
public class SysPermissionController extends BaseController {

    @Autowired
    private ISysPermissionService iSysPermissionService;


    /**
     * @api {post} /sys/permission/save 新增
     * @apiName save
     * @apiGroup Permission
     * @apiHeader {applications/json} ContentType 请求参数为json格式
     * @apiParam {String} perName 权限名称
     * @apiParam {String} perCode 权限编码.
     * @apiParam {String} perDescribe 权限描述.
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
    @RequestMapping(value = SpConstantInter.SYS_PERMISSION_SAVE, method = RequestMethod.POST)
    public Result savePermission(@RequestBody SysPermission sysPermission) {
        return save(sysPermission, iSysPermissionService);
    }

    /**
     * @api {post} /sys/permission/del  删除
     * @apiName del
     * @apiGroup Permission
     * @apiHeader {applications/json} ContentType 请求参数为json格式
     * @apiParam {Array} ids   权限id.
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
    @RequestMapping(value = SpConstantInter.SYS_PERMISSION_DEL, method = RequestMethod.POST)
    public Result delPermission(@RequestBody List<String> ids) {
        return dels(ids, iSysPermissionService);
    }


    /**
     * @api {post} /sys/permission/modify  修改
     * @apiName modify
     * @apiGroup Permission
     * @apiHeader {applications/json} ContentType 请求参数为json格式
     * @apiParam {String} perName 权限名称
     * @apiParam {String} perCode 权限编码.
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
    @RequestMapping(value = SpConstantInter.SYS_PERMISSION_MODIFY, method = RequestMethod.POST)
    public Result modifyPermission(@RequestBody SysPermission sysPermission) {
        return modify(sysPermission, iSysPermissionService);
    }

    /**
     * @api {post} /sys/permission/menu 菜单获取权限
     * @apiName menu
     * @apiGroup Permission
     * @apiHeader {application/x-www-form-urlencoded} ContentType 请求参数为from方式提交
     * @apiParam {String} menuId   菜单id.
     * @apiSuccess {JSONOBJECT} data 接口返回的数据对象.
     * @apiSuccess (data){String} id 权限id.
     * @apiSuccess (data){String} perCode 权限编码.
     * @apiSuccess (data){String} perName 权限名称.
     * @apiSuccess (data){Date} createTime 创建时间.
     * @apiSuccess (data){Date} updateTime 修改时间.
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
    @RequestMapping(value = SpConstantInter.SYS_PERMISSION_MENU, method = RequestMethod.POST)
    public Result queryPerByMenuId(String menuId) {
        return iSysPermissionService.queryPerByMenuId(menuId);
    }

    /**
     * @api {post} /sys/permission/menu/user 根据用户id以及菜单id，获取该菜单下，当前用户拥有的权限
     * @apiName /menu/user
     * @apiGroup Permission
     * @apiHeader {application/x-www-form-urlencoded} ContentType 请求参数为from方式提交
     * @apiParam {String} menuId  菜单id .
     * @apiParam {String} userId  用户id .
     * @apiSuccess {List} data 接口返回的数据对象.
     * @apiSuccess (data) {String} id 权限id.
     * @apiSuccess (data) {String} perCode 权限编码.
     * @apiSuccess (data) {String} perName 权限名称.
     * @apiSuccess (data) {String} perDescribe 权限描述.
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
    @RequestMapping(value = SpConstantInter.SYS_PERMISSION_MENU_USER, method = RequestMethod.POST)
    public Result queryPerByMenuUser(String menuId, String userId) {
        return iSysPermissionService.queryPerByMenuUser(menuId, userId);
    }

    /**
     * @api {post} /sys/permission/menu/user/difset 获取当前登录账号以及被勾选账号的某个菜单的权限差集
     * @apiName /menu/user/difset
     * @apiGroup Permission
     * @apiHeader {applications/json} ContentType 请求参数为json格式
     * @apiParam {String} menuId  菜单id.
     * @apiParam {String} LUserId   系统当前登录用户id.
     * @apiParam {String} userId   被选中用户id.
     * @apiSuccess {List} data 接口返回的数据对象.
     * @apiSuccess (data) {String} id 权限id.
     * @apiSuccess (data) {String} perCode 权限编码.
     * @apiSuccess (data) {String} perName 权限名称.
     * @apiSuccess (data) {String} perDescribe 权限描述.
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
    @RequestMapping(value = SpConstantInter.SYS_PERMISSION_MENU_USER_DIF_SET, method = RequestMethod.POST)
    public Result queryPerByMenuUserDifSet(@RequestBody SysPermissionVo sysPermissionVo) {
        return iSysPermissionService.queryPerByMenuUserDifSet(sysPermissionVo);
    }

}
