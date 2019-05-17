package com.evo.sp.business.system.controller;


import com.evo.sp.business.system.entity.SysOrganization;
import com.evo.sp.business.system.entity.vo.SysOrganizationVo;
import com.evo.sp.business.system.service.ISysOrganizationService;
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
 * 组织机构表 前端控制器
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 * @apiDefine Organization 组织（机构）接口
 */
@RestController
@RequestMapping(SpConstantInter.SYS_ORGANIZATION)
@Api(tags = "组织（机构）")
public class SysOrganizationController extends BaseController {

    //顶级节点名称
    private final String TOP_NODE_NAME = "所有机构";

    @Autowired
    private ISysOrganizationService iSysOrganizationService;


    /**
     * @api {post} /sys/organization/save  新增
     * @apiName save
     * @apiGroup Organization
     * @apiHeader {applications/json} ContentType 请求参数为json格式
     * @apiParam {String} orgName  机构名称.
     * @apiParam {String} [orgSort]   排序.
     * @apiParam {String} orgLevel   级别.
     * @apiParam {String} pid   父id.
     * @apiParam {String} sysAreaId   区域id.
     * @apiParam {String} orgShort   简称.
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
    @RequestMapping(value = SpConstantInter.SYS_ORGANIZATION_SAVE, method = RequestMethod.POST)
    public Result saveOrganization(@RequestBody SysOrganization sysOrganization) {
        return save(sysOrganization, iSysOrganizationService);
    }


    /**
     * @api {post}  /sys/organization/del  删除（批量）
     * @apiName del
     * @apiGroup Organization
     * @apiHeader {applications/json} ContentType 请求参数为json格式
     * @apiParam {Array} ids   机构id.
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
    @RequestMapping(value = SpConstantInter.SYS_ORGANIZATION_DEL, method = RequestMethod.POST)
    public Result delOrganization(@RequestBody List<String> ids) {
        return dels(ids, iSysOrganizationService);
    }


    /**
     * @api {post} /sys/organization/id id查询组织（机构）
     * @apiName id
     * @apiGroup Organization
     * @apiHeader {application/x-www-form-urlencoded} ContentType 请求参数为from方式提交
     * @apiParam {String} id  机构id.
     * @apiSuccess {Object} data 接口返回的数据对象.
     * @apiSuccess (data){String} id  机构id.
     * @apiSuccess (data){String} orgName  机构名称.
     * @apiSuccess (data){String} orgSort   排序.
     * @apiSuccess (data){String} orgLevel   级别.
     * @apiSuccess (data){String} pid   父id.
     * @apiSuccess (data){String} sysAreaId   区域id.
     * @apiSuccess (data){String} orgShort   简称.
     * @apiSuccess (data){Date} createTime   创建时间.
     * @apiSuccess (data){Date} updateTime   修改时间.
     * @apiSuccess {Integer} code 操作编码.
     * @apiSuccess {String} msg 描述(根据code值去码表中查询对应的描述信息).
     * @apiSuccessExample 成功响应:
     * HTTP/1.1 200 OK
     * {
     *     "date": {
     *         "createTime": "2019-05-15T11:17:14",
     *         "updateTime": "2019-05-15T11:17:14",
     *         "state": 1,
     *         "id": "6e63dc94b4d01ee0abf788f035ae8883",
     *         "orgName": "北京未来媒体",
     *         "sort": null,
     *         "orgLevel": 1,
     *         "pid": "-1",
     *         "sysAreaId": "42ab78b0b4d7e59fa4efe025b306b64d",
     *         "orgShort": "Evomedia"
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
    @PostMapping(value = SpConstantInter.SYS_AREA_ID)
    public Result queryOrgById(String id) {
        return queryById(id, iSysOrganizationService);
    }


    /**
     * @api {post} /sys/organization/modify  修改
     * @apiName modify
     * @apiGroup Organization
     * @apiHeader {applications/json} ContentType 请求参数为json格式
     * @apiParam {String} id  机构id.
     * @apiParam {String} orgName  机构名称.
     * @apiParam {String} [sort]   排序.
     * @apiParam {String} level   级别.
     * @apiParam {String} pid   父id.
     * @apiParam {String} sysAreaId   区域id.
     * @apiParam {String} orgShort   简称.
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
    @RequestMapping(value = SpConstantInter.SYS_ORGANIZATION_MODIFY, method = RequestMethod.POST)
    public Result modifyOrganization(@RequestBody SysOrganization sysOrganization) {
        return modify(sysOrganization, iSysOrganizationService);
    }

    /**
     * @api {post} /sys/organization/page 查询组织机构(分页)
     * @apiName page
     * @apiGroup Organization
     * @apiHeader {applications/json} ContentType 请求参数为json格式
     * @apiParam {Integer} page 当前页.
     * @apiParam {Integer} size 每页行数.
     * @apiParam {OBJECT} parameter 参数对象.
     * @apiParam (parameter){String} id  菜单id.
     * @apiParam (parameter){String} [orgName]  机构名称.
     * @apiParam (parameter){String} [sort]  排序（desc/asc）.
     * @apiParam (parameter){String} [cSortType]  创建时间排序（desc/asc）.
     * @apiParam (parameter){String} [uSortType]  修改时间排序（desc/asc）.
     * @apiSuccess {JSONOBJECT} data JSON格式数据.
     * @apiSuccess (data){List} records JSON格式数据（列表数据）.
     * @apiSuccess (data){Integer} total 数据总数.
     * @apiSuccess (data){Integer} size 每页行数.
     * @apiSuccess (data){Integer} current 当前页.
     * @apiSuccess (data){Integer} pages 总页数.
     * @apiSuccess (records){String} orgName  机构名称.
     * @apiSuccess (records){String} sort   排序.
     * @apiSuccess (records){String} level   级别.
     * @apiSuccess (records){String} pid   父id.
     * @apiSuccess (records){String} sysAreaId   区域id.
     * @apiSuccess (records){String} orgShort   简称.
     * @apiSuccess (records){String} id   机构id.
     * @apiSuccess (records){Date} createTime   创建时间.
     * @apiSuccess (records){Date} updateTime   修改时间.
     * @apiSuccess {Object} data 接口返回的数据对象.
     * @apiSuccess {Integer} code 操作编码.
     * @apiSuccess {String} msg 描述(根据code值去码表中查询对应的描述信息).
     * @apiSuccessExample 成功响应:
     * HTTP/1.1 200 OK
     * {
     *     "date": {
     *         "records": [
     *             {
     *                 "createTime": "2019-05-15T11:44:41",
     *                 "updateTime": "2019-05-15T11:45:58",
     *                 "state": 1,
     *                 "id": "a4b70496c5ea6163c76bc3b22b0321d3",
     *                 "orgName": "北京未来媒体",
     *                 "sort": null,
     *                 "level": 1,
     *                 "pid": "-1",
     *                 "sysAreaId": "42ab78b0b4d7e59fa4efe025b306b64d",
     *                 "orgShort": "Evomedia"
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
    @RequestMapping(value = SpConstantInter.SYS_ORGANIZATION_PAGE, method = RequestMethod.POST)
    public Result queryListPage(@RequestBody PageRequestParameter<SysOrganizationVo> pageRequestParameter) {
        return iSysOrganizationService.queryListPage(pageRequestParameter);
    }

    /**
     * @api {post} /sys/organization/tree 根据userId查询机构tree
     * @apiName tree
     * @apiGroup Organization
     * @apiHeader {applications/json} ContentType 请求参数为json格式
     * @apiParam {String} userId   用户id.
     * @apiSuccess {JSONOBJECT} data 接口返回的数据对象.
     * @apiSuccess (data){String} id 节点id.
     * @apiSuccess (data){String} text 节点名称.
     * @apiSuccess (data){String} parentId 父id.
     * @apiSuccess (data){Integer} level 级别.
     * @apiSuccess (data){JSONOBJECT} children 子节点集合.
     * @apiSuccess {Integer} code 操作编码.
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
    @RequestMapping(value = SpConstantInter.SYS_ORGANIZATION_TREE, method = RequestMethod.POST)
    public Result queryListTree(String userId) {
        return queryTreeData(iSysOrganizationService.queryOrgByUserId(userId), TOP_NODE_NAME);
    }
}
