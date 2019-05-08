package com.evo.sp.common.ftpfactory.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.evo.sp.business.system.entity.SysServerConfig;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * <p>
 *
 * </p>
 *
 * @author sgt
 * @since 2019-04-25 11:13
 */
public interface FTPFile extends IService<SysServerConfig> {
    
    /**
     *
     * 上传
     */
     String upload(MultipartFile file) throws IOException;

    /**
     *
     * 下载
     */
    boolean downloads();
}
