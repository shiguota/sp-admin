package com.evo.sp.business.announcement.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evo.sp.business.announcement.entity.ApplicationAnnouncement;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.evo.sp.business.announcement.entity.vo.ApplicationAnnouncementVo;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author sgt
 * @since 2019-04-25
 */
public interface ApplicationAnnouncementMapper extends BaseMapper<ApplicationAnnouncement> {

    IPage<ApplicationAnnouncementVo> queryAnnouncementPage(Page page,ApplicationAnnouncementVo announcement);
}
