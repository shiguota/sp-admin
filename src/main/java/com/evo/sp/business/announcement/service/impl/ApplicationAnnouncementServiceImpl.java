package com.evo.sp.business.announcement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evo.sp.business.announcement.entity.ApplicationAnnouncement;
import com.evo.sp.business.announcement.mapper.ApplicationAnnouncementMapper;
import com.evo.sp.business.announcement.service.IApplicationAnnouncementService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.ex.SpAssert;
import com.evo.sp.common.parameter.PageRequestParameter;
import com.evo.sp.common.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author sgt
 * @since 2019-04-25
 */
@Service
public class ApplicationAnnouncementServiceImpl extends ServiceImpl<ApplicationAnnouncementMapper, ApplicationAnnouncement> implements IApplicationAnnouncementService {


    @Autowired
    private ApplicationAnnouncementMapper mapper;

    /**
     * 查询公告（分页）
     *
     * @param pageRequestParameter
     */
    @Override
    public Result queryAnnouncementPage(PageRequestParameter<ApplicationAnnouncement> pageRequestParameter) {
        Result result = null;
        //校验参数
        SpAssert.isNull(pageRequestParameter);
        Page page = pageRequestParameter.pageInstance();
        SpAssert.isNull(page);
        ApplicationAnnouncement applicationAnnouncement = pageRequestParameter.parameterInstance();
        if (SpAssert.isNotNull(applicationAnnouncement)) {//带条件查询分页
            QueryWrapper<ApplicationAnnouncement> wrapper = new QueryWrapper<>();
            wrapper.like(SpConstantInter.APPLICATION_ANNOUNCEMENT_TITLE,applicationAnnouncement.getTitle());
            result = new Result(page(page, wrapper));
        }else { //无条件查询分页
            result = new Result(page(page));
        }
        return result;
    }
}
