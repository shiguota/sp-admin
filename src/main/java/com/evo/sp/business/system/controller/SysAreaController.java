package com.evo.sp.business.system.controller;


import com.evo.sp.business.system.entity.SysArea;
import com.evo.sp.business.system.entity.vo.SysAreaVo;
import com.evo.sp.business.system.service.ISysAreaService;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.parameter.PageRequestParameter;
import com.evo.sp.common.result.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.evo.sp.common.BaseController;

import java.util.List;

import static com.evo.sp.common.SpConstantInter.SYS_AREA_ID;

/**
 * <p>
 * 区域表 前端控制器
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 * @apiDefine Area 区域接口
 */
@RestController
@RequestMapping(SpConstantInter.SYS_AREA)
@Api(tags = "区域")
public class SysAreaController extends BaseController {

    //设置顶级节点名称
    public final String TOP_NODE_NAME = "所有区域";

    @Autowired
    private ISysAreaService iSysAreaService;

    /**
     * @api {post} /sys/area/save 新增
     * @apiName save
     * @apiGroup Area
     * @apiHeader {applications/json} ContentType 请求参数为json格式
     * @apiParam {String} areaName  区域名 .
     * @apiParam {String} [shortName]   简称.
     * @apiParam {String} [lon]   经度.
     * @apiParam {String} [lat]   纬度.
     * @apiParam {String} level   级别.
     * @apiParam {String} sort   排序.
     * @apiParam {String} pid   父id.
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
    @RequestMapping(value = SpConstantInter.SYS_AREA_SAVE, method = RequestMethod.POST)
    public Result saveArea(@RequestBody SysArea sysArea) {
        return save(sysArea, iSysAreaService);
    }

    /**
     * @api {post} /sys/area/del 删除
     * @apiName del
     * @apiGroup Area
     * @apiHeader {applications/json} ContentType 请求参数为json格式
     * @apiParam {ARRAY} ids  区域id .
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
    @RequestMapping(value = SpConstantInter.SYS_AREA_DEL, method = RequestMethod.POST)
    public Result delArea(List<String> ids) {
        return dels(ids, iSysAreaService);
    }


    /**
     * @api {post} /sys/area/modify 修改
     * @apiName modify
     * @apiGroup Area
     * @apiHeader {applications/json} ContentType 请求参数为json格式
     * @apiParam {String} areaName  区域名 .
     * @apiParam {String} shortName   简称.
     * @apiParam {String} lon   经度.
     * @apiParam {String} lat   纬度.
     * @apiParam {String} level   级别.
     * @apiParam {String} sort   排序.
     * @apiParam {String} pid   父id.
     * @apiParam {String} id  id.
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
    @RequestMapping(value = SpConstantInter.SYS_AREA_NODIFY, method = RequestMethod.POST)
    public Result modifyArea(@RequestBody SysArea sysArea) {
        return modify(sysArea, iSysAreaService);
    }


    /**
     * @api {post} /sys/area/tree  区域Tree查询
     * @apiName tree
     * @apiGroup Area
     * @apiSuccess {JSONOBJECT} data 接口返回的数据对象.
     * @apiSuccess (data){String} id 区域id.
     * @apiSuccess (data){String} text 区域名称.
     * @apiSuccess (data){Integer} state   状态（1 可用 0禁用,注：默认为1）.
     * @apiSuccess (data){JSONOBJECT} children 子节点集合.
     * @apiSuccess (data){integer} level 级别.
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
    @RequestMapping(value = SpConstantInter.SYS_AREA_TREE, method = RequestMethod.POST)
    public Result queryAreaTree() {
        return queryTreeData(iSysAreaService.queryAreaTree(), TOP_NODE_NAME);
    }


    /**
     * @api {post} /sys/area/page  查询区域列表
     * @apiName page
     * @apiGroup Area
     * @apiParam {Integer} page 当前页.
     * @apiParam {Integer} size 每页行数.
     * @apiParam {OBJECTJSON} parameter JSON数据对象
     * @apiParam (parameter){String} [areaName]  区域名称.
     * @apiParam (parameter){String} pid  父id.
     * @apiParam (parameter){String} [sort]  排序（desc/asc）.
     * @apiParam (parameter){String} [cSortType]  创建时间排序（desc/asc）.
     * @apiParam (parameter){String} [uSortType]  修改时间排序（desc/asc）.
     * @apiSuccess {JSONOBJECT} data JSON格式数据.
     * @apiSuccess (data){Array} records JSON格式数据（列表数据）.
     * @apiSuccess (records){String} areaName  区域名 .
     * @apiSuccess (records){String} shortName   简称.
     * @apiSuccess (records){String} lon   经度.
     * @apiSuccess (records){String} lat   纬度.
     * @apiSuccess (records){String} level   级别.
     * @apiSuccess (records){String} sort   排序.
     * @apiSuccess (records){String} id   id.
     * @apiSuccess (records){String} [sort]  排序 值为"asc".
     * @apiSuccess (records)(data){Array} records JSON格式数据（列表数据）.
     * @apiSuccess {Integer} code 操作编码.
     * @apiSuccess {String} msg 描述(根据code值去码表中查询对应的描述信息).
     * @apiSuccessExample 成功响应:
     * HTTP/1.1 200 OK
     * {
     *     "date": {
     *         "records": [
     *             {
     *                 "createTime": "2019-05-15T10:19:08",
     *                 "updateTime": "2019-05-15T10:58:05",
     *                 "state": null,
     *                 "id": "42ab78b0b4d7e59fa4efe025b306b64d",
     *                 "areaName": "中华人民共和国",
     *                 "shortName": "中国",
     *                 "lon": 653465.24325423,
     *                 "lat": 4321431.5432542,
     *                 "level": 1,
     *                 "sort": 1,
     *                 "pid": "-1"
     *             }
     *         ],
     *         "total": 1,
     *         "size": 5,
     *         "current": 1,
     *         "searchCount": true,
     *         "pages": 1
     *     },
     *     "code": 1007,
     *     "msg": "操作成功"
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
    @RequestMapping(value = SpConstantInter.SYS_AREA_PAGE, method = RequestMethod.POST)
    public Result queryListPage(@RequestBody PageRequestParameter<SysAreaVo> sysAreaPageRequestParameter) {
        return iSysAreaService.queryListPage(sysAreaPageRequestParameter);
    }

    /**
     * @api {post} /sys/area/pid  查询区域子节点
     * @apiName pid
     * @apiGroup Area
     * @apiHeader {application/x-www-form-urlencoded} ContentType 请求参数为from方式提交
     * @apiParam {String} pid  父id.
     * @apiParam {String} treeId   节点treeId.
     * @apiSuccess {Array} data 接口返回的数据对象.
     * @apiSuccess (data){String} id 区域id.
     * @apiSuccess (data){String} text 区域名称.
     * @apiSuccess (data){String} parentId 父id.
     * @apiSuccess (data){Integer} level 级别.
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
    @PostMapping(value = SpConstantInter.SYS_AREA_PID)
    public Result queryAreaByPid(String pid, String treeId) {
        return new Result(iSysAreaService.queryAreaByPid(pid, treeId));
    }

    /**
     * @api {post} /sys/area/id   id查询区域
     * @apiName id
     * @apiGroup Area
     * @apiHeader {application/x-www-form-urlencoded} ContentType 请求参数为from方式提交
     * @apiParam {String} id   区域id .
     * @apiSuccess (data) {String} areaName  区域名 .
     * @apiSuccess (data){String} shortName   简称.
     * @apiSuccess (data) {String} lon   经度.
     * @apiSuccess (data){String} lat   纬度.
     * @apiSuccess (data){String} level   级别.
     * @apiSuccess (data){String} sort   排序.
     * @apiSuccess (data){String} pid   父id.
     * @apiSuccess {Object} data 接口返回的数据对象.
     * @apiSuccess {Integer} code 操作编码.
     * @apiSuccess {String} msg 描述(根据code值去码表中查询对应的描述信息).
     * @apiSuccessExample 成功响应:
     * HTTP/1.1 200 OK
     * {
     *     "date": [
     *         {
     *             "treeId": "0-0-1-1",
     *             "id": "e15e13de61e3a02a519d6712e3ca25bb",
     *             "text": "辽宁",
     *             "checked": false,
     *             "children": [],
     *             "parentId": "42ab78b0b4d7e59fa4efe025b306b64d",
     *             "level": 2,
     *             "parent": false
     *         }
     *     ],
     *     "code": 1007,
     *     "msg": "操作成功"
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
    @PostMapping(value = SYS_AREA_ID)
    public Result queryAreaById(String id) {
        return queryById(id, iSysAreaService);
    }

}
