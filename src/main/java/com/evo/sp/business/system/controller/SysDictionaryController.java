package com.evo.sp.business.system.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.evo.sp.business.system.entity.SysDictionary;
import com.evo.sp.business.system.entity.vo.SysDictionaryVo;
import com.evo.sp.business.system.service.ISysDictionaryService;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.parameter.PageRequestParameter;
import com.evo.sp.common.result.Result;
import com.evo.sp.common.tree.Tree;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.evo.sp.common.BaseController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 字典表 前端控制器
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
@RestController
@RequestMapping(SpConstantInter.SYS_DICTIONNARY)
@Api(tags = "字典表")
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
     * @apiParam {Integer} [dicSort]   排序.
     * @apiParam {String} pid   父id.
     * @apiParam {Integer} [level]   级别.
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
    @RequestMapping(value = SpConstantInter.SYS_DICTIONNARY_SAVE, method = RequestMethod.POST)
    public Result saveDictionary(@RequestBody SysDictionary sysDictionary) {
        return new Result(iSysDictionaryService.save(sysDictionary));
    }


    /**
     * @api {post} /sys/dictionary/del  删除
     * @apiName del
     * @apiGroup Dictionary
     * @apiHeader {application/x-www-form-urlencoded} ContentType 请求参数为from方式提交
     * @apiParam {String} id  字典id.
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
    @RequestMapping(value = SpConstantInter.SYS_DICTIONNARY_DEL, method = RequestMethod.POST)
    public Result delDictionary(String id) {
        return del(id, iSysDictionaryService);
    }


    /**
     * @api {post} /sys/dictionary/modify  编辑
     * @apiName modify
     * @apiGroup Dictionary
     * @apiHeader {applications/json} ContentType 请求参数为json格式
     * @apiParam {String} dicName   名称.
     * @apiParam {String} dicCode   编码.
     * @apiParam {Integer} dicSort   排序.
     * @apiParam {String} pid   父id.
     * @apiParam {Integer} level   级别.
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
    @RequestMapping(value = SpConstantInter.SYS_DICTIONNARY_MODIFY, method = RequestMethod.POST)
    public Result modifyDictionary(@RequestBody SysDictionary sysDictionary) {
        return modify(sysDictionary, iSysDictionaryService);
    }

    /**
     * @api {post} /sys/dictionary/page  根据字典名称/Pid查询（模糊分页查询）
     * @apiName page
     * @apiGroup Dictionary
     * @apiHeader {applications/json} ContentType 请求参数为json格式
     * @apiParam {Integer} page 当前页。
     * @apiParam {Integer} size 每页行数
     * @apiParam {String} [dicName]  字典名称.
     * @apiParam {String} pid  父id.
     * @apiSuccess {JSONOBJECT} data JSON格式数据.
     * @apiSuccess (data){List} records JSON格式数据（列表数据）.
     * @apiSuccess (data){Integer} total 数据总数.
     * @apiSuccess (data){Integer} size 每页行数.
     * @apiSuccess (data){Integer} current 当前页.
     * @apiSuccess (data){Integer} pages 总页数.
     * @apiSuccess (data){String} dicCode 字典编码.
     * @apiSuccess (data){String} dicName 字典名称.
     * @apiSuccess (data){integer} sort 排序.
     * @apiSuccess (data){Date} createTime 创建时间.
     * @apiSuccess (data){Date} updateTime 修改时间.
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
    @RequestMapping(value = SpConstantInter.SYS_DICTIONNARY_QUERY_PAGE, method = RequestMethod.POST)
    public Result queryByName(@RequestBody PageRequestParameter<SysDictionaryVo> pageRequestParameter) {
        return new Result(iSysDictionaryService.queryByNamePid(pageRequestParameter));
    }


    /**
     * @api {post} /sys/dictionary/code  根据code编码查询
     * @apiName code
     * @apiGroup Dictionary
     * @apiHeader {application/x-www-form-urlencoded} ContentType 请求参数为from方式提交
     * @apiParam {String} dicCode  字典编码 .
     * @apiSuccess {Object} data 接口返回的数据对象.
     * @apiSuccess (data){String} id id.
     * @apiSuccess (data){String} dicName 名称.
     * @apiSuccess (data){String} dicCode 字典编码.
     * @apiSuccess {Integer} code 操作编码.
     * @apiSuccess {String} msg 描述(根据code值去码表中查询对应的描述信息).
     * @apiSuccessExample 成功响应:
     * HTTP/1.1 200 OK
     * {
     * "date": {},
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

    @PostMapping(value = SpConstantInter.SYS_DICTIONNARY_QUERY_BY_CODE)
    public Result queryByDisCode(String disCode) {
        return iSysDictionaryService.queryByCode(disCode);
    }


    /**
     * @api {post} /sys/dictionary/level 字典树
     * @apiName level
     * @apiGroup Dictionary
     * @apiSuccess {Object} data 接口返回的数据对象.
     * @apiSuccess {Integer} code 操作编码.
     * @apiSuccess {String} msg 描述(根据code值去码表中查询对应的描述信息).
     * @apiSuccessExample 成功响应:
     * HTTP/1.1 200 OK
     *{
     *   "date": {
     *     "treeId": "0-0",
     *     "id": "-1",
     *     "text": "字典分类",
     *     "state": "open",
     *     "checked": true,
     *     "children": [
     *       {
     *         "treeId": "0-0-1",
     *         "id": "57179210133575b328b1907d996ebcf6",
     *         "text": "锁定状态",
     *         "state": "open",
     *         "checked": false,
     *         "children": [],
     *         "parent": false
     *       },
     *       {
     *         "treeId": "0-0-2",
     *         "id": "e170fa1ebeff1f849db1511a027ca3cd",
     *         "text": "合作伙伴分类",
     *         "state": "open",
     *         "checked": false,
     *         "children": [],
     *         "parent": false
     *       }
     *     ],
     *     "path": "#",
     *     "parent": false
     *   },
     *   "code": 1007,
     *   "msg": "操作成功"
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
    @PostMapping(value = SpConstantInter.SYS_DICTIONNARY_LEVEL)
    public Result queryDictionaryByLevel() {
        List<SysDictionary> sysDictionaries = iSysDictionaryService.queryDictionaryByLevel();
        List<Tree<SysDictionary>> trees = new ArrayList<>();
        for (int i = 0; i < sysDictionaries.size(); i++) {
                Tree tree = new Tree();
            tree.setText(sysDictionaries.get(i).getDicName());
            tree.setId(sysDictionaries.get(i).getId());
            tree.setParentId(sysDictionaries.get(i).getPid());
            tree.setTreeId(0+"-"+0+"-"+(i+1));
            trees.add(tree);
        }
        return queryTreeData(trees,"字典分类");
    }

}
