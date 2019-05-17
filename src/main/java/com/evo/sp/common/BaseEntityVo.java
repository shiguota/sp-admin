package com.evo.sp.common;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class BaseEntityVo implements Serializable {

    /**
     * 创建时间排序
     */
    private String cSortType;

    /**
     * 修改时间排序
     */
    private String uSortType;

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

    public String getcSortType() {
        return cSortType;
    }

    public void setcSortType(String cSortType) {
        this.cSortType = cSortType;
    }

    public String getuSortType() {
        return uSortType;
    }

    public void setuSortType(String uSortType) {
        this.uSortType = uSortType;
    }

    public void setUSortType(String USortType) {
        this.cSortType = USortType;
    }
}
