package com.evo.sp.business.announcement.controller;


import com.evo.sp.business.announcement.entity.ApplicationAnnouncement;
import com.evo.sp.business.announcement.service.IApplicationAnnouncementService;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.evo.sp.common.BaseController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author sgt
 * @since 2019-04-25
 */
@RestController
@RequestMapping(SpConstantInter.APPLICATION_ANNOUNCEMENT)
public class ApplicationAnnouncementController extends BaseController {


    @Autowired
    private IApplicationAnnouncementService iApplicationAnnouncementService;


    /**
     * @api {post} /application/announcement/save  发布公告
     * @apiName save
     * @apiGroup Announcement
     * @apiHeader {applications/json} ContentType 请求参数为json格式
     * @apiParam {String} title 公告名称.
     * @apiParam {String} content 公告内容.
     * @apiParam {Date} startTime 有效期（开始）.
     * @apiParam {Date} endTime 有效期（结束）.
     * @apiParam {String} sysUserId 发布人id.
     * @apiParam {Integer} [state] 状态.
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
     * @api {post} /application/announcement/modify
     * @apiName modify
     * @apiGroup Announcement
     * @apiHeader {application/x-www-form-urlencoded} ContentType 请求参数为from方式提交
     * @apiParam {String} id  公告id.
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
     * @api {post} /application/announcement/del
     * @apiName del
     * @apiGroup Announcement
     * @apiHeader {application/x-www-form-urlencoded} ContentType 请求参数为from方式提交
     * @apiParam {String} id  公告id .
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
    public Result delAnnouncement(String id) {
        return del(id, iApplicationAnnouncementService);
    }



}
