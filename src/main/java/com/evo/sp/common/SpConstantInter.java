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
    //crud操作影响的行数
    public static final Integer CURDVAL = 1;


    /**
     * 数据库字段
     */
    public static final String TABLE_ID = "id";
    public static final String TABLE_STATE = "state";
    public static final String PID = "pid";
    //用户表
    public static final String SYS_USER_NAME = "name";
    //字典表
    public static final String SYS_DIC_NAME = "dic_name";
    //菜单表
    public static final String SYS_MENU_NAME = "menu_name";
    //区域表
    public static final String SYS_AREA_NAME = "area_name";
    //组织机构
    public static final String SYS_ORG_NAME = "org_name";


    /**
     * URL
     */
    //日志
    public static final String SYS_LOG="/sys/log";
    public static final String SYS_LOG_SAVE="/save";
    public static final String SYS_LOG_DEL="/del";
    public static final String SYS_LOG_MODIFY="/modify";
    public static final String SYS_LOG_PAGE="/page";
    public static final String SYS_LOG_DELS = "/dels";
    //字典
    public static final String SYS_DICTIONNARY="/sys/dictionary";
    public static final String SYS_DICTIONNARY_SAVE = "/save";
    public static final String SYS_DICTIONNARY_DEL = "/del";
    public static final String SYS_DICTIONNARY_MODIFY = "/modify";
    public static final String SYS_DICTIONNARY_PAGE = "/page";
    public static final String SYS_DICTIONNARY_QUERY_BY_NAME ="/byname";
    //用户
    public static final String SYS_USER = "/sys/user";
    public static final String SYS_USER_SAVE = "/save";
    public static final String SYS_USER_LOGIN = "/login";
    public static final String SYS_USER_LOGIN_OUT = "/loginout";
    public static final String SYS_USER_DEL = "/del";
    public static final String SYS_USER_MODIFY = "/modify";
    public static final String SYS_USER_PAGE = "/page";
    public static final String SYS_USER_QUERY_ONE = "/one";
    //用户信息
    public static final String SYS_USER_INFO="/sys/user/info";
    public static final String SYS_USER_INFO_SAVE="/save";
    public static final String SYS_USER_INFO_DEL="/del";
    public static final String SYS_USER_INFO_MODIFY="/modify";
    //权限
    public static final  String SYS_PERMISSION ="/sys/permission";
    public static final  String SYS_PERMISSION_SAVE ="/save";
    public static final  String SYS_PERMISSION_DEL ="/del";
    public static final  String SYS_PERMISSION_MODIFY ="/modify";
    public static final  String SYS_PERMISSION_PAGE ="/page";
    //角色
    public static final  String SYS_ROLE ="/sys/role";
    public static final  String SYS_ROLE_SAVE ="/save";
    public static final  String SYS_ROLE_DEL ="/del";
    public static final  String SYS_ROLE_MODIFY ="/modify";
    public static final  String SYS_ROLE_PAGE ="/page";
    //角色权限
    public static final String SYS_ROLE_PERMISSION ="/sys/role/permission";
    public static final String SYS_ROLE_PERMISSION_SAVE ="/save";
    public static final String SYS_ROLE_PERMISSION_DEL ="/del";
    public static final String SYS_ROLE_PERMISSION_MODIFY ="/mpdify";
    public static final String SYS_ROLE_PERMISSION_AUTH="/auth";
    //菜单
    public static final String SYS_MENU = "/sys/menu";
    public static final String SYS_MENU_SAVE = "/save";
    public static final String SYS_MENU_DEL = "/del";
    public static final String SYS_MENU_MODIFY = "/modify";
    public static final String SYS_MENU_PAGE = "/page";
    public static final String SYS_MENU_TREE ="/tree";
    public static final String SYS_MENU_PATH = "/path";
    public static final String SYS_MENU_PER = "/per";
    //菜单权限
    public static final String SYS_MENU_PERMISSION = "/sys/menu/permission";
    public static final String SYS_MENU_PERMISSION_SAVE = "/save";
    public static final String SYS_MENU_PERMISSION_DEL = "/del";
    public static final String SYS_MENU_PERMISSION_MPODIFY = "/modify";
    //区域
    public static final String SYS_AREA="/sys/arae";
    public static final String SYS_AREA_SAVE="/save";
    public static final String SYS_AREA_DEL="/del";
    public static final String SYS_AREA_NODIFY="/modify";
    public static final String SYS_AREA_TREE = "tree";
    public static final String SYS_AREA_QUERY = "query";
    public static final String SYS_AREA_PAGE = "page";
    //通知
    public static final String SYS_NOTICE="/sys/notice";
    public static final String SYS_NOTICE_SAVE="/save";
    public static final String SYS_NOTICE_DEL="/del";
    public static final String SYS_NOTICE_MODIFY="/modify";
    //组织（机构）
    public static final String SYS_ORGANIZATION = "/sys/organization";
    public static final String SYS_ORGANIZATION_SAVE = "/save";
    public static final String SYS_ORGANIZATION_DEL = "/del";
    public static final String SYS_ORGANIZATION_MODIFY = "/modify";
    public static final String SYS_ORGANIZATION_PAGE = "/page";
    public static final String SYS_ORGANIZATION_TREE = "/tree";
    //组织（机构）角色
    public static final String SYS_ORGANIZATION_ROLE="/system/organization/role";


    /**
     * 权限
     **/
    public static final String PERMISSION_SYS_USER_SAVE = "sys:user:save";
    public static final String PERMISSION_SYS_USER_DEL = "sys:user:del";
    public static final String PERMISSION_SYS_USER_MODIFY = "sys:user:modify";

}
