package com.evo.sp.common;

public class SpConstantInter {
    /**
     * 全局常量
     */
    public static final String USER_NAME = "userName";
    public static final String USER = "user";
    public static final String ENCRYPTION_TYPE = "MD5";


    /**
     * 数据库字段
     */
    public static final String TABLE_ID = "id";
    //用户表
    public static final String SYSTEM_USER_NAME = "name";


    /**
     * URL
     */
    //用户控制器URL
    public static final String SYSTEM_USER = "/system/user";
    public static final String SYSTEM_USER_SAVE = "/save";
    public static final String SYSTEM_USER_LOGIN = "/login";
    public static final String SYSTEM_USER_LOGIN_OUT = "/loginout";
    public static final String SYSTEM_USER_DEL = "/del";
    public static final String SYSTEM_USER_MODIFY = "/modify";


    /**
     * 权限
     **/
    public static final String PERMISSION_SYSTEM_USER_SAVE = "system:user:save";
    public static final String PERMISSION_SYSTEM_USER_DEL = "system:user:del";
    public static final String PERMISSION_SYSTEM_USER_MODIFY = "system:user:modify";

}
