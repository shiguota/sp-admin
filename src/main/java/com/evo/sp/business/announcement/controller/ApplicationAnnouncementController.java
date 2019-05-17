package com.evo.sp.business.announcement.controller;


import com.evo.sp.business.announcement.entity.ApplicationAnnouncement;
import com.evo.sp.business.announcement.entity.vo.ApplicationAnnouncementVo;
import com.evo.sp.business.announcement.service.IApplicationAnnouncementService;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.ex.SpAssert;
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
 * 前端控制器
 * </p>
 *
 * @author sgt
 * @apiDefine Announcement 公告接口
 * @since 2019-04-25
 */
@RestController
@RequestMapping(SpConstantInter.APPLICATION_ANNOUNCEMENT)
public class ApplicationAnnouncementController extends BaseController {


    @Autowired
    private IApplicationAnnouncementService iApplicationAnnouncementService;


    /**
     * @api {post} /application/announcement/save  发布
     * @apiName save
     * @apiGroup Announcement
     * @apiHeader {applications/json} ContentType 请求参数为json格式
     * @apiParam {String} title 公告名称.
     * @apiParam {String} content 公告内容.
     * @apiParam {Date} startTime 有效期（开始）.
     * @apiParam {Date} endTime 有效期（结束）.
     * @apiParam {String} sysUserId 发布人id.
     * @apiParam {Integer} state     状态 1发布（进行中）  0草稿 2 已过期.
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
    @PostMapping(value = SpConstantInter.APPLICATION_ANNOUNCEMENT_SAVE)
    public Result saveAnnouncement(@RequestBody ApplicationAnnouncement applicationAnnouncement) {
        return save(applicationAnnouncement, iApplicationAnnouncementService);
    }

    /**
     * @api {post} /application/announcement/modify 修改
     * @apiName modify
     * @apiGroup Announcement
     * @apiHeader {application/x-www-form-urlencoded} ContentType 请求参数为from方式提交
     * @apiParam {String} id  公告id.
     * @apiParam {Date} createTime     创建时间.
     * @apiParam {Date} updateTime     修改时间.
     * @apiParam {Integer} state     状态 1发布（进行中）  0草稿 2 已过期.
     * @apiParam {String} title     标题.
     * @apiParam {String} content     内容.
     * @apiParam {Date} startTime     开始时间.
     * @apiParam {Date} endTime     结束时间.
     * @apiParam {String} sysUserId     发布人id.
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
    @PostMapping(value = SpConstantInter.APPLICATION_ANNOUNCEMENT_MODIFY)
    public Result modifyAnnouncement(String id) {
        return modify(id, iApplicationAnnouncementService);
    }

    /**
     * @api {post} /application/announcement/del 删除
     * @apiName del
     * @apiGroup Announcement
     * @apiHeader {applications/json} ContentType 请求参数为json格式
     * @apiParam {Array} ids  公告id .
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
    @PostMapping(value = SpConstantInter.APPLICATION_ANNOUNCEMENT_DEL)
    public Result delAnnouncement(@RequestBody List<String> ids) {
        return dels(ids, iApplicationAnnouncementService);
    }

    /**
     * @api {post} /application/announcement/page  查询公告（分页）
     * @apiName page
     * @apiGroup Announcement
     * @apiHeader {applications/json} ContentType 请求参数为json格式
     * @apiParam {Integer} page 当前页。
     * @apiParam {Integer} size 每页行数
     * @apiParam {String} [title] 公告名称.
     * @apiSuccess {JSONOBJECT} data JSON格式数据.
     * @apiSuccess (data){List} records JSON格式数据（列表数据）.
     * @apiSuccess (data){Integer} total 数据总数.
     * @apiSuccess (data){Integer} size 每页行数.
     * @apiSuccess (data){Integer} current 当前页.
     * @apiSuccess (data){Integer} pages 总页数.
     * @apiSuccess (records){String} title 标题.
     * @apiSuccess (records){Integer} state  状态 1发布（进行中）  0草稿 2 已过期.
     * @apiSuccess (records){Date} createTime 创建时间 .
     * @apiSuccess (records){Date} updateTime 修改时间 .
     * @apiSuccess (records){String} startTime 修改时间 .
     * @apiSuccess (records){String} endTime 修改时间 .
     * @apiSuccess (records){String} updateTime 修改时间 .
     * @apiSuccess (records){String} updateTime 修改时间 .
     * @apiSuccess {Object} data 接口返回的数据对象.
     * @apiSuccess {Integer} code 操作编码.
     * @apiSuccess {String} msg 描述(根据code值去码表中查询对应的描述信息).
     * @apiSuccessExample 成功响应:
     * HTTP/1.1 200 OK
     * {
     *     "date": {
     *         "records": [
     *             {
     *                 "createTime": "2019-05-17 10:39:22",
     *                 "updateTime": "2019-05-17 10:39:22",
     *                 "state": 1,
     *                 "id": "9e13f5e47dd49599a9297338ecf0f1af",
     *                 "title": "这是一篇公告",
     *                 "content": "这是公告内容",
     *                 "startTime": "2019-03-21 23:00:00",
     *                 "endTime": "2019-05-29 23:00:00",
     *                 "sysUserId": "id"
     *             }
     *         ],
     *         "total": 1,
     *         "size": 8,
     *         "current": 1,
     *         "searchCount": true,
     *         "pages": 1
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
    @PostMapping(value = SpConstantInter.APPLICATION_ANNOUNCEMENT_PAGE)
    public Result queryAnnouncementPage(@RequestBody PageRequestParameter<ApplicationAnnouncementVo> pageRequestParameter) {
        return iApplicationAnnouncementService.queryAnnouncementPage(pageRequestParameter);
    }

    /**
     * @api {post} /sys/announcement/id  id查询公告
     * @apiName id
     * @apiGroup Announcement
     * @apiHeader {application/x-www-form-urlencoded} ContentType 请求参数为from方式提交
     * @apiParam {String} id 公告id.
     * @apiSuccess {Object} data 接口返回的数据对象.
     * @apiSuccess (data){Date} createTime     创建时间.
     * @apiSuccess (data){Date} updateTime     修改时间.
     * @apiSuccess (data){Integer} state     状态 1发布（进行中）  0草稿 2 已过期.
     * @apiSuccess (data){String} id     公告id.
     * @apiSuccess (data){String} title     标题.
     * @apiSuccess (data){String} content     内容.
     * @apiSuccess (data){Date} startTime     开始时间.
     * @apiSuccess (data){Date} endTime     结束时间.
     * @apiSuccess (data){String} sysUserId     发布人id.
     * @apiSuccess {Integer} code 操作编码.
     * @apiSuccess {String} msg 描述(根据code值去码表中查询对应的描述信息).
     * @apiSuccessExample 成功响应:
     * HTTP/1.1 200 OK
     * {
     * "date": {
     * "createTime": "2019-05-17 10:39:22",
     * "updateTime": "2019-05-17 10:39:22",
     * "state": 1,
     * "id": "9e13f5e47dd49599a9297338ecf0f1af",
     * "title": "这是一篇公告",
     * "content": "这是公告内容",
     * "startTime": "2019-03-21 23:00:00",
     * "endTime": "2019-05-29 23:00:00",
     * "sysUserId": "id"
     * },
     * "code": 1007,
     * "msg": "操作成功",
     * "extension": null
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
    @PostMapping(value = SpConstantInter.APPLICATION_ANNOUNCEMENT_ID)
    public Result queryAnnouncementByid(String id) {
        return queryById(id, iApplicationAnnouncementService);
    }
}
