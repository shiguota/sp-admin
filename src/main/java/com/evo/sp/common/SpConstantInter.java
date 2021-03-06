package com.evo.sp.common;


import org.openxmlformats.schemas.wordprocessingml.x2006.main.STString;

public class SpConstantInter {
    /*******************************************全局常量**********************************/

    public static final String USER_NAME = "userName";
    public static final String USER1 = "user";
    public static final String ENCRYPTION_TYPE = "MD5";
    public static final String CHARACTER_ENCODING = "UTF-8";
    //crud操作影响的行数
    public static final Integer CURDVAL = 1;
    //排序类型
    public static final String ASC = "asc";
    public static final String DESC = "desc";


    /*******************************************数据库字段**********************************/

    public static final String TABLE_ID = "id";
    public static final String TABLE_STATE = "state";
    public static final String TABLE_CREATE_TIME = "create_time";
    public static final String TABLE_UPDATE_TIME = "update_time";
    public static final String PID = "pid";
    public static final String SORT = "sort";
    public static final String LEVEL = "level";
    public static final String SYS_DICTIONARY_ID = "sys_dictionary_id";

    //用户表
    public static final String SYS_USER_ACCOUNT = "account";
    //字典表
    public static final String SYS_DIC_NAME = "dic_name";
    //菜单表
    public static final String SYS_MENU_NAME = "menu_name";
    //区域表
    public static final String SYS_AREA_NAME = "area_name";
    //组织机构
    public static final String SYS_ORG_NAME = "org_name";
    //组织机构角色表
    public static final String SYS_ORG_ROLEID = "sys_role_id";
    //角色权限表
    public static final String SYS_ROLE_PERMISSION_ROLEID = "sys_role_id";
    //菜单权限表
    public static final String SYS_MENU_PERMISSION_MENUID = "sys_menu_id";
    //公告表
    public static final String APPLICATION_ANNOUNCEMENT_TITLE = "title";
    //权限表
    public static final String SYS_PERMISSION_CODE = "per_code";
    public static final String SYS_PERMISSION_NAME = "per_name";


    /*******************************************控制器URL**********************************/

    /**
     * 日志
     */
    public static final String SYS_LOG = "/sys/log";
    public static final String SYS_LOG_SAVE = "/save";
    public static final String SYS_LOG_DEL = "/del";
    public static final String SYS_LOG_MODIFY = "/modify";
    public static final String SYS_LOG_PAGE = "/page";
    public static final String SYS_LOG_DELS = "/dels";

    /**
     * 字典
     */
    public static final String SYS_DICTIONNARY = "/sys/dictionary";
    public static final String SYS_DICTIONNARY_SAVE = "/save";
    public static final String SYS_DICTIONNARY_DEL = "/del";
    public static final String SYS_DICTIONNARY_MODIFY = "/modify";
    public static final String SYS_DICTIONNARY_LEVEL = "/level";
    public static final String SYS_DICTIONNARY_QUERY_PAGE = "/page";
    public static final String SYS_DICTIONNARY_QUERY_BY_CODE = "/code";
    public static final String SYS_DICTIONNARY_QUERY_BY_ID = "/id";
    public static final String SYS_DICTIONNARY_QUERY_BY_PID = "/pid";

    /**
     * 用户
     */
    public static final String SYS_USER = "/sys/user";
    public static final String SYS_USER_SAVE = "/save";
    public static final String SYS_USER_LOGIN = "/login";
    public static final String SYS_USER_LOGIN_OUT = "/loginout";
    public static final String SYS_USER_DEL = "/del";
    public static final String SYS_USER_MODIFY = "/modify";
    public static final String SYS_USER_PAGE = "/page";
    public static final String SYS_USER_QUERY_ONE = "/one";
    public static final String SYS_USER_QUERY_ROLE = "role";
    public static final String SYS_USER_QUERY_UNROLE = "unrole";

    /**
     * 用户信息
     */
    public static final String SYS_USER_INFO = "/sys/user/info";
    public static final String SYS_USER_INFO_SAVE = "/save";
    public static final String SYS_USER_INFO_DEL = "/del";
    public static final String SYS_USER_INFO_MODIFY = "/modify";
    public static final String SYS_USER_INFO_ID = "/id";

