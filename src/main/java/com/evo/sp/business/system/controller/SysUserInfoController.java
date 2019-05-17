package com.evo.sp.business.system.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.evo.sp.business.system.entity.SysUserInfo;
import com.evo.sp.business.system.service.ISysUserInfoService;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.parameter.PageRequestParameter;
import com.evo.sp.common.result.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.evo.sp.common.BaseController;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author sgt
 * @apiDefine UserInfo 用户信息接口
 * @since 2019-04-10
 */
@RestController
@RequestMapping(SpConstantInter.SYS_USER_INFO)
@Api(tags = "用户信息")
public class SysUserInfoController extends BaseController {

    @Autowired
    private ISysUserInfoService iSysUserInfoService;

    /**
     * @api {post} /sys/userInfo/id
     * @apiName /id
     * @apiGroup UserInfo
     * @apiHeader {application/x-www-form-urlencoded} ContentType 请求参数为from方式提交
     * @apiParam {String} id   id.
     * @apiSuccess {Object} data 接口返回的数据对象.
     * @apiSuccess  (data){Date} createTime 创建时间.
     * @apiSuccess  (data){Date} updateTime 修改时间.
     * @apiSuccess  (data){String} id id.
     * @apiSuccess  (data){Date} birthday 生日.
     * @apiSuccess  (data){String} phone 电话.
     * @apiSuccess  (data){String} caid 省份证号.
     * @apiSuccess  (data){String} nickname 昵称.
     * @apiSuccess  (data){String} wxAccount 微信账号.
     * @apiSuccess  (data){String} qqAccount QQ账号.
     * @apiSuccess  (data){Integer} height 身高.
     * @apiSuccess  (data){String} wxOpenid 微信Openid.
     * @apiSuccess  (data){String} weight 体重.
     * @apiSuccess  (data){String} national 民族.
     * @apiSuccess  (data){String} wbAccount 微博账号.
     * @apiSuccess  (data){String} sex 性别.
     * @apiSuccess  (data){String} sig 签名.
     * @apiSuccess {Integer} code 操作编码.
     * @apiSuccess {String} msg 描述(根据code值去码表中查询对应的描述信息).
     * @apiSuccessExample 成功响应:
     * HTTP/1.1 200 OK
     * {
     *     "date": {
     *         "createTime": "2019-04-19 06:01:10",
     *         "updateTime": "2019-04-19 06:01:10",
     *         "state": 1,
     *         "id": "581ab821306c313f57e45998cc13b394",
     *         "birthday": "2019-04-19",
     *         "phone": "1234567890",
     *         "caid": "5436543764587",
     *         "nickname": "昵称",
     *         "wxAccount": "wx75478054489",
     *         "qqAccount": "75478054489",
     *         "height": 170,
     *         "wxOpenid": "581ab8313f57e45998cc1",
     *         "weight": 56,
     *         "national": "",
     *         "wbAccount": "",
     *         "email": "string",
     *         "sex": 0,
     *         "sig": "string"
     *     },
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
    @PostMapping(value = SpConstantInter.SYS_USER_INFO_ID)
    public Result queryUserById(String id) {
        return queryById(id,iSysUserInfoService);
    }

}
