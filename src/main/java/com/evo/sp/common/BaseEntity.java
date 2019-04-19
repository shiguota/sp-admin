package com.evo.sp.common;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.time.LocalDateTime;

public class BaseEntity implements Serializable {


    /**
     * 创建时间
     */
    @TableField(value = "create_time",update = "new()")
    @JsonFormat(pattern ="yyy-MM-dd HH:mm：ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @TableField(value = "update_time",update = "new()")
    @JsonFormat(pattern ="yyy-MM-dd HH:mm：ss", timezone = "GMT+8")
    private LocalDateTime updateTime;

    /**
     * 状态
     */
    private Integer state;


    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
