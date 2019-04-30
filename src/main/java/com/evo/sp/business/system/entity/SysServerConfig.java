package com.evo.sp.business.system.entity;

import java.time.LocalDateTime;
import com.evo.sp.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author sgt
 * @since 2019-04-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysServerConfig extends BaseEntity {

    private static final long serialVersionUID = 1L;

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
     * FTP服务商分类
     */
    private Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
