package com.evo.sp.business.system.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.evo.sp.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 字典表
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysDictionary extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 字典表id
     */
    @TableId(type = IdType.UUID)
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
     * 父id
     */
    private String pid;

    /**
     * 级别
     */
    private Integer level;


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

    public SysDictionary() {
    }

    public SysDictionary(String dicName) {
        this.dicName = dicName;
    }
}
