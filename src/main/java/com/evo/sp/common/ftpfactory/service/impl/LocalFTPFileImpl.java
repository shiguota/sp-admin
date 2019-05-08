package com.evo.sp.common.ftpfactory.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.evo.sp.business.system.entity.SysServerConfig;
import com.evo.sp.business.system.mapper.SysServerConfigMapper;
import com.evo.sp.common.ex.SpAssert;
import com.evo.sp.common.ex.UploadException;
import com.evo.sp.common.ftpfactory.service.FTPFile;
import com.evo.sp.common.result.ResultEnum;
import org.bouncycastle.asn1.ocsp.ResponseData;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * <p>
 * 本地上传
 * </p>
 *
 * @author sgt
 * @since 2019-05-05 14:07
 */
public class LocalFTPFileImpl extends ServiceImpl<SysServerConfigMapper, SysServerConfig> implements FTPFile {


    private static String UPLOAD_PATH = null;

    /**
     * 设置配置项
     */
    public LocalFTPFileImpl(List<SysServerConfig> list) {
        SpAssert.isNull(list);
        for (SysServerConfig sysServerConfig : list) {
            switch (sysServerConfig.getServerKey()) {
                case "UPLOAD_PATH":
                    UPLOAD_PATH = sysServerConfig.getServerValue();
                    break;
            }
        }
    }

    /**
     * 上传
     *
     * @param multipartFile
     */
    @Override
    public String upload(MultipartFile multipartFile) throws IOException {
        //获取根目录
        String PATH = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
        //获取文件名
        String fileName = multipartFile.getOriginalFilename();
        //构建上传路径
        String filePath = PATH + UPLOAD_PATH;
        File file = new File(filePath);
        //判断当前文件夹是否存在，如果不存在则创建
        if (file.exists()) {
            if (!file.isDirectory()) {
                //同名文件存在，但并非目录，无法创建
                throw new UploadException(ResultEnum.FILE_NAME_EXISTS.getValue(), ResultEnum.FILE_NAME_EXISTS.getName());
            }
        } else {
            //创建
            file.mkdir();
        }
        return Files.write(Paths.get(filePath + fileName), multipartFile.getBytes()).toString();
    }

    /**
     * 下载
     */
    @Override
    public boolean downloads() {
        return false;
    }

}
