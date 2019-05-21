package com.evo.sp.business.system.controller;


import com.evo.sp.business.system.entity.SysServerConfig;
import com.evo.sp.business.system.entity.vo.SysServerConfigVo;
import com.evo.sp.business.system.service.ISysServerConfigService;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.ex.SpAssert;
import com.evo.sp.common.ex.UploadException;
import com.evo.sp.common.ftpfactory.FTPFactory;
import com.evo.sp.common.ftpfactory.service.FTPFile;
import com.evo.sp.common.parameter.PageRequestParameter;
import com.evo.sp.common.result.Result;
import com.evo.sp.common.result.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.evo.sp.common.BaseController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author sgt
 * @since 2019-04-25
 * @apiDefine ServerConfig 服务配置接口
 */
@RestController
@RequestMapping(SpConstantInter.APPLICATION_SERVER_CONFIG)
public class SysServerConfigController extends BaseController {


    @Autowired
    private ISysServerConfigService iSysServerConfigService;

    /**
     * 文件上传
     */
    @PostMapping(value = SpConstantInter.APPLICATION_SERVER_CONFIG_UPLOAD)
    public Result upload(@RequestParam("file") MultipartFile file) {
        //校验参数
        if (!SpAssert.isNotNull(file)) {
            throw new UploadException(ResultEnum.FILE_UPLOAD_IS_NULL.getValue(), ResultEnum.FILE_UPLOAD_IS_NULL.getName());
        }
        Result result = null;
        FTPFile instance = FTPFactory.getInstance();
        try {
            result = new Result(instance.upload(file));
        } catch (IOException e) {
            e.printStackTrace();
            result = new Result(ResultEnum.FILE_UPLOAD_FAIL.getValue(), ResultEnum.FILE_UPLOAD_FAIL.getName());
        }
        return result;
    }


    /**
     * @api {post} /sys/server/config/save 新增
     * @apiName save
     * @apiGroup ServerConfig
     * @apiHeader {applications/json} ContentType 请求参数为json格式
     * @apiParam {String} serverKey  配置项key值.
     * @apiParam {String} serverValue  配置项value值.
     * @apiParam {String} sysDictionaryId  字典对应id.
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
    @PostMapping(value = SpConstantInter.APPLICATION_SERVER_CONFIG_SAVE)
    public Result saveServerConfig(@RequestBody SysServerConfigVo sysServerConfigVo) {
        return iSysServerConfigService.saveServerConfig(sysServerConfigVo);
    }


    /**
     * @api {post} /sys/server/config/start/or/end 启用/停止FTP服务器
     * @apiName start
     * @apiGroup ServerConfig
     * @apiHeader {application/x-www-form-urlencoded} ContentType 请求参数为from方式提交
     * @apiParam {String} disId   字典id.
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
    @PostMapping(value = SpConstantInter.APPLICATION_SERVER_CONFIG_START_END)
    public Result startServerConfig(String disId) {
        return iSysServerConfigService.startServerConfig(disId);
    }


    /**
     * @api {post} /sys/server/config/modify 根据id修改
     * @apiName modify
     * @apiGroup ServerConfig
     * @apiHeader {applications/json} ContentType 请求参数为json格式
     * @apiParam {String} id 配置项id.
     * @apiParam {String} serverKey 配置项key.
     * @apiParam {String} serverValue 配置项value.
     * @apiParam {String} [sysDictionaryId] 字典表id.
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
    @PostMapping(value = SpConstantInter.APPLICATION_SERVER_CONFIG_MODIFT)
    public Result modifyServerConfig(SysServerConfig sysServerConfig) {
        return iSysServerConfigService.modifyServerConfig(sysServerConfig);
    }

    /**
     * @api {post} /sys/server/config/querybyid 根据id查询
     * @apiName querybyid
     * @apiGroup ServerConfig
     * @apiHeader {application/x-www-form-urlencoded} ContentType 请求参数为from方式提交
     * @apiParam {String} id 配置id.
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
    @PostMapping(value = SpConstantInter.APPLICATION_SERVER_CONFIG_QUERY_BY_ID)
    public Result queryServerConfigById(String id) {
        return queryById(id, iSysServerConfigService);
    }


    /**
     * @api {post} /sys/server/config/dels 删除（批量）
     * @apiName dels
     * @apiGroup ServerConfig
     * @apiHeader {application/x-www-form-urlencoded} ContentType 请求参数为from方式提交
     * @apiParam {String[]} ids  配置id.
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
    @PostMapping(value = SpConstantInter.APPLICATION_SERVER_CONFIG_DELS)
    public Result delById(List<String> ids) {
        return dels(ids, iSysServerConfigService);
    }


    /**
     * @api {post} /sys/server/config/page
     * @apiName page
     * @apiGroup ServerConfig
     * @apiHeader {applications/json} ContentType 请求参数为json格式
     * @apiParam {Integer} page 当前页。
     * @apiParam {Integer} size 每页行数
     * @apiParam {JSONOBJECT} parameter JSON格式数据
     * @apiParam (parameter) {String} [serverName] 服务商名称
     * @apiParam (parameter){String} [sort]  排序（desc/asc）.
     * @apiParam (parameter){String} [cSortType]  创建时间排序（desc/asc）.
     * @apiParam (parameter){String} [uSortType]  修改时间排序（desc/asc）.
     * @apiSuccess {JSONOBJECT} data JSON格式数据.
     * @apiSuccess (data){List} records JSON格式数据（列表数据）.
     * @apiSuccess (data){Integer} total 数据总数.
     * @apiSuccess (data){Integer} size 每页行数.
     * @apiSuccess (data){Integer} current 当前页.
     * @apiSuccess (data){Integer} pages 总页数.
     * @apiSuccess (records){String} serverName 服务商.
     * @apiSuccess (records){String} state 状态 .
     * @apiSuccess (records){Date} createTime 创建时间.
     * @apiSuccess (records){Date} updateTime 修改时间.
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
    @PostMapping(value = SpConstantInter.APPLICATION_SERVER_CONFIG_PAGE)
    public Result queryServerConfigPage(@RequestBody PageRequestParameter parameter) {
        return iSysServerConfigService.queryServerConfigPage(parameter);
    }

    /**
     * @api {post} /sys/server/config/page/dis
     * @apiName page/dis
     * @apiGroup ServerConfig
     * @apiHeader {applications/json} ContentType 请求参数为json格式
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
    @PostMapping(value = SpConstantInter.APPLICATION_SERVER_CONFIG_PAGE_DIS)
    public Result queryServerConfigPageByDisId(@RequestBody PageRequestParameter parameter) {
        return iSysServerConfigService.queryServerConfigPageByDisId(parameter);
    }
}
