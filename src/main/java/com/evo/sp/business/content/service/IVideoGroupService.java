package com.evo.sp.business.content.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.evo.sp.business.content.entity.VideoGroup;
import com.baomidou.mybatisplus.extension.service.IService;
import com.evo.sp.business.content.entity.vo.VideoGroupVo;
import com.evo.sp.common.parameter.PageRequestParameter;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sgt
 * @since 2019-05-20
 */
public interface IVideoGroupService extends IService<VideoGroup> {

    /**
     *
     * 分页列表
     */
    IPage<VideoGroupVo> queryListPage(PageRequestParameter<VideoGroupVo> parameter);
}
