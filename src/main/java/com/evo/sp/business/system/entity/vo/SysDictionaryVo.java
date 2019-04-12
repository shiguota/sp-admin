package com.evo.sp.business.system.entity.vo;

import com.evo.sp.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 字典表
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
public class SysDictionaryVo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 字典表id
     */
    private String id;

    /**
     * 名称
     */
    private String dicName;

    /**
     * 编码
     */
    private String dicCode;

    /**
     * 排序
     */
    private Integer dicSort;

    /**
     * 状态
     */
    private Integer state;

    /**
     * 父id
     */
    private String pid;

    /**
     * 级别
     */
    private Integer level;
    /**
     * 创建时间排序
     */
    private String CTimeOrder;
    /**
     * 修改时间排序
     */
    private String UTimeOrder;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDicName() {
        return dicName;
    }

    public void setDicName(String dicName) {
        this.dicName = dicName;
    }

    public String getDicCode() {
        return dicCode;
    }

    public void setDicCode(String dicCode) {
        this.dicCode = dicCode;
    }

    public Integer getDicSort() {
        return dicSort;
    }

    public void setDicSort(Integer dicSort) {
        this.dicSort = dicSort;
    }

    @Override
    public Integer getState() {
        return state;
    }

    @Override
    public void setState(Integer state) {
        this.state = state;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }


    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public SysDictionaryVo() {
    }

    public SysDictionaryVo(String dicName) {
        this.dicName = dicName;
    }

    public String getCTimeOrder() {
        return CTimeOrder;
    }

    public void setCTimeOrder(String CTimeOrder) {
        this.CTimeOrder = CTimeOrder;
    }

    public String getUTimeOrder() {
        return UTimeOrder;
    }

    public void setUTimeOrder(String UTimeOrder) {
        this.UTimeOrder = UTimeOrder;
    }
}
