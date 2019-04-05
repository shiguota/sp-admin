package com.evo.sp.common.ex;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
* @Description:全局异常捕获类
* @Author: sgt
* @Date:  2019-03-29 
*/

@ControllerAdvice
public class SpControllerAdvice {

    private static final String EXCEPTION_CODE= "code";
    private static final String EXCEPTION_MSG= "msg";
    private static final String EXCEPTION_MSG_DETAIL= "msg_detail";

    /**
     * 全局异常捕捉处理
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Map ExceptionHandler(Exception ex) {
        Map map = new HashMap();
        if(ex instanceof SpParameterException){
            SpParameterException spParameterException = (SpParameterException) ex;
            map.put(EXCEPTION_CODE, spParameterException.getCode());
            map.put(EXCEPTION_MSG, spParameterException.getMsg());
            map.put(EXCEPTION_MSG_DETAIL, spParameterException.getDtail());
        }
        map.put(EXCEPTION_CODE, 100);
        map.put(EXCEPTION_MSG, ex.getMessage());
        return map;
    }
//
//    /**
//     * 拦截捕捉自定义异常 SpParameterException.class
//     * @param ex
//     * @return
//     */
//    @ResponseBody
//    @ExceptionHandler(value = SpParameterException.class)
//    public Map SpParameterExceptionHandler(SpParameterException ex) {
//        Map map = new HashMap();
//        map.put(EXCEPTION_CODE, ex.getCode());
//        map.put(EXCEPTION_MSG, ex.getMsg());
//        map.put(EXCEPTION_MSG_DETAIL, ex.getDtail());
//        return map;
//    }


    /**
     * 拦截捕捉自定义异常 SpParameterException.class
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = SpSessionException.class)
    public Map SpSessionExceptionHandler(SpSessionException ex) {
        Map map = new HashMap();
        map.put(EXCEPTION_CODE, ex.getCode());
        map.put(EXCEPTION_MSG, ex.getMsg());
        return map;
    }
}
