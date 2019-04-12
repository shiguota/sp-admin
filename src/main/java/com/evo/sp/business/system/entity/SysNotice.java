package com.evo.sp.business.system.entity;

import java.time.LocalDateTime;
import com.evo.sp.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 通知表
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysNotice extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 通知表id
     */
    private String id;

    /**
     * 模板
     */
    private String template;

    /**
     * 阀值
     */
    private Integer threshold;

    /**
     * 通知类型（关联字典表id）
     */
    private String sysDictionaryId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public Integer getThreshold() {
        return threshold;
    }

    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }

    public String getSysDictionaryId() {
        return sysDictionaryId;
    }

    public void setSysDictionaryId(String sysDictionaryId) {
        this.sysDictionaryId = sysDictionaryId;
    }
}
