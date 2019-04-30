package com.evo.sp.common.ftpfactory;

import com.evo.sp.business.system.entity.SysServerConfig;
import com.evo.sp.business.system.service.ISysServerConfigService;
import com.evo.sp.common.ex.SpAssert;
import com.evo.sp.common.ftpfactory.service.FTPFile;
import com.evo.sp.common.ftpfactory.service.impl.TXFTPFileImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * 工厂类
 */
public class FTPFactory {

    @Autowired
    private ISysServerConfigService iSysServerConfigService;

    /**
     *
     * 查询数据库当前启用的FTP配置项
     */
    public FTPFile init() {
        FTPFile ftpFile = null;
        List<SysServerConfig> sysServerConfigs = iSysServerConfigService.queryList();
        SpAssert.isNull(sysServerConfigs);
        switch (sysServerConfigs.get(0).getType()) {
            case 1:
                ftpFile = new TXFTPFileImpl(sysServerConfigs);
                break;
        }
        return ftpFile;
    }

    /**
     *
     * 返回实例
     */
    public static FTPFile getInstance() {
        return new FTPFactory().init();
    }

}
