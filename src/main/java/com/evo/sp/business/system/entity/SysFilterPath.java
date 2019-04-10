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
 * @since 2019-04-05
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysFilterPath extends BaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 过滤的路径
     */
    private String path;

    /**
     * 过滤类型（基于shiro）
     */
    private String type;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
