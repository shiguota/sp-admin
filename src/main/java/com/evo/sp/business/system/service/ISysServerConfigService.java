package com.evo.sp.business.system.service;

import com.evo.sp.business.system.entity.SysServerConfig;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
