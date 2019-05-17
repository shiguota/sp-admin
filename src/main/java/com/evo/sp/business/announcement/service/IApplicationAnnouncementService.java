package com.evo.sp.business.announcement.service;

import com.evo.sp.business.announcement.entity.ApplicationAnnouncement;
import com.baomidou.mybatisplus.extension.service.IService;
import com.evo.sp.business.announcement.entity.vo.ApplicationAnnouncementVo;
import com.evo.sp.business.announcement.mapper.ApplicationAnnouncementMapper;
import com.evo.sp.common.parameter.PageRequestParameter;
import com.evo.sp.common.result.Result;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sgt
 * @since 2019-04-25
 */
public interface IApplicationAnnouncementService extends IService<ApplicationAnnouncement> {

    /**
     *
     * 查询公告
     */
    Result queryAnnouncementPage(PageRequestParameter<ApplicationAnnouncementVo> pageRequestParameter);
}
