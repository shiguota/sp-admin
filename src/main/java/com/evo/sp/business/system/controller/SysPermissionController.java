package com.evo.sp.business.system.controller;


import com.evo.sp.business.system.entity.SysPermission;
import com.evo.sp.business.system.entity.vo.SysPermissionVo;
import com.evo.sp.business.system.service.ISysPermissionService;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.result.Result;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.Api;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.evo.sp.common.BaseController;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 权限表 前端控制器
 * </p>
 *
 * @author sgt
 * @apiDefine Permission 权限接口
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
     * @apiParam {String} perCode 权限编码(保存后不可修改).
     * @apiParam {Integer} state 状态 1可用  0禁用.
     * @apiParam {String} perDescribe 权限描述.
     * @apiSuccess {String} data 新增权限id.
     * @apiSuccess {OBJECT} extension 扩展对象.
     * @apiSuccess {String} id 新增的权限id.
     * @apiSuccess {Integer} code 操作编码.
     * @apiSuccess {String} msg 描述(根据code值去码表中查询对应的描述信息).
     * @apiSuccessExample 成功响应:
     * HTTP/1.1 200 OK
     * {
     * "date": "3b50a4e9baf8d24b93bae8b0b0763459",
     * "code": 1007,
     * "msg": "操作成功"
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
        return new Result(true, iSysPermissionService.savePerBackId(sysPermission));
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
     * @apiParam {String} id 权限id
     * @apiParam {String} perName 权限名称
     * @apiParam {String} perDescribe 权限备注
     * @apiParam {Integer} state 状态 1可用  0禁用.
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
        return new Result(iSysPermissionService.modifyPermission(sysPermission));
    }

    /**
     * @api {post} /sys/permission/menu 查询菜单权限
     * @apiName menu
     * @apiGroup Permission
     * @apiHeader {application/x-www-form-urlencoded} ContentType 请求参数为from方式提交
     * @apiParam {String} menuId   菜单id.
     * @apiSuccess {JSONOBJECT} data 接口返回的数据对象.
     * @apiSuccess (data){String} id 权限id.
     * @apiSuccess (data){String} perCode 权限编码.
     * @apiSuccess (data){String} perName 权限名称.
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
     * @api {post} /sys/permission/menu/user 获取用户菜单权限
     * @apiName /menu/user
     * @apiGroup Permission
     * @apiHeader {application/x-www-form-urlencoded} ContentType 请求参数为from方式提交
     * @apiParam {String} [menuId]  菜单id .
     * @apiParam {String} userId  用户id .
     * @apiSuccess {ARRAY} data 接口返回的数据对象.
     * @apiSuccess (data) {String} id 权限id.
     * @apiSuccess (data) {String} perCode 权限编码.
     * @apiSuccess (data) {String} perName 权限名称.
     * @apiSuccess (data) {String} perDescribe 权限描述.
     * @apiSuccess {Integer} code 操作编码.
     * @apiSuccess {String} msg 描述(根据code值去码表中查询对应的描述信息).
     * @apiSuccessExample 成功响应:
     * HTTP/1.1 200 OK
     * {
     * "date": [
     * {
     * "state": 1,
     * "id": "20617f444d2d1765b7bd89350744dae3",
     * "perName": "访问",
     * "perCode": "access",
     * "perDescribe": "访问数据"
     * },
     * {
     * "state": 1,
     * "id": "4f84a4a99567a80202e0f0fafacd243b",
     * "perName": "新增",
     * "perCode": "add",
     * "perDescribe": "新增数据"
     * }
     * ],
     * "code": 1007,
     * "msg": "操作成功",
     * "extension": null
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

//    获取当前登录账号以及被勾选账号的某个菜单的权限差集（暂时弃用）

    /**
     * @api {post} /sys/permission/menu/user/difset  获取菜单权限差集（已弃用）
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


    /**
     * @api {post} /sys/permission/role  查询角色权限
     * @apiName role
     * @apiGroup Permission
     * @apiHeader {applications/json} ContentType 请求参数为json格式
     * @apiParam {String} userId  用户Id.
     * @apiParam {String} roleId  角色Id .
     * @apiParam {String} menuId  菜单id .
     * @apiSuccess {JSONOBJECT} data 接口返回的数据对象.
     * @apiSuccess (data){Date} createTime 创建时间.
     * @apiSuccess (data){String} id 权限id.
     * @apiSuccess (data){String} perName 权限名称.
     * @apiSuccess (data){String} perCode 权限编码.
     * @apiSuccess (data){Date} updateTime 修改时间.
     * @apiSuccess (data){Integer} isExist 是否存在的权限（选中的角色）.
     * @apiSuccess {Integer} code 操作编码.
     * @apiSuccess {String} msg 描述(根据code值去码表中查询对应的描述信息).
     * @apiSuccessExample 成功响应:
     * HTTP/1.1 200 OK
     * {
     *     "date": [
     *         {
     *             "createTime": "2019-05-13 17:41:56",
     *             "id": "20617f444d2d1765b7bd89350744dae3",
     *             "perName": "访问",
     *             "perCode": "access",
     *             "isExist": "1",
     *             "updateTime": "2019-05-13 17:41:56"
     *         },
     *         {
     *             "createTime": "2019-05-08 17:01:44",
     *             "id": "4f84a4a99567a80202e0f0fafacd243b",
     *             "perName": "新增",
     *             "perCode": "add",
     *             "isExist": "1",
     *             "updateTime": "2019-05-08 17:06:55"
     *         },
     *         {
     *             "createTime": "2019-05-13 17:41:56",
     *             "id": "20617f444d2d1765b7bd89350744dae3",
     *             "perName": "访问",
     *             "perCode": "access",
     *             "isExist": "0",
     *             "updateTime": "2019-05-13 17:41:56"
     *         }
     *     ],
     *     "code": 1007,
     *     "msg": "操作成功",
     *     "extension": null
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
    @PostMapping(value = SpConstantInter.SYS_PERMISSION_ROLE)
    @JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
    public Result queryRolePer(@RequestBody SysPermissionVo sysPermissionVo) {
        return iSysPermissionService.queryPerByUIdMIdRId(sysPermissionVo);
    }
}
