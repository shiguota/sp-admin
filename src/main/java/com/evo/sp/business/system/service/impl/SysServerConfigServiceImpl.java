package com.evo.sp.business.system.service.impl;

import com.evo.sp.business.system.entity.SysServerConfig;
import com.evo.sp.business.system.mapper.SysServerConfigMapper;
import com.evo.sp.business.system.service.ISysServerConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sgt
 * @since 2019-04-25
 */
@Service
public class SysServerConfigServiceImpl extends ServiceImpl<SysServerConfigMapper, SysServerConfig> implements ISysServerConfigService {

    @Autowired
    private SysServerConfigMapper sysServerConfigMapper;


    /**
     * 获取当前启用的FTP服务配置项
     */
    @Override
    public List<SysServerConfig> queryList() {
        return sysServerConfigMapper.queryList();
    }
}
