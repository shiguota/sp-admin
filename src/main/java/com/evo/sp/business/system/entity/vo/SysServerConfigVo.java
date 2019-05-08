package com.evo.sp.business.system.entity.vo;

import com.evo.sp.common.BaseEntity;
import com.evo.sp.common.BaseEntityVo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author sgt
 * @since 2019-04-25
 */
public class SysServerConfigVo extends BaseEntityVo {

    private String id;

    /**
     * 服务配置key
     */
    private String serverKey;

    /**
     * 服务配置value
     */
    private String serverValue;

    /**
     * 字典表id
     */
    private String sysDictionaryId;
    
    /**
     *
     * 服务商名称
     */
    private String serverName;
    /**
     *
     * 创建时间
     */
    private Date createTime;

    /**
     *
     * 修改时间
     */
    private Date updateTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServerKey() {
        return serverKey;
    }

    public void setServerKey(String serverKey) {
        this.serverKey = serverKey;
    }

    public String getServerValue() {
        return serverValue;
    }

    public void setServerValue(String serverValue) {
        this.serverValue = serverValue;
    }

    public String getSysDictionaryId() {
        return sysDictionaryId;
    }

    public void setSysDictionaryId(String sysDictionaryId) {
        this.sysDictionaryId = sysDictionaryId;
    }
}
