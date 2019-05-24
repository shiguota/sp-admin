package com.evo.sp.business.content.controller;


import com.evo.sp.business.content.entity.RefBookColumn;
import com.evo.sp.business.content.service.IRefBookColumnService;
import com.evo.sp.common.SpConstantInter;
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
 * 栏目绘本关联表 前端控制器
 * </p>
 *
 * @author sgt
 * @since 2019-05-22
 */
@RestController
@RequestMapping(SpConstantInter.REF_BOOK_COLUMN)
public class RefBookColumnController extends BaseController {

    @Autowired
    private IRefBookColumnService iRefBookColumnService;


    /**
     * @api {post} /ref/book/column/save 新增
     * @apiName save
     * @apiGroup BOOK_COLUMN
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
    @PostMapping(value = SpConstantInter.REF_BOOK_COLUMN_SAVE)
    public Result saveBookColumn(@RequestBody List<RefBookColumn> refBookColumns) {
        return save(refBookColumns, iRefBookColumnService);
    }


    /**
     * @api {post} /ref/book/column/del  删除
     * @apiName del
     * @apiGroup BOOK_COLUMN
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
    @PostMapping(value = SpConstantInter.REF_BOOK_COLUMN_DEL)
    public Result delBookColumn(@RequestBody List<String> ids,Integer type) {
        return iRefBookColumnService.dels(ids,type);
    }

}
