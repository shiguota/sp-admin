package com.evo.sp.business.system.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evo.sp.business.system.entity.SysArea;
import com.evo.sp.business.system.entity.vo.SysAreaVo;
import com.evo.sp.business.system.service.ISysAreaService;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.ex.SpAssert;
import com.evo.sp.common.parameter.PageRequestParameter;
import com.evo.sp.common.result.Result;
import com.evo.sp.common.tree.Tree;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.evo.sp.common.BaseController;

import javax.xml.bind.ValidationEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 区域表 前端控制器
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
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
     * @apiParam {String} shortName   简称.
     * @apiParam {String} lon   经度.
     * @apiParam {String} lat   纬度.
     * @apiParam {String} level   级别.
     * @apiParam {String} sort   排序.
     * @apiParam {String} pid   父id.
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
    @RequestMapping(value = SpConstantInter.SYS_AREA_SAVE, method = RequestMethod.POST)
    public Result saveArea(@RequestBody SysArea sysArea) {
        return save(sysArea, iSysAreaService);
    }


    /**
     * @api {post} /sys/area/del 删除
     * @apiName del
     * @apiGroup Area
     * @apiHeader {application/x-www-form-urlencoded} ContentType 请求参数为from方式提交
     * @apiParam {String} id  区域id .
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
    @RequestMapping(value = SpConstantInter.SYS_AREA_DEL, method = RequestMethod.POST)
    public Result delArea(String id) {
        return del(id, iSysAreaService);
    }


    /**
     * @api {post} /sys/area/modify 修改
     * @apiName modify
     * @apiGroup Area
     * @apiHeader {applications/json} ContentType 请求参数为json格式
     * @apiHeader {application/x-www-form-urlencoded} ContentType 请求参数为from方式提交
     * @apiParam {String} areaName  区域名 .
     * @apiParam {String} shortName   简称.
     * @apiParam {String} lon   经度.
     * @apiParam {String} lat   纬度.
     * @apiParam {String} level   级别.
     * @apiParam {String} sort   排序.
     * @apiParam {String} pid   父id.
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
    @RequestMapping(value = SpConstantInter.SYS_AREA_NODIFY, method = RequestMethod.POST)
    public Result modifyArea(@RequestBody SysArea sysArea) {
        return modify(sysArea, iSysAreaService);
    }


    /**
     * 查询区域（树结构）
     */

    /**
     * @api {post} /sys/area/tree
     * @apiName tree
     * @apiGroup Area
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
    @RequestMapping(value = SpConstantInter.SYS_AREA_TREE, method = RequestMethod.POST)
    public Result queryAreaTree() {
        return queryTreeData(iSysAreaService.queryAreaTree(), TOP_NODE_NAME);
    }

    /**
     * 查询区域
     */
    @RequestMapping(value = SpConstantInter.SYS_AREA_QUERY, method = RequestMethod.POST)
    public Result queryArea(@RequestBody SysArea sysArea) {
        QueryWrapper<SysArea> sysAreaWrapper = new QueryWrapper<>();
        sysAreaWrapper.setEntity(sysArea);
        return queryListsByColumn(sysAreaWrapper, iSysAreaService);
    }

    /**
     * 查询区域（分页）
     */
    @RequestMapping(value = SpConstantInter.SYS_AREA_PAGE, method = RequestMethod.POST)
    public Result queryListPage(@RequestBody PageRequestParameter<SysAreaVo> sysAreaPageRequestParameter) {
        return iSysAreaService.queryListPage(sysAreaPageRequestParameter);
    }


}
