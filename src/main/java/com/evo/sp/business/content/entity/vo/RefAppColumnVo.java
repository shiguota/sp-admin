package com.evo.sp.business.content.entity.vo;

import com.evo.sp.common.BaseEntity;
import com.evo.sp.common.BaseEntityVo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * <p>
 * 应用栏目关联表
 * </p>
 *
 * @author sgt
 * @since 2019-05-22
 */
public class RefAppColumnVo extends BaseEntityVo {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;

    /**
     * 应用id
     */
    private String apId;

    /**
     * 栏目id
     */
    private String columnId;

    /**
     *
     * id集合
     */
    private List<String> ids;

    /**
     *
     * 类型
     */
    private  Integer type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApId() {
        return apId;
    }

    public void setApId(String apId) {
        this.apId = apId;
    }

    public String getColumnId() {
        return columnId;
    }

    public void setColumnId(String columnId) {
        this.columnId = columnId;
    }

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
