package com.evo.sp.business.system.controller;


import com.evo.sp.business.system.entity.SysUser;
import com.evo.sp.business.system.entity.vo.SysUserVo;
import com.evo.sp.business.system.service.ISysUserService;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.ex.SpAssert;
import com.evo.sp.common.parameter.PageRequestParameter;
import com.evo.sp.common.result.Result;
import com.evo.sp.common.result.ResultEnum;
import io.swagger.annotations.Api;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.evo.sp.common.BaseController;

import java.util.List;


/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author sgt
 * @apiDefine User 用户接口
 * @since 2019-04-10
 */
@RestController
@RequestMapping(SpConstantInter.SYS_USER)
@Api(tags = "用户")
public class SysUserController extends BaseController {

    @Autowired
    private ISysUserService iSysUserService;

    /**
     * @api {post} /sys/user/login 登录
     * @apiName login
     * @apiGroup User
     * @apiHeader {application/x-www-form-urlencoded} ContentType 请求参数为from方式提交
     * @apiParam {String} account 用户登录账号.
     * @apiParam {String} password  账号密码.
     * @apiSuccess {Integer} code 操作编码.
     * @apiSuccess {OBJECT} data 数据对象.
     * @apiSuccess (data) {String} id 用户id.
     * @apiSuccess (data) {String} account 账号.
     * @apiSuccess (data) {String} sysOrganizationId 机构id.
     * @apiSuccess (data) {String} sysUserInfoId 用户详情id.
     * @apiSuccess {String} msg 操作编码对应的注释.
     * @apiSuccessExample 成功响应:
     * HTTP/1.1 200 OK
     * {
     * "data": {
     * "id": "75845fd5fdb7441137ec100b9af5bf33",
     * "account": "aa",
     * "sysOrganizationId": "1",
     * "sysUserInfoId": "81c18d45398c0927bb39a8c89aa33e53"
     * },
     * "code": 2002,
     * "msg": "登录成功"
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
    @PostMapping(value = SpConstantInter.SYS_USER_LOGIN)
    public Result userLogin(String account, String password) {
        return iSysUserService.login(account, password);
    }

    /**
     * @api {post} /sys/user/loginout 注销
     * @apiName loginout
     * @apiGroup User
     * @apiSuccess {Integer} code 操作编码.
     * @apiSuccess {String} smg 描述(根据code值去码表中查询对应的描述信息).
     * @apiSuccessExample 成功响应:
     * HTTP/1.1 200 OK
     * {
     * "data": true,
     * "code": 2007,
     * "msg": "注销用户成功"
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
    @RequestMapping(value = SpConstantInter.SYS_USER_LOGIN_OUT, method = RequestMethod.POST)
    public Result userLoginOut() {
        return iSysUserService.userLoginOut();
    }

    /**
     * @api {post} /sys/user/save 新增
     * @apiName save
     * @apiGroup User
     * @apiHeader {applications/json} ContentType 请求参数为json格式
     * @apiParam {JSONOBJECT} info JSON格式数据
     * @apiParam (info)  {Date}    [birthday]  生日
     * @apiParam (info)  {String}  [caid]   身份证号
     * @apiParam (info)  {Date}    [createTime]  创建时间
     * @apiParam (info)  {String}  email 邮箱
     * @apiParam (info)  {Integer} [height]  身高(cm)
     * @apiParam (info)  {String}  nickname 昵称
     * @apiParam (info)  {String}   phone 手机
     * @apiParam (info)  {String}  [qqAccount] QQ账号
     * @apiParam (info)  {Integer} [sex]  性别 0 保密  1男  2女
     * @apiParam (info)  {String}  [sig]  签名
     * @apiParam (info)  {Integer} [state]  状态  1可用（默认） 2 废弃
     * @apiParam (info)  {String}  [wbAccount]  微博账号
     * @apiParam (info)  {Integer} [weight]   体重（公斤）
     * @apiParam (info)  {String}  [wxAccount]  微信账号
     * @apiParam (info)  {String}  [wxOpenid]    微信账号OPENID
     * @apiParam (info)  {String}  [national]  籍贯
     * @apiParam {String} account 用户账号 .
     * @apiParam {String} password  用户密码 .
     * @apiParam {String} userType  用户类型 .
     * @apiParam {String} sysOrganizationId  机构id .
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
    @RequestMapping(value = SpConstantInter.SYS_USER_SAVE, method = RequestMethod.POST)
    @Transactional
    public Result saveUser(@RequestBody SysUserVo sysUserVo) {
        return iSysUserService.saveUser(sysUserVo);
    }

    /**
     * @api {post} /sys/user/del 删除
     * @apiName del
     * @apiGroup User
     * @apiHeader {applications/json} ContentType 请求参数为json格式
     * @apiParam {String} id 用户id
     * @apiParam {String} sysUserInfoId 用户详情id
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
    @PostMapping(value = SpConstantInter.SYS_USER_DEL)
    public Result delUser(@RequestBody List<SysUserVo> ids) {
        return iSysUserService.dels(ids);
    }

    /**
     * @api {post} /sys/user/modify  修改
     * @apiName modify
     * @apiGroup User
     * @apiHeader {applications/json} ContentType 请求参数为json格式
     * @apiParam {String} account  账号.
     * @apiParam {Integer} userType  账号类型.
     * @apiParam {Integer} state 类型.
     * @apiParam {String} sysOrganizationId 组织结构id.
     * @apiParam {JSONOBJECT} info  JSON格式数据.
     * @apiParam (info) {String} nickname 昵称 .
     * @apiParam (info) {String} email 邮箱.
     * @apiParam (info) {String} phone 手机.
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
    @PostMapping(value = SpConstantInter.SYS_USER_MODIFY)
    public Result modifyUser(@RequestBody SysUserVo sysUserVo) {
        SpAssert.isNull(sysUserVo.getId());
        return modify(sysUserVo, iSysUserService);
    }

    /**
     * @api {post} /sys/user/one  查询用户
     * @apiName one
     * @apiGroup User
     * @apiHeader {application/x-www-form-urlencoded} ContentType 请求参数为from方式提交
     * @apiParam {String} id   用户id.
     * @apiSuccess {JSONOBJECT} data json格式数据
     * @apiSuccess (data) {String} account  账号.
     * @apiSuccess (data) {Integer} userType  账号类型.
     * @apiSuccess (data) {Integer} state 类型.
     * @apiSuccess (data) {String} sysOrganizationId 组织结构id.
     * @apiSuccess (data) {String} nickname 昵称 .
     * @apiSuccess (data) {String} email 邮箱.
     * @apiSuccess (data) {String} phone 手机.
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
    @RequestMapping(value = SpConstantInter.SYS_USER_QUERY_ONE, method = RequestMethod.POST)
    public Result queryOne(String id) {
        return iSysUserService.queryUserById(id);
    }


    /**
     * @api {post} /sys/user/page  用户列表
     * @apiName page
     * @apiGroup User
     * @apiHeader {applications/json} ContentType 请求参数为json格式
     * @apiParam {Integer} page 当前页。
     * @apiParam {Integer} size 每页行数
     * @apiParam {String} sysOrganizationId 组织结构id
     * @apiParam {JSONOBJECT} parameter JSON格式数据
     * @apiParam (parameter) {String} [account] 账号
     * @apiParam (parameter) {String} [nickName] 昵称 .
     * @apiParam (parameter) {String} [phone] 手机号.
     * @apiSuccess {JSONOBJECT} data JSON格式数据.
     * @apiSuccess (data){List} records JSON格式数据（列表数据）.
     * @apiSuccess (data){Integer} total 数据总数.
     * @apiSuccess (data){Integer} size 每页行数.
     * @apiSuccess (data){Integer} current 当前页.
     * @apiSuccess (data){Integer} pages 总页数.
     * @apiSuccess (records) {String} accotun 账号.
     * @apiSuccess (records) {String} nickname 昵称.
     * @apiSuccess (records) {String} orgName 机构名称.
     * @apiSuccess (records) {String} email 邮箱.
     * @apiSuccess (records) {String} phone 电话.
     * @apiSuccess (records) {String} state 用户状态.
     * @apiSuccess (records) {String} userType 用户类型.
     * @apiSuccess (records) {Date} createTime 创建时间.
     * @apiSuccess (records) {Date} updateTime 修改时间.
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
    @RequestMapping(value = SpConstantInter.SYS_USER_PAGE, method = RequestMethod.POST)
    public Result queryListPage(@RequestBody PageRequestParameter<SysUserVo> pageRequestParameter) {
        return iSysUserService.queryUserByOrg(pageRequestParameter.pageInstance(), pageRequestParameter.parameterInstance());
    }


    /**
     * @api {post} /sys/user/role 查询用户角色
     * @apiName role
     * @apiGroup User
     * @apiHeader {application/x-www-form-urlencoded} ContentType 请求参数为from方式提交
     * @apiParam {String} id  用户id.
     * @apiSuccess {Object} data 接口返回的数据对象.
     * @apiSuccess (data){String} roleCode 角色编码.
     * @apiSuccess (data){String} id 角色id.
     * @apiSuccess (data){String} roleName 角色名.
     * @apiSuccess {Integer} code 操作编码.
     * @apiSuccess {String} msg 描述(根据code值去码表中查询对应的描述信息).
     * @apiSuccessExample 成功响应:
     * HTTP/1.1 200 OK
     * {
     * "data": [
     * {
     * "roleCode": "admin",
     * "roleName": "超级管理员",
     * "id": "c0afe31b9702e32fec50f583224d8f1f"
     * }
     * ],
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
    @RequestMapping(value = SpConstantInter.SYS_USER_QUERY_ROLE, method = RequestMethod.POST)
    public Result queryRoleById(String id) {
        return iSysUserService.queryRoleById(id);
    }

    //当前账号下的角色（不包括，已经分配给选中的当前账号的角色）

    /**
     * @api {post} /sys/user/unrole 查询角色
     * @apiName unrole
     * @apiGroup User
     * @apiHeader {application/x-www-form-urlencoded} ContentType 请求参数为from方式提交
     * @apiParam {String} loginId 用户id
     * @apiParam {String} seleId 选中用户id
     * @apiSuccess {Object} data 接口返回的数据对象.
     * @apiSuccess (data) {String} roleCode 角色编码.
     * @apiSuccess (data) {String} id 角色id.
     * @apiSuccess (data) {String} roleName 角色名.
     * @apiSuccess {Integer} code 操作编码.
     * @apiSuccess {String} msg 描述(根据code值去码表中查询对应的描述信息).
     * @apiSuccessExample 成功响应:
     * HTTP/1.1 200 OK
     * {
     * "data": [
     * {
     * "roleCode": "admin",
     * "roleName": "超级管理员",
     * "id": "c0afe31b9702e32fec50f583224d8f1f"
     * }
     * ],
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
    @RequestMapping(value = SpConstantInter.SYS_USER_QUERY_UNROLE, method = RequestMethod.POST)
    public Result queryUnRoleById(String loginId, String seleId) {
        return iSysUserService.queryUnRoleById(loginId, seleId);
    }
}
