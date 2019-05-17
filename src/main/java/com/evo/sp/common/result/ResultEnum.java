package com.evo.sp.common.result;

import com.baomidou.mybatisplus.annotation.EnumValue;

import java.lang.annotation.Annotation;

/**
 *
 *  @apiDefine CodeTable 码表
 */
public enum ResultEnum implements EnumValue {
    /**
     * @api {post} /# 码表
     * @apiName #
     * @apiGroup CodeTable
     * @apiError 1001 保存成功.
     * @apiError 1002 保存失败.
     * @apiError 1003 删除成功.
     * @apiError 1004 删除失败.
     * @apiError 1005 修改成功.
     * @apiError 1006 修改失败.
     * @apiError 1007 操作成功.
     * @apiError 1008 操作失败.
     * @apiError 1009 未知错误.
     * @apiError 2001 登录失败,请联系管理人员.
     * @apiError 2002 登录成功.
     * @apiError 2003 当前用户不存在.
     * @apiError 2004 密码错误.
     * @apiError 2005 用户名或密码错误.
     * @apiError 2006 登录失败，当前用户被冻结.
     * @apiError 2007 注销用户成功.
     * @apiError 2008 注销用户失败.
     * @apiError 2009 当前用户名已存在.
     * @apiError 2010 会话已过期，请重新登录.
     * @apiError 2011 请先登录.
     * @apiError 3001 参数错误.
     * @apiError 3002 参数不能为空.
     * @apiError 4001 未授权.
     * @apiError 4002 已存在相同CODE权限信息.
     * @apiError 4003 已存在相同NAME权限信息.
     * @apiError 5001 当前用户已存在.
     * @apiError 6001 请选择文件.
     * @apiError 6002 上传成功.
     * @apiError 6003 上传失败.
     * @apiError 6004 当前目录已存在同名文件，无法创建该名称文件夹.
     */
    //CURD
    SAVE_SUCCESS(1001, "保存成功"),
    SAVE_FAIL(1002, "保存失败"),
    REMOVE_SUCCESS(1003, "删除成功"),
    REMOVE_FAIL(1004, "删除失败"),
    MODIFY_SUCCESS(1005, "修改成功"),
    MODIFY_FAIL(1006, "修改失败"),
    OPERATION_SUCCESS(1007, "操作成功"),
    OPERATION_FAIL(1008, "操作失败"),
    OPERATION_UNKNOWN(1009, "未知错误"),
    //    登录
    LOGIN_FAIL(2001, "登录失败,请联系管理人员"),
    LOGIN_SUCCESS(2002, "登录成功"),
    LOGIN_FIAL_SUER_NOT_IN_SYSTEM(2003, "当前用户不存在"),
    LOGIN_FAIL_SUER_PASSWORD_IS_ERORR(2004, "密码错误"),
    LOGIN_FAIL_SUER_NOT_AND_PASSWORD_ERORR(2005, "用户名或密码错误"),
    LOGIN_FAIL_USER_IS_LOCKED(2006, "登录失败，当前用户被冻结"),
    LOGIN_OUT_SUCCESS(2007, "注销用户成功"),
    LOGIN_OUT_FAIL(2008, "注销用户失败"),
    REGISTER_FAIL(2009, "当前用户名已存在"),
    SESSION_IS_NULL(2010, "会话已过期，请重新登录"),
    LOGIN_HELP(2011, "请先登录"),
    //     请求
    REQUEST_PARAMETER_ERROR(3001, "参数错误"),
    REQUEST_PARAMETER_NOT_NULL(3002, "参数不能为空"),

    //    权限
    PERMISSION_UNAUTHORIZED(4001, "未授权"),
    PERMISSION_SAVE_CODE(4002, "已存在相同CODE权限信息"),
    PERMISSION_SAVE_NAME(4003, "已存在相同NAME权限信息"),
    PERMISSION_DEL_SUCCESS(4004, "删除权限成功"),
    PERMISSION_DEL_FAIL(4005, "删除权限失败"),

    //    用户
    USER_IS_EXIST(5001, "当前用户已存在"),
    //   文件
    FILE_UPLOAD_IS_NULL(6001, "请选择文件"),
    FILE_UPLOAD_SUCCESS(6002, "上传成功"),
    FILE_UPLOAD_FAIL(6003, "上传失败"),
    FILE_NAME_EXISTS(6004, "当前目录已存在同名文件，无法创建该名称文件夹");


    private int value;

    private String name;


    ResultEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }


    /**
     * 按照Value获得枚举值
     */
    public static ResultEnum valueOf(Integer value) {
        if (value != null) {
            for (ResultEnum fsEnum : ResultEnum.values()) {
                if (fsEnum.getValue() == value) {
                    return fsEnum;
                }
            }
        }
        return null;
    }


    public int getValue() {
        return value;
    }


    public String getName() {
        return name;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }


}
