package com.evo.sp.common;

import org.springframework.web.accept.FixedContentNegotiationStrategy;

public class SpConstantInter {
    /**
     * 全局常量
     */
    public static final String USER_NAME = "userName";
    public static final String USER = "user";
    public static final String ENCRYPTION_TYPE = "MD5";
    public static final String CHARACTER_ENCODING = "UTF-8";



    /**
     * 数据库字段
     */
    public static final String TABLE_ID = "id";
    //用户表
    public static final String SYSTEM_USER_NAME = "name";


    /**
     * URL
     */
    //日志
    public static final String SYSTEM_LOG="/system/log";
    public static final String SYSTEM_LOG_SAVE="/save";
    public static final String SYSTEM_LOG_DEL="/del";
    public static final String SYSTEM_LOG_MODIFY="/modify";
    public static final String SYSTEM_LOG_PAGES="/pages";
    //字典
    public static final String SYSTEM_DICTIONNARY="/system/dictionary";
    public static final String SYSTEM_DICTIONNARY_SAVE = "/save";
    public static final String SYSTEM_DICTIONNARY_DEL = "/del";
    public static final String SYSTEM_DICTIONNARY_MODIFY = "/modify";
    public static final String SYSTEM_DICTIONNARY_PAGES = "/pages";
    //用户控制器URL
    public static final String SYSTEM_USER = "/system/user";
    public static final String SYSTEM_USER_SAVE = "/save";
    public static final String SYSTEM_USER_LOGIN = "/login";
    public static final String SYSTEM_USER_LOGIN_OUT = "/loginout";
    public static final String SYSTEM_USER_DEL = "/del";
    public static final String SYSTEM_USER_MODIFY = "/modify";
    public static final String SYSTEM_USER_PAGES = "/pages";
    //权限
    public static final  String SYSTEM_PERMISSION ="/system/permission";
    public static final  String SYSTEM_PERMISSION_SAVE ="/save";
    public static final  String SYSTEM_PERMISSION_DEL ="/del";
    public static final  String SYSTEM_PERMISSION_MODIFY ="/modify";
    public static final  String SYSTEM_PERMISSION_PAGES ="/pages";
    //角色
    public static final  String SYSTEM_ROLE ="/system/role";
    public static final  String SYSTEM_ROLE_SAVE ="/save";
    public static final  String SYSTEM_ROLE_DEL ="/del";
    public static final  String SYSTEM_ROLE_MODIFY ="/modify";
    public static final  String SYSTEM_ROLE_PAGES ="/pages";
    //菜单
    public static final String SYSTEM_MENU = "/system/menu";
    public static final String SYSTEM_MENU_SAVE = "/save";
    public static final String SYSTEM_MENU_DEL = "/del";
    public static final String SYSTEM_MENU_MODIFY = "/modify";
    public static final String SYSTEM_MENU_PAGES = "/pages";


    /**
     * 权限
     **/
    public static final String PERMISSION_SYSTEM_USER_SAVE = "system:user:save";
    public static final String PERMISSION_SYSTEM_USER_DEL = "system:user:del";
    public static final String PERMISSION_SYSTEM_USER_MODIFY = "system:user:modify";

}