    /**
     * 用户角色
     */
    public static final String SYS_USER_ROLE = "/sys/user/role";
    public static final String SYS_USER_ROLE_SAVE = "/save";
    public static final String SYS_USER_ROLE_DEL = "/del";

    /**
     * 角色
     */
    public static final String SYS_ROLE = "/sys/role";
    public static final String SYS_ROLE_SAVE = "/save";
    public static final String SYS_ROLE_DEL = "/del";
    public static final String SYS_ROLE_MODIFY = "/modify";
    public static final String SYS_ROLE_PAGE = "/page";
    public static final String SYS_ROLE_AUTHORIZATION = "/authorization";

    /**
     * 权限
     */
    public static final String SYS_PERMISSION = "/sys/permission";
    public static final String SYS_PERMISSION_SAVE = "/save";
    public static final String SYS_PERMISSION_DEL = "/del";
    public static final String SYS_PERMISSION_MODIFY = "/modify";
    public static final String SYS_PERMISSION_PAGE = "/page";
    public static final String SYS_PERMISSION_ROLE = "/role";
    public static final String SYS_PERMISSION_MENU = "/menu";
    public static final String SYS_PERMISSION_MENU_USER = "/menu/user";
    public static final String SYS_PERMISSION_MENU_USER_DIF_SET = "/menu/user/difset";

    /**
     * 角色权限
     */
    public static final String SYS_ROLE_PERMISSION = "/sys/role/permission";
    public static final String SYS_ROLE_PERMISSION_SAVE = "/save";
    public static final String SYS_ROLE_PERMISSION_DEL = "/del";
    public static final String SYS_ROLE_PERMISSION_MODIFY = "/mpdify";
    public static final String SYS_ROLE_PERMISSION_AUTH = "/auth";

    /**
     * 菜单
     */
    public static final String SYS_MENU = "/sys/menu";
    public static final String SYS_MENU_SAVE = "/save";
    public static final String SYS_MENU_DEL = "/del";
    public static final String SYS_MENU_MODIFY = "/modify";
    public static final String SYS_MENU_PAGE = "/page";
    public static final String SYS_MENU_TREE = "/tree";
    public static final String SYS_MENU_PATH = "/path";
    public static final String SYS_MENU_PER = "/per";
    public static final String SYS_MENU_PID = "/pid";
    public static final String SYS_MENU_ID = "/id";

    /**
     * 菜单权限
     */
    public static final String SYS_MENU_PERMISSION = "/sys/menu/permission";
    public static final String SYS_MENU_PERMISSION_SAVE = "/save";
    public static final String SYS_MENU_PERMISSION_DEL = "/del";
    public static final String SYS_MENU_PERMISSION_MPODIFY = "/modify";
    public static final String SYS_MENU_PERMISSION_TREE = "/tree";
    public static final String SYS_MENU_PERMISSION_BAN_SAVE = "/ban/save";

    /**
     * 区域
     */
    public static final String SYS_AREA = "/sys/arae";
    public static final String SYS_AREA_SAVE = "/save";
    public static final String SYS_AREA_DEL = "/del";
    public static final String SYS_AREA_NODIFY = "/modify";
    public static final String SYS_AREA_TREE = "tree";
    public static final String SYS_AREA_QUERY = "query";
    public static final String SYS_AREA_PAGE = "page";
    public static final String SYS_AREA_ID = "id";
    public static final String SYS_AREA_PID = "pid";

    /**
     * 通知
     */
    public static final String SYS_NOTICE = "/sys/notice";
    public static final String SYS_NOTICE_SAVE = "/save";
    public static final String SYS_NOTICE_DEL = "/del";
    public static final String SYS_NOTICE_MODIFY = "/modify";

    /**
     * 组织（机构）
     */
    public static final String SYS_ORGANIZATION = "/sys/organization";
    public static final String SYS_ORGANIZATION_SAVE = "/save";
    public static final String SYS_ORGANIZATION_DEL = "/del";
    public static final String SYS_ORGANIZATION_MODIFY = "/modify";
    public static final String SYS_ORGANIZATION_PAGE = "/page";
    public static final String SYS_ORGANIZATION_TREE = "/tree";

