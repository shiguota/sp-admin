package com.evo.sp.business.system.entity.vo;

import com.evo.sp.common.BaseEntity;
import com.evo.sp.common.BaseEntityVo;
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
public class SysOrganizationVo extends BaseEntityVo {

    private static final long serialVersionUID = 1L;

    /**
     * 组织机构表id
     */
    private String id;

    /**
     * 名称
     */
    private String orgName;

    /**
     * 排序字段
     */
    private Integer orgSort;

    /**
     * 级别
     */
    private Integer orgLevel;

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
     * 区域名称
     */
    private String areaName;


    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
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

    public Integer getOrgSort() {
        return orgSort;
    }

    public void setOrgSort(Integer orgSort) {
        this.orgSort = orgSort;
    }

    public Integer getOrgLevel() {
        return orgLevel;
    }

    public void setOrgLevel(Integer orgLevel) {
        this.orgLevel = orgLevel;
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

