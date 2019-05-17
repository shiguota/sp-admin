package com.evo.sp.business.system.controller;


import com.evo.sp.business.system.entity.SysDictionary;
import com.evo.sp.business.system.entity.vo.SysDictionaryVo;
import com.evo.sp.business.system.service.ISysDictionaryService;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.parameter.PageRequestParameter;
import com.evo.sp.common.result.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.evo.sp.common.BaseController;

import java.util.List;

/**
 * <p>
 * 字典表 前端控制器
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 * @apiDefine Dictionary 字典接口
 */

@RestController
@RequestMapping(SpConstantInter.SYS_DICTIONNARY)
@Api(tags = "字典表")
@SuppressWarnings("all")
public class SysDictionaryController extends BaseController {

    @Autowired
    private ISysDictionaryService iSysDictionaryService;

    /**
     * @api {post} /sys/dictionary/save 新增
     * @apiName save
     * @apiGroup Dictionary
     * @apiHeader {applications/json} ContentType 请求参数为json格式
     * @apiParam {String} dicName   名称.
     * @apiParam {String} dicCode   编码.
     * @apiParam {Integer} state   状态（1 可用 0禁用,注：默认为1）.
     * @apiParam {Integer} [dicSort]   排序.
     * @apiParam {String} pid   父id.
     * @apiParam {Integer} level   级别.
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
    @RequestMapping(value = SpConstantInter.SYS_DICTIONNARY_SAVE, method = RequestMethod.POST)
    public Result saveDictionary(@RequestBody SysDictionary sysDictionary) {
        return new Result(iSysDictionaryService.save(sysDictionary));
    }


    /**
     * @api {post} /sys/dictionary/del  删除
     * @apiName del
     * @apiGroup Dictionary
     * @apiHeader {applications/json} ContentType 请求参数为json格式
     * @apiParam {Array} id  字典id.
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
    @RequestMapping(value = SpConstantInter.SYS_DICTIONNARY_DEL, method = RequestMethod.POST)
    public Result delDictionary(@RequestBody List<String> id) {
        return dels(id, iSysDictionaryService);
    }


    /**
     * @api {post} /sys/dictionary/modify  编辑
     * @apiName modify
     * @apiGroup Dictionary
     * @apiHeader {applications/json} ContentType 请求参数为json格式
     * @apiParam {String} dicName   名称.
     * @apiParam {String} dicCode   编码.
     * @apiParam {Integer} dicSort   排序.
     * @apiParam {Integer} state   状态（1 可用 0禁用,注：默认为1）.
     * @apiParam {String} id  字典id.
     * @apiParam {Integer} level   级别.
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
    @RequestMapping(value = SpConstantInter.SYS_DICTIONNARY_MODIFY, method = RequestMethod.POST)
    public Result modifyDictionary(@RequestBody SysDictionary sysDictionary) {
        return modify(sysDictionary, iSysDictionaryService);
    }

    /**
     * @api {post} /sys/dictionary/page  字典列表
     * @apiName page
     * @apiGroup Dictionary
     * @apiHeader {applications/json} ContentType 请求参数为json格式
     * @apiParam {Integer} page 当前页。
     * @apiParam {Integer} size 每页行数
     * @apiParam {OBJECTJSON} parameter JSON数据对象
     * @apiParam (parameter){String} [dicName]  字典名称.
     * @apiParam (parameter){String} pid  父id.
     * @apiParam (parameter){String} [dicSort]  排序（desc/asc）.
     * @apiParam (parameter){String} [cSortType]  创建时间排序（desc/asc）.
     * @apiParam (parameter){String} [uSortType]  修改时间排序（desc/asc）.
     * @apiSuccess {JSONOBJECT} data JSON格式数据.
     * @apiSuccess (data){Array} records JSON格式数据（列表数据）.
     * @apiSuccess (records){Integer} total 数据总数.
     * @apiSuccess (records){Integer} size 每页行数.
     * @apiSuccess (records){Integer} current 当前页.
     * @apiSuccess (records){Integer} pages 总页数.
     * @apiSuccess (records){String} dicCode 字典编码.
     * @apiSuccess (records){Integer} state   状态（1 可用 0禁用,注：默认为1）.
     * @apiSuccess (records){String} dicName 字典名称.
     * @apiSuccess (records){integer} sort 排序.
     * @apiSuccess (records){Date} createTime 创建时间.
     * @apiSuccess (records){Date} updateTime 修改时间.
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
    @RequestMapping(value = SpConstantInter.SYS_DICTIONNARY_QUERY_PAGE, method = RequestMethod.POST)
    public Result queryByName(@RequestBody PageRequestParameter<SysDictionaryVo> pageRequestParameter) {
        return new Result(iSysDictionaryService.queryByNamePid(pageRequestParameter));
    }


    /**
     * @api {post} /sys/dictionary/code  code编码查询字典
     * @apiName code
     * @apiGroup Dictionary
     * @apiHeader {application/x-www-form-urlencoded} ContentType 请求参数为from方式提交
     * @apiParam {String} dicCode  字典编码 .
     * @apiSuccess {Object} data 接口返回的数据对象.
     * @apiSuccess (data){String} id 字典id.
     * @apiSuccess (data){String} dicName 名称.
     * @apiSuccess (data){String} dicCode 字典编码.
     * @apiSuccess (data){Integer} state   状态（1 可用 0禁用,注：默认为1）.
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
    @PostMapping(value = SpConstantInter.SYS_DICTIONNARY_QUERY_BY_CODE)
    public Result queryByDisCode(String disCode) {
        return iSysDictionaryService.queryByCode(disCode);
    }


    /**
     * @api {post} /sys/dictionary/level 字典Tree查询
     * @apiName level
     * @apiGroup Dictionary
     * @apiSuccess {JSONOBJECT} data 接口返回的数据对象.
     * @apiSuccess (data){String} treeId 树id.
     * @apiSuccess (data){String} id 字典id.
     * @apiSuccess (data){String} text 字典名称.
     * @apiSuccess (data){Integer} state   状态（1 可用 0禁用,注：默认为1）.
     * @apiSuccess (data){JSONOBJECT} children 子节点集合.
     * @apiSuccess (data){integer} level 级别.
     * @apiSuccess (data){String} code 字典编码.
     * @apiSuccess {Integer} code 操作编码.
     * @apiSuccess {String} msg 描述(根据code值去码表中查询对应的描述信息).
     * @apiSuccessExample 成功响应:
     * HTTP/1.1 200 OK
     * {
     * "data": {
     * "treeId": "0-0",
     * "id": "-1",
     * "text": "字典分类",
     * "children": [
     * {
     * "treeId": "0-0-1",
     * "id": "57179210133575b328b1907d996ebcf6",
     * "text": "锁定状态",
     * "children": [],
     * "parent": false
     * },
     * {
     * "treeId": "0-0-2",
     * "id": "e170fa1ebeff1f849db1511a027ca3cd",
     * "text": "合作伙伴分类",
     * "children": [],
     * "parent": false
     * }
     * ],
     * "path": "#",
     * "parent": false
     * },
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
    @PostMapping(value = SpConstantInter.SYS_DICTIONNARY_LEVEL)
    public Result queryDictionaryByLevel() {
        return queryTreeData(iSysDictionaryService.queryDictionaryByLevel(), "字典分类");
    }


    /**
     * @api {post} /sys/dictionary/id  id查询字典
     * @apiName id
     * @apiGroup Dictionary
     * @apiHeader {application/x-www-form-urlencoded} ContentType 请求参数为from方式提交
     * @apiParam {String} id   字典id.
     * @apiSuccess {Object} data 接口返回的数据对象.
     * @apiSuccess (data){String} dicName 字典名称.
     * @apiSuccess (data){String} dicCode 字典编码.
     * @apiSuccess (data){Integer} dicSort 字典排序.
     * @apiSuccess (data){String} code 字典编码.
     * @apiSuccess (data){Integer} state   状态（1 可用 0禁用,注：默认为1）.
     * @apiSuccess (data){Integer} level 字典级别.
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
    @PostMapping(value = SpConstantInter.SYS_DICTIONNARY_QUERY_BY_ID)
    public Result queryById(String id) {
        return queryById(id, iSysDictionaryService);
    }


    /**
     * @api {post} /sys/dictionary/pid 查询子节点
     * @apiName pid
     * @apiGroup Dictionary
     * @apiHeader {application/x-www-form-urlencoded} ContentType 请求参数为from方式提交
     * @apiParam {String} pid 选中子节点的id.
     * @apiParam {String} treeId   树id.
     * @apiSuccess {Object} data 接口返回的数据对象.
     * @apiSuccess (data){String} dicName 字典名称.
     * @apiSuccess (data){String} dicCode 字典编码.
     * @apiSuccess (data){Integer} dicSort 字典排序.
     * @apiSuccess (data){Integer} state   状态（1 可用 0禁用,注：默认为1）.
     * @apiSuccess (data){String} code 字典编码.
     * @apiSuccess (data){Integer} level 字典级别.
     * @apiSuccess {Integer} code 操作编码.
     * @apiSuccess {String} msg 描述(根据code值去码表中查询对应的描述信息).
     * @apiSuccessExample 成功响应:
     * HTTP/1.1 200 OK
     * {
     * "date": [
     * {
     * "treeId": "0-0-3-1",
     * "id": "2dc4103b31960c4f9da173d23d54674a",
     * "text": "1233",
     * "children": [],
     * "parentId": "5449e94afa002e7e9678a0c1d3d8bda4",
     * "level": 2,
     * "parent": false
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
     * "date": false,
     * "code": xxxx,
     * "msg": "xxxxxxxx"
     * }
     */
    @PostMapping(value = SpConstantInter.SYS_DICTIONNARY_QUERY_BY_PID)
    public Result queryByPidTree(String pid, String treeId) {
        return iSysDictionaryService.queryByPidTree(pid, treeId);
    }
}
