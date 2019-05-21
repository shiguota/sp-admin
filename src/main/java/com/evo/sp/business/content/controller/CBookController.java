package com.evo.sp.business.content.controller;


import com.evo.sp.business.content.entity.CBook;
import com.evo.sp.business.content.entity.vo.CBookVo;
import com.evo.sp.business.content.service.ICBookService;
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
 * 绘本表 前端控制器
 * </p>
 *
 * @author sgt
 * @apiDefine BOOK 绘本接口
 * @since 2019-05-20
 */
@RestController
@RequestMapping(SpConstantInter.CONTENT_BOOK)
public class CBookController extends BaseController {


    @Autowired
    private ICBookService icBookService;


    /**
     * @api {post} /conatent/book/save 新增
     * @apiName save
     * @apiGroup BOOK
     * @apiHeader {applications/json} ContentType 请求参数为json格式
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
    @PostMapping(value = SpConstantInter.CONTENT_BOOK_SAVE)
    public Result saveBook(@RequestBody CBook cBook) {
        return save(cBook, icBookService);
    }


    /**
     * @api {post} /conatent/book/del  删除
     * @apiName del
     * @apiGroup BOOK
     * @apiHeader {applications/json} ContentType 请求参数为json格式
     * @apiParam {String} ids    绘本id.
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
    @PostMapping(value = SpConstantInter.CONTENT_BOOK_DEL)
    public Result delBook(@RequestBody List<String> ids) {
        return dels(ids, icBookService);
    }


    /**
     * @api {post} /content/book/modify  修改
     * @apiName modify
     * @apiGroup BOOK
     * @apiHeader {applications/json} ContentType 请求参数为json格式
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
    @PostMapping(value = SpConstantInter.CONTENT_BOOK_MODIFY)
    public Result modifyBook(@RequestBody CBook cBook) {
        return modify(cBook, icBookService);
    }


    /**
     * @api {post} /sys/user/login
     * @apiName login
     * @apiGroup User
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
    @PostMapping(value = SpConstantInter.CONTENT_BOOK_PAGE)
    public Result queryListPage(PageRequestParameter<CBookVo> cBookVoPageRequestParameter) {
        return new Result(icBookService.queryListPage(cBookVoPageRequestParameter));
    }

    /**
     * @api {post} /content/book/id
     * @apiName id
     * @apiGroup BOOK
     * @apiHeader {application/x-www-form-urlencoded} ContentType 请求参数为from方式提交
     * @apiParam {String} id  绘本id .
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
    @PostMapping(value = SpConstantInter.CONTENT_BOOK_ID)
    public Result queryBookById(String id) {
        return queryById(id, icBookService);
    }

}
