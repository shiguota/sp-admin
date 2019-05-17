package com.evo.sp.business.system.controller;


import com.evo.sp.business.system.entity.SysRolePermission;
import com.evo.sp.business.system.entity.vo.SysRolePermissionVo;
import com.evo.sp.business.system.service.ISysRolePermissionService;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.result.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.evo.sp.common.BaseController;

import java.io.Serializable;

/**
 * <p>
 * 角色权限表 前端控制器
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 * @apiDefine RolePermission 角色权限接口
 */
@RestController
@RequestMapping(SpConstantInter.SYS_ROLE_PERMISSION)
@Api(tags = "角色权限")
public class SysRolePermissionController extends BaseController {

    @Autowired
    private ISysRolePermissionService iSysRolePermissionService;


    /**
     * @api {post} /sys/role/permission/save 角色授权
     * @apiName save
     * @apiGroup RolePermission
     * @apiHeader {applications/json} ContentType 请求参数为json格式
     * @apiParam  {String} sysRoleId 角色id
     * @apiParam {Array} permissionId 权限id数组.
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
    @RequestMapping(value = SpConstantInter.SYS_ROLE_PERMISSION_SAVE, method = RequestMethod.POST)
    public Result saveRolePermission(@RequestBody SysRolePermissionVo sysRolePermission) {
        return iSysRolePermissionService.saveBatch(sysRolePermission);
    }
}
