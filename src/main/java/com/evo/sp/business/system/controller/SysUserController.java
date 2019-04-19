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
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.evo.sp.common.BaseController;


/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
@RestController
@RequestMapping(SpConstantInter.SYS_USER)
@Api(tags = "用户")
public class SysUserController extends BaseController {
    private final String USER_PERMISSIONS = "permission";
    @Autowired
    private ISysUserService iSysUserService;


    /**
     * @api {post} /sys/user/login 登录
     * @apiName login
     * @apiGroup User
     * @apiParam {String} account 用户登录账号.
     * @apiParam {String} password  账号密码.
     * @apiSuccess {Object} data 接口返回的数据对象.
     * @apiSuccess {Integer} code 操作编码.
     * @apiSuccess {String} msg 操作编码对应的注释.
     * @apiSuccessExample 成功响应:
     * HTTP/1.1 200 OK
     * {
     * "date": true,
     * "code": 2002,
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
    @PostMapping(value = SpConstantInter.SYS_USER_LOGIN)
    public Result userLogin(String account, String password) {
        Result result = null;
        Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(account, password);
            // token.setRememberMe(true);
            currentUser.login(token);
            currentUser.isPermitted(USER_PERMISSIONS);
            result = new Result(true, ResultEnum.LOGIN_SUCCESS.getValue(), ResultEnum.LOGIN_SUCCESS.getName());
        } else {
            result = new Result(true, ResultEnum.LOGIN_SUCCESS.getValue(), ResultEnum.LOGIN_SUCCESS.getName());
        }
        return result;
    }


    /**
     * @api {post} /sys/user/loginout 注销
     * @apiName loginout
     * @apiGroup User
     * @apiSuccess {Object} data 接口返回的数据对象.
     * @apiSuccess {Integer} code 操作编码.
     * @apiSuccess {String} smg 描述(根据code值去码表中查询对应的描述信息).
     * @apiSuccessExample 成功响应:
     * HTTP/1.1 200 OK
     * {
     * "date": true,
     * "code": 2007,
     * "msg": "注销用户成功"
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
    @RequestMapping(value = SpConstantInter.SYS_USER_LOGIN_OUT, method = RequestMethod.POST)
    public Result userLoginOut() {
        Result result = null;
        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser.isAuthenticated()) {
            currentUser.logout();
        }
        result = new Result(true, ResultEnum.LOGIN_OUT_SUCCESS.getValue(), ResultEnum.LOGIN_OUT_SUCCESS.getName());
        return result;
    }


    /**
     * @api {post} /sys/user/save 新增
     * @apiName save
     * @apiGroup User
     * @apiParam {JSONOBJECT} info JSON格式数据
     * @apiParam (info)  {Date}    [birthday] birthday 生日
     * @apiParam (info)  {String}  [caid]  caid 身份证号
     * @apiParam (info)  {Date}    [createTime] createTime 创建时间
     * @apiParam (info)  {String}  [email] email 邮箱
     * @apiParam (info)  {Integer} [height] height 身高(cm)
     * @apiParam (info)  {String}  [nickname]nickname 昵称
     * @apiParam (info)  {String}  [phone]  phone 手机
     * @apiParam (info)  {String}  [qqAccount]qqAccount QQ账号
     * @apiParam (info)  {Integer} [sex] sex 性别 0 保密  1男  2女
     * @apiParam (info)  {String}  [sig] sig 签名
     * @apiParam (info)  {Integer} [state] state 状态  1可用（默认） 2 废弃
     * @apiParam (info)  {String}  [wbAccount] wbAccount 微博账号
     * @apiParam (info)  {Integer} [weight]  weight 体重（公斤）
     * @apiParam (info)  {String}  [wxAccount] wxAccount 微信账号
     * @apiParam (info)  {String}  [wxOpenid]   wxOpenid 微信账号OPENID
     * @apiParam (info)  {String}  [national] national 籍贯
     * @apiParam {String} account 新增用户 .
     * @apiParam {String} password  新增用户 .
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
    @RequestMapping(value = SpConstantInter.SYS_USER_SAVE, method = RequestMethod.POST)
    @Transactional
    public Result saveUser(@RequestBody SysUserVo sysUserVo) {
        return iSysUserService.saveUser(sysUserVo);
    }



    /**
     * @api {post} /sys/user/del 删除（根据id）
     * @apiName del
     * @apiGroup User
     * @apiParam  {String} id 用户id
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
    @PostMapping(value = SpConstantInter.SYS_USER_DEL)
    public Result delUser(String id) {
        return del(id, iSysUserService);
    }

    /**
     * 修改角色（根据id）
     */
    @PostMapping(value = SpConstantInter.SYS_USER_MODIFY)
    public Result modifyUser(@RequestBody SysUser sysUser) {
        SpAssert.isNull(sysUser.getId());
        return modify(sysUser, iSysUserService);
    }

    /**
     * 根据id查询一条记录
     */
    @RequestMapping(value = SpConstantInter.SYS_USER_QUERY_ONE, method = RequestMethod.POST)
    public Result queryOne(String id) {
        return iSysUserService.queryUserById(id);
    }

    /**
     * 获取权限列表（分页查询）
     */
    @RequestMapping(value = SpConstantInter.SYS_USER_PAGE, method = RequestMethod.POST)
    public Result queryListPage(@RequestBody PageRequestParameter<SysUserVo> pageRequestParameter) {
        return iSysUserService.queryUserByOrg(pageRequestParameter.pageInstance(), pageRequestParameter.parameterInstance());
    }

    /**
     * 根据用户id获取账号已存在的角色
     */
    @RequestMapping(value = SpConstantInter.SYS_USER_QUERY_ROLE, method = RequestMethod.POST)
    public Result queryRoleById(String id) {
        return iSysUserService.queryRoleById(id);
    }

    /**
     * 通过当前登录账号的信息，获取当前账号下的角色（不包括，已经分配给选中的当前账号的角色）
     */
    @RequestMapping(value = SpConstantInter.SYS_USER_QUERY_UNROLE, method = RequestMethod.POST)
    public Result queryUnRoleById(String loginId, String seleId) {
        return iSysUserService.queryUnRoleById(loginId, seleId);
    }


}
