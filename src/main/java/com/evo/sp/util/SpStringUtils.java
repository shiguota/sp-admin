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
}
