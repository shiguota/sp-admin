package com.evo.sp.common.result;

import com.baomidou.mybatisplus.annotation.EnumValue;

import java.lang.annotation.Annotation;

public enum ResultEnum implements EnumValue {
//    操作
    SAVE_SUCCESS(1001,"保存成功"),
    SAVE_FAIL(1002,"保存失败"),
    REMOVE_SUCCESS(1003,"删除成功"),
    REMOVE_FAIL(1004,"删除失败"),
    MODIFY_SUCCESS(1005,"修改成功"),
    MODIFY_FAIL(1006,"修改失败"),
    OPERATION_SUCCESS(1007,"操作成功"),
    OPERATION_FAIL(1008,"操作失败"),



//    登录
    LOGIN_FAIL(2001,"登录失败,请联系管理人员"),
    LOGIN_SUCCESS(2002,"登录成功"),
    LOGIN_FIAL_SUER_NOT_IN_SYSTEM(2003,"当前用户不存在"),
    LOGIN_FAIL_SUER_PASSWORD_IS_ERORR(2004,"密码错误"),
    LOGIN_FAIL_SUER_NOT_AND_PASSWORD_ERORR(2005,"用户名或密码错误"),
    LOGIN_FAIL_USER_IS_LOCKED(2006,"登录失败，当前用户被冻结"),
    LOGIN_OUT_SUCCESS(2007,"注销用户成功"),
    LOGIN_OUT_FAIL(2008,"注销用户失败"),




//     请求
    REQUEST_PARAMETER_ERROR(3001,"参数错误"),
    REQUEST_PARAMETER_NOT_NULL(3002,"参数不能为空"),




































    ;


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
