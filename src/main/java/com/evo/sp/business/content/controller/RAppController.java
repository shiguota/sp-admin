package com.evo.sp.business.content.controller;


import com.evo.sp.business.content.entity.RApp;
import com.evo.sp.business.content.entity.vo.RAppVo;
import com.evo.sp.business.content.service.IRAppService;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.parameter.PageRequestParameter;
import com.evo.sp.common.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.evo.sp.common.BaseController;

import java.util.List;

/**
 * <p>
 * 应用表 前端控制器
 *
 * @author sgt
 * @since 2019-05-22
 * @apiDefine APP 应用接口
 */
@RestController
@RequestMapping(SpConstantInter.RESOURCE_APP)
public class RAppController extends BaseController {

    private static final String  TOP_NODE_NAME= "全部应用";

    @Autowired
    private IRAppService irAppService;


    /**
     * @api {post} /resource/app/save 新增
     * @apiName save
     * @apiGroup APP
     * @apiHeader {applications/json} ContentType 请求参数为json格式
     * @apiParam {String} name  名称 .
     * @apiParam {String} version   版本.
     * @apiParam {String} code  编码 .
     * @apiParam {String} title   标题.
     * @apiParam {String} isPublish  是否推荐.
     * @apiParam {String} state  状态.
     * @apiParam {String} [remark]  描述.
     * @apiParam {String} type   类型.
     * @apiParam {String} [columnId]   栏目id.
     * @apiSuccess {Object} data 接口返回的数据对象.
     * @apiSuccess {Integer} code 操作编码.
     * @apiSuccess {String} msg 描述(根据code值去码表中查询对应的描述信息).
     * @apiSuccessExample 成功响应:
     * HTTP/1.1 200 OK
     * {
     *     "date": true,
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
    @PostMapping(value = SpConstantInter.RESOURCE_APP_SAVE)
    public Result saveApp(@RequestBody RAppVo rApp) {
        return irAppService.saveApp(rApp);
    }

    /**
     * @api {post} /resource/app/del  删除
     * @apiName del
     * @apiGroup APP
     * @apiHeader {applications/json} ContentType 请求参数为json格式
     * @apiHeader {application/x-www-form-urlencoded} ContentType 请求参数为from方式提交
     * @apiParam {JSONOBJECT} data JSON格式数据
     * @apiParam (data) {String} name
     * @apiParam {String} account  .
     * @apiParam {String} password   .
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
    @PostMapping(value = SpConstantInter.RESOURCE_APP_DEL)
    public Result delApp(@RequestBody List<String> ids) {
        return dels(ids, irAppService);
    }

    /**
     * @api {post} /resource/app/modify 修改
     * @apiName modify
     * @apiGroup APP
     * @apiHeader {applications/json} ContentType 请求参数为json格式
     * @apiParam {String} id  id.
     * @apiParam {String} name  名称 .
     * @apiParam {String} version   版本.
     * @apiParam {String} code  编码 .
     * @apiParam {String} title   标题.
     * @apiParam {String} isPublish  是否推荐.
     * @apiParam {String} state  状态.
     * @apiParam {String} remark  描述.
     * @apiParam {String} type   类型.
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
    @PostMapping(value = SpConstantInter.RESOURCE_APP_MODIFY)
    public Result modifyApp(@RequestBody RApp rApp) {
        return modify(rApp, irAppService);
    }
    //暂时弃用
    /**
     * @api {post} /resource/app/page  分页列表（暂时弃用）
     * @apiName page
     * @apiGroup APP
     * @apiHeader {applications/json} ContentType 请求参数为json格式
     * @apiHeader {application/x-www-form-urlencoded} ContentType 请求参数为from方式提交
     * @apiParam {JSONOBJECT} data JSON格式数据
     * @apiParam (data) {String} name
     * @apiParam {String} account  .
     * @apiParam {String} password   .
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
    @PostMapping(value = SpConstantInter.RESOURCE_APP_PAGE)
    public Result queryListPage(@RequestBody PageRequestParameter<RAppVo> parameter) {
        return new Result(irAppService.queryListPage(parameter));
    }

    /**
     * @api {post} /resource/app/id 查询详情
     * @apiName id
     * @apiGroup APP
     * @apiHeader {application/x-www-form-urlencoded} ContentType 请求参数为from方式提交
     * @apiParam {String} id  应用id.
     * @apiSuccess {Object} data 接口返回的数据对象.
     * @apiSuccess (data){Integer} state 状态.
     * @apiSuccess (data){String} id   id.
     * @apiSuccess (data){String} name  名称.
     * @apiSuccess (data){String} code   编码.
     * @apiSuccess (data){String} version  版本 .
     * @apiSuccess (data){Integer} sort   排序.
     * @apiSuccess (data){Integer} isPublish   是否推荐.
     * @apiSuccess (data){String} remark   简介.
     * @apiSuccess (data){Integer} type   类型.
     * @apiSuccess {Integer} code 操作编码.
     * @apiSuccess {String} msg 描述(根据code值去码表中查询对应的描述信息).
     * @apiSuccessExample 成功响应:
     * HTTP/1.1 200 OK
     * {
     *     "date": {
     *         "state": 1,
     *         "id": "eb84a7ed2e04b92476032a176a625be6",
     *         "name": "应用名称1",
     *         "version": "3.0.0",
     *         "code": "app_code",
     *         "title": "应用title",
     *         "sort": null,
     *         "isPublish": 1,
     *         "remark": "应用描述",
     *         "type": 1
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
    @PostMapping(value = SpConstantInter.RESOURCE_APP_ID)
    public Result saveApp(String id) {
        return queryById(id, irAppService);
    }

    /**
     * @api {post} /resource/app/tree 应用树
     * @apiName tree
     * @apiGroup APP
     * @apiSuccess {Object} data 接口返回的数据对象.
     * @apiSuccess (data){String} treeId  树节点id.
     * @apiSuccess (data){String} id 数据节点id.
     * @apiSuccess (data){String} text 名称.
     * @apiSuccess (data){String} checked  .
     * @apiSuccess (data){String} children  子节点.
     * @apiSuccess {Integer} code 操作编码.
     * @apiSuccess {String} msg 描述(根据code值去码表中查询对应的描述信息).
     * @apiSuccessExample 成功响应:
     * HTTP/1.1 200 OK
     * {
     *     "date": {
     *         "treeId": "0-0",
     *         "id": "-1",
     *         "text": "全部应用",
     *         "checked": true,
     *         "children": [
     *             {
     *                 "treeId": "0-0-1",
     *                 "id": "eb84a7ed2e04b92476032a176a625be6",
     *                 "text": "应用名称1"
     *             },
     *             {
     *                 "treeId": "0-0-2",
     *                 "id": "eb84a7ed2e04b92476032a176a62rhfd7",
     *                 "text": "1"
     *             }
     *         ],
     *         "parentId": "",
     *         "path": "#",
     *         "icon": null,
     *         "level": 0,
     *         "code": null,
     *         "state": 1,
     *         "type": null,
     *         "parent": false
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
    @PostMapping(value = SpConstantInter.RESOURCE_APP_TREE)
    public Result queryAppTree() {
        return queryTreeData(irAppService.queryAppTree(),TOP_NODE_NAME);
    }


}
