package com.evo.sp.common.ftpfactory;

import com.evo.sp.business.system.entity.SysServerConfig;
import com.evo.sp.business.system.service.ISysServerConfigService;
import com.evo.sp.common.SpringBootBeanUtil;
import com.evo.sp.common.ex.SpAssert;
import com.evo.sp.common.ftpfactory.service.FTPFile;
import com.evo.sp.common.ftpfactory.service.impl.LocalFTPFileImpl;
import com.evo.sp.common.ftpfactory.service.impl.TXFTPFileImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 *
 * 工厂类
 */

public class FTPFactory {

    /**
     *
     * 查询数据库当前启用的FTP配置项
     */
    public FTPFile init() {
        FTPFile ftpFile = null;
        List<SysServerConfig> sysServerConfigs = SpringBootBeanUtil.getBean(ISysServerConfigService.class).queryList();
        SpAssert.isNull(sysServerConfigs);
//        switch (sysServerConfigs.get(0).getType()) {
        switch (2) {
            case 1:
                ftpFile = new TXFTPFileImpl(sysServerConfigs);
                break;
            case 2:
                ftpFile = new LocalFTPFileImpl(sysServerConfigs);
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
