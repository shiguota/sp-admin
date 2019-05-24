package com.evo.sp.common.ex;

import com.evo.sp.common.BaseEntityVo;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.ex.SpParameterException;
import com.evo.sp.common.result.ResultEnum;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: SP系统Assert类
 * @Author: 史国涛
 * @Date: 2019/3/30
 */
public abstract class SpAssert {

    /**
     * @Description:判断对象是否为空，如果为空抛出空指针异常
     * @Param: o 需要判断的参数
     * @return: void
     * @Author: 史国涛
     * @Date: 2019/3/30
     */
    public static void isNull(Object o) {
        if (o == null || o.equals("")) {
            throw new SpParameterException(ResultEnum.REQUEST_PARAMETER_NOT_NULL.getValue(), ResultEnum.REQUEST_PARAMETER_NOT_NULL.getName());
        }
    }

    /**
     * @Description:判断对象是否为空
     * @Param: o 参数对象
     * @return: 如果是空false，反之返回true
     * @Author: 史国涛
     * @Date: 2019/3/31
     */
    public static boolean isNotNull(Object o) {
        if (o == null || o.equals("")) {
            return false;
        }
        return true;
    }

    /**
     * @Description:判断数组中是否有null值
     * @Param:
     * @return:
     * @Author: 史国涛
     * @Date: 2019/3/30
     */
    public static void isNullParams(String... arg) {
        for (int i = 0; i < arg.length; i++) {
            if (arg[i] == null) {
                throw new SpParameterException(ResultEnum.REQUEST_PARAMETER_NOT_NULL.getValue(), ResultEnum.REQUEST_PARAMETER_NOT_NULL.getName());
            }
        }
    }

    /**
     * @Description:判断对象中是否有null值属性，如果有抛出异常，并返回null值属性类型和名称
     * @Param:
     * @return:
     * @Author: 史国涛
     * @Date: 2019/3/30
     */
    public static void isNullParamsObj(Object o) {
        Map map = columnTypeName(o);
        if (map.size() > 0) {
            throw new SpParameterException(ResultEnum.REQUEST_PARAMETER_NOT_NULL.getValue(), ResultEnum.REQUEST_PARAMETER_NOT_NULL.getName(), map);
        }
    }

    /**
     * @Description:获取传入对象中，字段的类型和名称
     * @Param:
     * @return:
     * @Author: 史国涛
     * @Date: 2019/3/30
     */
    public static Map columnTypeName(Object o) {
        Map<String, Object> map = new HashMap<>();
        Field[] fields = o.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            if (getFieldValueByName(fields[i].getName(), o) == null) {
                map.put("parameter type：", fields[i].getType().toString());
                map.put("parameter name：", fields[i].getName());
            }
        }
        return map;
    }


    /**
     * @Description:根据属性名获取属性值
     * @Param:
     * @return:
     * @Author: 史国涛
     * @Date: 2019/3/30
     */
    private static Object getFieldValueByName(String fieldName, Object o) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[]{});
            Object value = method.invoke(o, new Object[]{});
            return value;
        } catch (Exception e) {
            return null;
        }
    }


    /**
     *
     * 校验排序字段值
     */
    public static void sortAssert(String sort){
        if (isNotNull(sort)) {
            if (!sort.equals(SpConstantInter.ASC)) {
                if (!sort.equals(SpConstantInter.DESC)) {
                    throw  new SpParameterException();
                }
            }
        }
    }
    
    /**
     *
     * 校验排序参数，并设置默认排序参数值
     */
    public static void setSort(BaseEntityVo sort){
        if (SpAssert.isNotNull(sort)) {
            SpAssert.sortAssert(sort.getcSortType());
            SpAssert.sortAssert(sort.getuSortType());
            if (SpAssert.isNotNull(sort.getcSortType())) {
                if (SpAssert.isNotNull(sort.getuSortType())) {
                    sort.setcSortType(SpConstantInter.DESC);
                }
            }
        }
    }
    
    /**
     *
     * 校验是否操作成功
     */
    public static void operationAssert(boolean b,BaseException e){
        if (!b) {
            throw e;
        }
    }

    /**
     * @Description:测试类，生产环境下需要删除
     * @Param:
     * @return:
     * @Author: 史国涛
     * @Date: 2019/3/30
     */
    public static void main(String[] args) {
        String[] a = new String[]{"d", "f", null, "fds"};
        isNullParams(a);
    }
}
