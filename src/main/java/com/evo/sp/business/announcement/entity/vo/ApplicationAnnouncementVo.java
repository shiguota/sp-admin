package com.evo.sp.business.announcement.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.evo.sp.common.BaseEntity;
import com.evo.sp.common.BaseEntityVo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author sgt
 * @since 2019-04-25
 */
public class ApplicationAnnouncementVo extends BaseEntityVo {

    private static final long serialVersionUID = 1L;

    /**
     * 应用公告表id
     */
    private String id;

    /**
     * 公告名
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;

    /**
     * 发布人id
     */
    private String sysUserId;

    /**
     *
     * 用户昵称
     */
    private String nickName;

    /**
     *
     * 字典名称
     */
    private String dicName;

    public ApplicationAnnouncementVo() {
    }

    public ApplicationAnnouncementVo(String cSortType) {
        this.setcSortType(cSortType);
    }
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getDicName() {
        return dicName;
    }

    public void setDicName(String dicName) {
        this.dicName = dicName;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(String sysUserId) {
        this.sysUserId = sysUserId;
    }
}
