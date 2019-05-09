package com.evo.sp.business.system.controller;


import com.evo.sp.business.system.entity.SysUserRole;
import com.evo.sp.business.system.service.ISysUserRoleService;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.ex.SpAssert;
import com.evo.sp.common.result.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.evo.sp.common.BaseController;

/**
 * <p>
 * 用户角色表 前端控制器
 * </p>
 *
 * @author sgt
 * @since 2019-04-17
 */
@RestController
@RequestMapping(SpConstantInter.SYS_USER_ROLE)
@Api(tags = "用户角色")
public class SysUserRoleController extends BaseController {

    @Autowired
    private ISysUserRoleService iSysUserRoleService;


    /**
     * @api {post} /sys/user/role/save 新增（用户分配"角色"）
     * @apiName save
     * @apiGroup UserRole
     * @apiHeader {applications/json} ContentType 请求参数为json格式
     * @apiParam {String} sysRoleId   角色id.
     * @apiParam {String} sysUserId   用户id.
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
    @RequestMapping(value = SpConstantInter.SYS_USER_ROLE_SAVE, method = RequestMethod.POST)
    public Result saveUserRole(@RequestBody SysUserRole sysUserRole) {
        SpAssert.isNull(sysUserRole);
        SpAssert.isNull(sysUserRole.getSysRoleId());
        SpAssert.isNull(sysUserRole.getSysUserId());
        return save(sysUserRole, iSysUserRoleService);
    }

    /**
     *
     */
    /**
     * @api {post} /sys/user/role/del 删除（用户删除"角色"）
     * @apiName del
     * @apiGroup UserRole
     * @apiHeader {applications/json} ContentType 请求参数为json格式
     * @apiParam {String} sysRoleId   角色id.
     * @apiParam {String} sysUserId   用户id.
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
    @RequestMapping(value = SpConstantInter.SYS_USER_ROLE_DEL, method = RequestMethod.POST)
    public Result delUserRole(@RequestBody SysUserRole sysUserRole) {
        SpAssert.isNull(sysUserRole);
        SpAssert.isNull(sysUserRole.getSysRoleId());
        SpAssert.isNull(sysUserRole.getSysUserId());
        return del(sysUserRole, iSysUserRoleService);
    }
}
