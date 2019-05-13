package com.evo.sp.util;

import java.util.UUID;

public class SpStringUtils {
    /**
     * @Description:UUID
     * @Param:
     * @return:
     * @Author: 史国涛
     * @Date: 2019/3/31
     */
    public static String UUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     *
     * 根据label分割字符串，返回数组
     */
    public static String[] splitStr(String str,String label){
        return str.split(label);
    }
}