    /**
     * 组织（机构）角色
     */
    public static final String SYS_ORGANIZATION_ROLE = "/system/organization/role";

    /**
     * 公告
     */
    public static final String APPLICATION_ANNOUNCEMENT = "/application/announcement";
    public static final String APPLICATION_ANNOUNCEMENT_SAVE = "/save";
    public static final String APPLICATION_ANNOUNCEMENT_MODIFY = "/modify";
    public static final String APPLICATION_ANNOUNCEMENT_DEL = "/del";
    public static final String APPLICATION_ANNOUNCEMENT_PAGE = "/page";
    public static final String APPLICATION_ANNOUNCEMENT_ID = "/id";
    /**
     * 服务配置
     */
    public static final String APPLICATION_SERVER_CONFIG = "/server/config";
    public static final String APPLICATION_SERVER_CONFIG_UPLOAD = "/upload";
    public static final String APPLICATION_SERVER_CONFIG_SAVE = "/save";
    public static final String APPLICATION_SERVER_CONFIG_MODIFT = "/modify";
    public static final String APPLICATION_SERVER_CONFIG_START_END = "/start/or/end";
    public static final String APPLICATION_SERVER_CONFIG_QUERY_BY_ID = "querybyid";
    public static final String APPLICATION_SERVER_CONFIG_DELS = "dels";
    public static final String APPLICATION_SERVER_CONFIG_PAGE = "page";
    public static final String APPLICATION_SERVER_CONFIG_PAGE_DIS = "page/dis";
    /**
     * 绘本
     */
    public static final String CONTENT_BOOK = "/content/book";
    public static final String CONTENT_BOOK_SAVE = "/save";
    public static final String CONTENT_BOOK_DEL = "/del";
    public static final String CONTENT_BOOK_MODIFY = "/modify";
    public static final String CONTENT_BOOK_PAGE = "/page";
    public static final String CONTENT_BOOK_ID = "/id";
    /**
     *
     * 视频
     */
    public static final String CONTENT_VIDEO = "/content.video";
    public static final String CONTENT_VIDEO_SAVE = "/save";
    public static final String CONTENT_VIDEO_DEL = "/del";
    public static final String CONTENT_VIDEO_MODIFY = "/modify";
    public static final String CONTENT_VIDEO_PAGE = "/page";
    public static final String CONTENT_VIDEO_ID = "/id";
    /**
     *
     * 音频接口
     */
    public static final String RESOURCE_AUDIO = "/resource/audio";
    public static final String RESOURCE_AUDIO_SAVE = "/save";
    public static final String RESOURCE_AUDIO_DEL = "/del";
    public static final String RESOURCE_AUDIO_MODIFY = "/modify";
    public static final String RESOURCE_AUDIO_PAGE = "/page";
    public static final String RESOURCE_AUDIO_ID = "/id";
    
    /**
     *
     * 人物表
     */
    public static final String RESOURCE_FIGURE = "/resource/figure";
    public static final String RESOURCE_FIGURE_SAVE = "/save";
    public static final String RESOURCE_FIGURE_DEL = "/del";
    public static final String RESOURCE_FIGURE_MODIFY = "/modify";
    public static final String RESOURCE_FIGURE_PAGE = "/page";
    public static final String RESOURCE_FIGURE_ID = "/id";
    /**
     *
     * 图片资源
     */
    public static final String RESOURCE_IMG = "/resource/img";
    public static final String RESOURCE_IMG_SAVE = "/save";
    public static final String RESOURCE_IMG_DEL = "/del";
    public static final String RESOURCE_IMG_MODIFY = "/modify";
    public static final String RESOURCE_IMG_PAGE = "/page";
    public static final String RESOURCE_IMG_ID = "/id";
    
