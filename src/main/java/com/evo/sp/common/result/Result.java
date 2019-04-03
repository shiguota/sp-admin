package com.evo.sp.common.result;

import java.io.Serializable;

/**
* @Description: 返回数据bean
* @Author: sgt
* @Date:  2019-03-27
*/
public class Result implements Serializable {
    /**
     * 返回的数据
     */
    private Object date;

    /**
     *  错误编码
     */
    private Integer code;
    /**
     *  错误信息
     */

    private Object msg;

    public Result(Object date) {
        this.date = date;
        this.code = ResultEnum.OPERATION_SUCCESS.getValue();
        this.msg = ResultEnum.OPERATION_SUCCESS.getName();
    }

    public Result(Integer code, Object msg) {
        date = false;
        this.code = code;
        this.msg = msg;
    }

    public Result(Object date, Integer code, Object msg) {
        this.date = date;
        this.code = code;
        this.msg = msg;
    }

    public Object getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date = date;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }
}
