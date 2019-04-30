package com.evo.sp.business.system.controller;


import com.evo.sp.business.system.entity.SysRole;
import com.evo.sp.business.system.entity.vo.SysRoleVo;
import com.evo.sp.business.system.service.ISysRoleService;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.parameter.PageRequestParameter;
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
 * 角色表 前端控制器
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
@RestController
@RequestMapping(value = SpConstantInter.SYS_ROLE)
@Api(tags = "角色")
public class SysRoleController extends BaseController {

    @Autowired
    private ISysRoleService iSysRoleService;


    /**
     * @api {post} /sys/role/save 新增(授权:角色与权限关联)
     * @apiName save
     * @apiGroup Role
     * @apiHeader {applications/json} ContentType 请求参数为json格式
     * @apiParam {String} orgId 机构id
     * @apiParam {String} roleName  角色名称.
     * @apiParam {String} roleCode  角色编码 .
     * @apiParam {String} [roleDescription] roleDescription  角色描述 .
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
    @RequestMapping(value = SpConstantInter.SYS_ROLE_SAVE, method = RequestMethod.POST)
    public Result saveRole(@RequestBody SysRoleVo roleVo) {
        return iSysRoleService.saveRole(roleVo);
    }


    /**
     * @api {post} /sys/role/del 删除角色（根据id）
     * @apiName del
     * @apiGroup Role
     * @apiHeader {application/x-www-form-urlencoded} ContentType 请求参数为from方式提交
     * @apiParam {String} id 角色id   .
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
    @RequestMapping(value = SpConstantInter.SYS_ROLE_DEL, method = RequestMethod.POST)
    public Result delRole(String id) {
        return del(id, iSysRoleService);
    }


    /**
     * @api {post} /sys/role/modify 修改角色
     * @apiName modify
     * @apiGroup Role
     * @apiHeader {applications/json} ContentType 请求参数为json格式
     * @apiParam {String} roleId 角色id .
     * @apiParam {String} [orgId] orgId 组织机构id .
     * @apiParam {String} roleName  角色名称 .
     * @apiParam {String} roleCode  角色编码 .
     * @apiParam {String} [roleDescription]  roleDescription  角色描述 .
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
    @RequestMapping(value = SpConstantInter.SYS_ROLE_MODIFY, method = RequestMethod.POST)
    public Result modifyRole(@RequestBody SysRoleVo sysRoleVo) {
        return iSysRoleService.modifyRole(sysRoleVo);
    }


    /**
     * @api {post} /sys/role/page 角色列表(分页)
     * @apiName login
     * @apiGroup Role
     * @apiHeader {applications/json} ContentType 请求参数为json格式
     * @apiParam {Integer} page 当前页。
     * @apiParam {Integer} size 每页行数
     * @apiParam {JSONOBJECT} parameter JSON格式数据
     * @apiParam (parameter) {String} roleName 角色名称 .
     * @apiSuccess {JSONOBJECT} data JSON格式数据.
     * @apiSuccess (data){List} records JSON格式数据（列表数据）.
     * @apiSuccess (data){Integer} total 数据总数.
     * @apiSuccess (data){Integer} size 每页行数.
     * @apiSuccess (data){Integer} current 当前页.
     * @apiSuccess (data){Integer} pages 总页数.
     * @apiSuccess (records) {String} roleName 角色名称.
     * @apiSuccess (records) {String} roleCode 角色编码.
     * @apiSuccess (records) {Date} createTime 创建时间.
     * @apiSuccess (records) {Date} updateTime 修改时间.
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
    @RequestMapping(value = SpConstantInter.SYS_ROLE_PAGE, method = RequestMethod.POST)
    public Result queryListPage(@RequestBody PageRequestParameter<SysRoleVo> pageRequestParameter) {
        return iSysRoleService.queryByNameOrg(pageRequestParameter.pageInstance(), pageRequestParameter.parameterInstance());
    }
}
