package com.evo.sp.business.content.controller;


import com.evo.sp.business.content.entity.CColumn;
import com.evo.sp.business.content.entity.vo.CColumnVo;
import com.evo.sp.business.content.service.ICColumnService;
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
 * 栏目表 前端控制器
 * </p>
 *
 * @author sgt
 * @since 2019-05-22
 * @apiDefine COLUMN 栏目接口
 */
@RestController
@RequestMapping(SpConstantInter.CONTENT_COLUMN)
public class CColumnController extends BaseController {

    @Autowired
    private ICColumnService icColumnService;

    /**
     * @api {post} /content/column/save 新增
     * @apiName save
     * @apiGroup COLUMN
     * @apiHeader {applications/json} ContentType 请求参数为json格式
     * @apiParam {String} name   名称.
     * @apiParam {String} title   标题.
     * @apiParam {String} code   编码.
     * @apiParam {String} type   类型.
     * @apiParam {String} sort   排序.
     * @apiParam {String} [appId]   应用id.
     * @apiParam {String} [state]   状态 1可用   0禁用 默认值：1.
     * @apiParam {String} onlineTime   生效时间.
     * @apiParam {String} offlineTime   失效时间.
     * @apiParam {String} pid   父id.
     * @apiParam {String} isRecommend    是否推荐  1是  0否.
     * @apiParam {String} isPublish   发布  1是  0否.
     * @apiParam {String} isHot   热门   1是   0否.
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
    @PostMapping(SpConstantInter.CONTENT_COLUMN_SAVE)
    public Result saveColumn(@RequestBody CColumnVo cColumn) {
        return icColumnService.saveColumn(cColumn);
    }

    /**
     * @api {post} /content/column/del 删除
     * @apiName del
     * @apiGroup COLUMN
     * @apiHeader {applications/json} ContentType 请求参数为json格式
     * @apiParam {Array} ids   id数组.
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
    @PostMapping(SpConstantInter.CONTENT_COLUMN_DEL)
    public Result delColumn(@RequestBody List<String> ids) {
        return dels(ids, icColumnService);
    }


    /**
     * @api {post} /content/column/modify 修改
     * @apiName login
     * @apiGroup COLUMN
     * @apiHeader {applications/json} ContentType 请求参数为json格式
     * @apiParam {String} id   id.
     * @apiParam {String} name   名称.
     * @apiParam {String} title   标题.
     * @apiParam {String} code   编码.
     * @apiParam {String} type   类型.
     * @apiParam {String} sort   排序.
     * @apiParam {String} state   状态 1可用   0禁用 默认值：1.
     * @apiParam {String} onlineTime   生效时间.
     * @apiParam {String} offlineTime   失效时间.
     * @apiParam {String} pid   父id.
     * @apiParam {String} isRecommend   是否推荐  1是  0否.
     * @apiParam {String} isPublish   是否发布  1是  0否.
     * @apiParam {String} isHot   是否热门   1是   0否.
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
    @PostMapping(SpConstantInter.CONTENT_COLUMN_MODIFY)
    public Result modifyColumn(@RequestBody CColumn cColumn) {
        return modify(cColumn, icColumnService);
    }

    //暂时弃用
    /**
     * @api {post} /content/column/page  分页列表（暂时弃用）
     * @apiName page
     * @apiGroup COLUMN
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
    @PostMapping(value = SpConstantInter.CONTENT_COLUMN_PAGE)
    public Result queryListPage(@RequestBody PageRequestParameter<CColumnVo> parameter) {
        return new Result(icColumnService.queryListPage(parameter));
    }

    /**
     * @api {post} /content/column/id  查询详情
     * @apiName id
     * @apiGroup COLUMN
     * @apiHeader {application/x-www-form-urlencoded} ContentType 请求参数为from方式提交
     * @apiParam {String} id   id.
     * @apiSuccess {Object} data 接口返回的数据对象.
     * @apiSuccess (data){Integer} state 状态.
     * @apiSuccess (data){Integer} id id.
     * @apiSuccess (data){Integer} name 名称.
     * @apiSuccess (data){Integer} title 标题.
     * @apiSuccess (data){Integer} code 编码.
     * @apiSuccess (data){Integer} type 类型.
     * @apiSuccess (data){Integer} sort 排序.
     * @apiSuccess (data){Integer} onlineTime 生效时间.
     * @apiSuccess (data){Integer} offlineTime 失效时间.
     * @apiSuccess (data){Integer} pid 父id.
     * @apiSuccess (data){Integer} isRecommend 是否推荐.
     * @apiSuccess (data){Integer} isPublish 是否发布.
     * @apiSuccess (data){Integer} isHot 是否热门.
     * @apiSuccess {Integer} code 操作编码.
     * @apiSuccess {String} msg 描述(根据code值去码表中查询对应的描述信息).
     * @apiSuccessExample 成功响应:
     * HTTP/1.1 200 OK
     *{
     *     "date": {
     *         "state": 1,
     *         "id": "15a934bc59baf451d21891ebfc9e584f",
     *         "name": "栏目名称",
     *         "title": "栏目标题",
     *         "code": "column_code",
     *         "type": 1,
     *         "sort": 0,
     *         "onlineTime": "2019-02-05 00:00:00",
     *         "offlineTime": "2019-05-08 00:00:00",
     *         "pid": "-1",
     *         "isRecommend": 1,
     *         "isPublish": 1,
     *         "isHot": 1
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
    @PostMapping(value = SpConstantInter.CONTENT_COLUMN_ID)
    public Result queryById(String id) {
        return queryById(id, icColumnService);
    }


    /**
     * @api {post} /content/column/tree  栏目树
     * @apiName ids
     * @apiGroup COLUMN
     * @apiHeader {application/x-www-form-urlencoded} ContentType 请求参数为from方式提交
     * @apiParam {String} Id  id.
     * @apiParam {String} treeId  树id .
     * @apiParam {Integer} type  类型 .
     * @apiSuccess {JSONOBJECT} data 接口返回的数据对象.
     * @apiSuccess (data){String} treeId 树节点id.
     * @apiSuccess (data){String} id 栏目id.
     * @apiSuccess (data){String} text 栏目名.
     * @apiSuccess (data){String} parentId 父id.
     * @apiSuccess (data){String} type 类型.
     * @apiSuccess {Integer} code 操作编码.
     * @apiSuccess {String} msg 描述(根据code值去码表中查询对应的描述信息).
     * @apiSuccessExample 成功响应:
     * HTTP/1.1 200 OK
     * {
     *     "date": [
     *         {
     *             "treeId": "0-0-1",
     *             "id": "15a934bc59baf451d21891ebfc9e584f",
     *             "text": "栏目名称",
     *             "parentId": "-1",
     *             "type": 1,
     *         },
     *         {
     *             "treeId": "0-0-2",
     *             "id": "b791c70341fed8f4c76d6e015ab44a1f",
     *             "text": "栏目名称222222",
     *             "parentId": "-1",
     *             "type": 1,
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
    @PostMapping(value = SpConstantInter.CONTENT_COLUMN_TREE)
    public Result queryAppListTree(String Id,String treeId,Integer type) {
        return new Result(icColumnService.queryListTree(Id,treeId,type));
    }

}
