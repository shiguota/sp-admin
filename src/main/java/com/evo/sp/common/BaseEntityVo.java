package com.evo.sp.common;

import java.io.Serializable;
import java.time.LocalDateTime;

public class BaseEntityVo implements Serializable {


    /**
     * 创建时间排序
     */
    private String CSortType;
    /**
     * 修改时间排序
     */
    private String USortType;

    public String getCSortType() {
        this.CSortType  = CSortType == null ? SpConstantInter.DESC : CSortType;
        return CSortType;
    }

    public void setCSortType(String CSortType) {
        this.CSortType = CSortType;
    }

    public String getUSortType() {
        this.USortType  = USortType == null ? SpConstantInter.DESC : USortType;
        return USortType;
    }

    public void setUSortType(String USortType) {
        this.USortType = USortType;
    }
}
