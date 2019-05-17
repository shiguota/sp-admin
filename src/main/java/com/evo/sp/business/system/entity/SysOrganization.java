package com.evo.sp.business.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.evo.sp.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 组织机构表
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysOrganization extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 组织机构表id
     */
    @TableId(type = IdType.UUID)
    private String id;

    /**
     * 名称
     */
    private String orgName;

    /**
     * 排序字段
     */
    private Integer sort;

    /**
     * 级别
     */
    private Integer level;

    /**
     * 父id
     */
    private String pid;

    /**
     * 区域表id
     */
    private String sysAreaId;

    /**
     *
     * 简称
     */
    private String orgShort;


    public String getOrgShort() {
        return orgShort;
    }

    public void setOrgShort(String orgShort) {
        this.orgShort = orgShort;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getSysAreaId() {
        return sysAreaId;
    }

    public void setSysAreaId(String sysAreaId) {
        this.sysAreaId = sysAreaId;
    }
}
