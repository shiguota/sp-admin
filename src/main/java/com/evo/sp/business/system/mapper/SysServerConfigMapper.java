package com.evo.sp.business.system.mapper;

import com.evo.sp.business.system.entity.SysServerConfig;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author sgt
 * @since 2019-04-25
 */
public interface SysServerConfigMapper extends BaseMapper<SysServerConfig> {
    /**
     * 获取当前启用的FTP服务配置项
     */
    List<SysServerConfig> queryList();
}
