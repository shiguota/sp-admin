package com.evo.sp.business.content.controller;


import com.evo.sp.business.content.entity.RefAppColumn;
import com.evo.sp.business.content.entity.vo.RefAppColumnVo;
import com.evo.sp.business.content.service.IRefAppColumnService;
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
 * 应用栏目关联表 前端控制器
 * </p>
 *
 * @author sgt
 * @since 2019-05-22
 * @apiDefine APP_COLUMN 应用栏目接口
 */
@RestController
@RequestMapping(SpConstantInter.REF_APP_COLUMN)
public class RefAppColumnController extends BaseController {

    @Autowired
    private IRefAppColumnService iRefAppColumnService;

    /**
     * @api {post} /ref/app/column/save  新增
     * @apiName save
     * @apiGroup APP_COLUMN
     * @apiHeader {applications/json} ContentType 请求参数为json格式
     * @apiParam {Array} refAppColumn   对象集合.
     * @apiParam (refAppColumn){String} appId   应用id.
     * @apiParam (refAppColumn){String} columnId   栏目id.
     * @apiSuccess {Object} data 接口返回的数据对象.
     * @apiSuccess {Intege-+r} code 操作编码.
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
    @PostMapping(value = SpConstantInter.REF_APP_COLUMN_SAVE)
    public Result saveAppColumn(@RequestBody List<RefAppColumn> refAppColumn) {
        return save(refAppColumn, iRefAppColumnService);
    }

    /**
     * @api {post} /ref/app/column/del 删除
     * @apiName login
     * @apiGroup User
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
    @PostMapping(value = SpConstantInter.REF_APP_COLUMN_DEL)
    public Result delAppColumn(@RequestBody RefAppColumnVo vo) {
        return iRefAppColumnService.dels(vo.getIds(), vo.getType());
    }

}
