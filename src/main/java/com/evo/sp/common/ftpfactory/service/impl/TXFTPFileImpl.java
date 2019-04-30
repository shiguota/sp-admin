package com.evo.sp.common.ftpfactory.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.evo.sp.business.system.entity.SysServerConfig;
import com.evo.sp.business.system.mapper.SysServerConfigMapper;
import com.evo.sp.common.ftpfactory.service.FTPFile;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 腾讯ftp
 * </p>
 *
 * @author sgt
 * @since 2019-04-25 11:14
 */
public class TXFTPFileImpl extends ServiceImpl<SysServerConfigMapper, SysServerConfig> implements FTPFile {

    //流的长度
    private final Integer CONTENTLENGTH = 1024;

    private String SECRETID = null;
    private String SECRETKEY = null;
    private String REGION = null;
    private String BUCKETNAME = null;

    /**
     *
     * 配置项赋值
     */
    public TXFTPFileImpl(List<SysServerConfig> list) {
        for (SysServerConfig sysServerConfig : list) {
            switch (sysServerConfig.getServerKey()) {
                case "SECRETID":
                    this.SECRETID = sysServerConfig.getServerValue();
                    break;
                case "SECRETKEY":
                    this.SECRETKEY = sysServerConfig.getServerValue();
                    break;
                case "REGION":
                    this.REGION = sysServerConfig.getServerValue();
                    break;
                case "BUCKETNAME":
                    this.BUCKETNAME = sysServerConfig.getServerValue();
                    break;
            }
        }
    }

    /**
     * 上传
     */
    @Override
    public boolean upload(MultipartFile file) throws IOException {
        String bucketName = BUCKETNAME;
        String key = UUID.randomUUID().toString();
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(CONTENTLENGTH);
        PutObjectResult putObjectResult = getClirnt().putObject(bucketName, key,file.getInputStream() , objectMetadata);
        return false;
    }

    /**
     * 下载
     */
    @Override
    public boolean downloads() {
        return false;
    }


    /**
     * 返回客户端对象
     */
    public COSClient getClirnt() {
        COSCredentials cred = new BasicCOSCredentials(SECRETID, SECRETKEY);
        ClientConfig clientConfig = new ClientConfig(new Region(REGION));
        return new COSClient(cred, clientConfig);
    }
}
