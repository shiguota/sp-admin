package com.evo.sp.business.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evo.sp.business.system.entity.SysServerConfig;
import com.baomidou.mybatisplus.extension.service.IService;
import com.evo.sp.business.system.entity.vo.SysServerConfigVo;
import com.evo.sp.common.parameter.PageRequestParameter;
import com.evo.sp.common.result.Result;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author sgt
 * @since 2019-04-25
 */
public interface ISysServerConfigService extends IService<SysServerConfig> {
    /**
     * 获取当前启用的FTP服务配置项
     */
    List<SysServerConfig> queryList();


    /**
     *
     * 新增
     */
    Result saveServerConfig(SysServerConfigVo sysServerConfig);

    /**
     *
     * 启用/停止（根据字典id）
     */

    Result startServerConfig(String disId);

    /**
     *
     * 修改
     */
    Result modifyServerConfig(SysServerConfig sysServerConfig);


    /**
     *
     * 配置项列表（分页）
     */

    Result queryServerConfigPage(PageRequestParameter<SysServerConfigVo>  pageRequestParameter);


    /**
     *
     * 根据字典id查询服务配置信息
     */
    Result queryServerConfigPageByDisId(PageRequestParameter<SysServerConfig> parameter);
}