    /**
     *
     * 标签
     */
    public static final String RESOURCE_VIDEO = "/resource/video";
    public static final String RESOURCE_VIDEO_SAVE = "/save";
    public static final String RESOURCE_VIDEO_DEL = "/del";
    public static final String RESOURCE_VIDEO_MODIFY = "/modify";
    public static final String RESOURCE_VIDEO_PAGE = "/page";
    public static final String RESOURCE_VIDEO_ID = "/id";
    
    /**
     *
     * 版权信息
     */
    public static final String RESOURCE_RVIDEO_COPYRIGHT ="/resource/copyright";
    public static final String RESOURCE_RVIDEO_COPYRIGHT_SAVE ="/save";
    public static final String RESOURCE_RVIDEO_COPYRIGHT_DEL ="/del";
    public static final String RESOURCE_RVIDEO_COPYRIGHT_MODIFY ="/modify";
    public static final String RESOURCE_RVIDEO_COPYRIGHT_PAGE ="/page";
    public static final String RESOURCE_RVIDEO_COPYRIGHT_ID ="/id";

    /**
     *
     * 视频组
     */
    public static final String RESOURCE_VIDEO_GROUP = "/video/group";
    public static final String RESOURCE_VIDEO_GROUP_SAVE = "/save";
    public static final String RESOURCE_VIDEO_GROUP_DEL = "/del";
    public static final String RESOURCE_VIDEO_GROUP_MODIFY = "/modify";
    public static final String RESOURCE_VIDEO_GROUP_PAGE = "/page";
    public static final String RESOURCE_VIDEO_GROUP_ID = "/id";
    /**
     *
     * 栏目
     */
    public static final String CONTENT_COLUMN = "/content/column";
    public static final String CONTENT_COLUMN_SAVE = "/save";
    public static final String CONTENT_COLUMN_DEL = "/del";
    public static final String CONTENT_COLUMN_MODIFY = "/modify";
    public static final String CONTENT_COLUMN_PAGE = "/page";
    public static final String CONTENT_COLUMN_ID = "/id";
    public static final String CONTENT_COLUMN_TREE = "/tree";

    /**
     *
     * 应用
     */
    public static final String RESOURCE_APP = "/resource/app";
    public static final String RESOURCE_APP_SAVE = "/save";
    public static final String RESOURCE_APP_DEL = "/del";
    public static final String RESOURCE_APP_MODIFY = "/modify";
    public static final String RESOURCE_APP_PAGE = "/page";
    public static final String RESOURCE_APP_ID = "/id";
    public static final String RESOURCE_APP_TREE = "/tree";

    /*
     *
     * 视频栏目
     */
    public static final String REF_VIDEO_COLUMN = "/ref/video/column";
    public static final String REF_VIDEO_COLUMN_SAVE = "/save";
    public static final String REF_VIDEO_COLUMN_DEL = "/del";
    public static final String REF_VIDEO_COLUMN_MODIFY = "/modify";
    public static final String REF_VIDEO_COLUMN_PAGE = "/page";
    
    
    /**
     *
     * 绘本栏目
     */
    public static final String REF_BOOK_COLUMN = "/ref/book/column";
    public static final String REF_BOOK_COLUMN_SAVE = "/save";
    public static final String REF_BOOK_COLUMN_DEL = "/del";
    
    /**
     *
     * 应用和栏目
     */
    public static final String REF_APP_COLUMN = "/ref/app/column";
    public static final String REF_APP_COLUMN_SAVE = "/save";
    public static final String REF_APP_COLUMN_DEL = "/del";
    
    /**
     *
     * 应用图片
     */
    public static final String REF_APP_IMG = "/ref/app/img";
    public static final String REF_APP_IMG_SAVE = "/save";
    public static final String REF_APP_IMG_DEL = "/del";

    /**
     *
     * 栏目图片
     */
    public static final String REF_COLUMN_IMG ="/ref/column/img";
    public static final String REF_COLUMN_IMG_SAVE ="/save";
    public static final String REF_COLUMN_IMG_DEL ="/del";


    /*******************************************权限编码**********************************/

    public static final String PERMISSION_SYS_USER_SAVE = "sys:user:save";
    public static final String PERMISSION_SYS_USER_DEL = "sys:user:del";
    public static final String PERMISSION_SYS_USER_MODIFY = "sys:user:modify";

}
