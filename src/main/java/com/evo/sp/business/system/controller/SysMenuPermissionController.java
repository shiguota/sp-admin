package com.evo.sp.business.system.controller;


import com.evo.sp.business.system.entity.SysMenuPermission;
import com.evo.sp.business.system.entity.vo.SysMenuPermissionVo;
import com.evo.sp.business.system.service.ISysMenuPermissionService;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.result.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.evo.sp.common.BaseController;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 菜单权限表 前端控制器
 * </p>
 *
 * @author sgt
 * @apiDefine MenuPermission 菜单权限接口
 * @since 2019-04-10
 */
@RestController
@RequestMapping(SpConstantInter.SYS_MENU_PERMISSION)
@Api(tags = "菜单权限")
public class SysMenuPermissionController extends BaseController {

    @Autowired
    private ISysMenuPermissionService iSysMenuPermissionService;


    /**
     * @api {post} /sys/menu/permission/save 菜单授权（可批量，注：已弃用）
     * @apiName save
     * @apiGroup MenuPermission
     * @apiHeader {applications/json} ContentType 请求参数为json格式
     * @apiParam {Array} data JSON格式数据
     * @apiParam {String} sysMenuId  菜单id.
     * @apiParam {String} sysPermissionId   权限id.
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
    @RequestMapping(value = SpConstantInter.SYS_MENU_PERMISSION_BAN_SAVE, method = RequestMethod.POST)
    public Result saveMenuPermission(@RequestBody List<SysMenuPermission> sysMenuPermission) {
        return save(sysMenuPermission, iSysMenuPermissionService);
    }


    /**
     * @api {post} /sys/menu/permission/del 删除权限（可批量，注：已弃用）
     * @apiName del
     * @apiGroup MenuPermission
     * @apiHeader {applications/json} ContentType 请求参数为json格式
     * @apiParam {Array} ids   菜单id.
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
    @RequestMapping(value = SpConstantInter.SYS_MENU_PERMISSION_DEL, method = RequestMethod.POST)
    public Result delMenuPermission(@RequestBody List<String> ids) {
        return dels(ids, iSysMenuPermissionService);
    }


    /**
     * @api {post} /sys/menu/permission/del/save  菜单授权
     * @apiName /del/save
     * @apiGroup MenuPermission
     * @apiHeader {applications/json} ContentType 请求参数为json格式
     * @apiParam {String} sysMenuId  菜单id.
     * @apiParam {Array} perIds   权限id.
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
    @PostMapping(value = SpConstantInter.SYS_MENU_PERMISSION_SAVE)
    public Result saveMenuPermission(@RequestBody SysMenuPermissionVo sysMenuPermissionVo) {
        return iSysMenuPermissionService.saveMenuPermission(sysMenuPermissionVo);
    }

    /**
     * 修改（暂无需求）
     */
    @RequestMapping(value = SpConstantInter.SYS_MENU_PERMISSION_MPODIFY, method = RequestMethod.POST)
    public Result modifyMenuPermission(@RequestBody SysMenuPermission sysMenuPermission) {
        return modify(sysMenuPermission, iSysMenuPermissionService);
    }
}
