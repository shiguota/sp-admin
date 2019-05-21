package com.evo.sp.business.content.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evo.sp.business.content.entity.VideoGroup;
import com.evo.sp.business.content.entity.vo.VideoGroupVo;
import com.evo.sp.business.content.mapper.VideoGroupMapper;
import com.evo.sp.business.content.service.IVideoGroupService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.evo.sp.common.ex.SpAssert;
import com.evo.sp.common.parameter.PageRequestParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sgt
 * @since 2019-05-20
 */
@Service
public class VideoGroupServiceImpl extends ServiceImpl<VideoGroupMapper, VideoGroup> implements IVideoGroupService {

    @Autowired
    private VideoGroupMapper videoGroupMapper;
    /**
     * 分页列表
     *
     * @param parameter
     */
    @Override
    public IPage<VideoGroupVo> queryListPage(PageRequestParameter<VideoGroupVo> parameter) {
        //检验参数
        SpAssert.isNull(parameter);
        SpAssert.isNull(parameter.pageInstance());
        VideoGroupVo videoGroupVo = parameter.parameterInstance();
        SpAssert.setSort(videoGroupVo);
        return videoGroupMapper.queryListPage(videoGroupVo);
    }
}
