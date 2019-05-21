package com.evo.sp.business.content.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.evo.sp.business.content.entity.VideoGroup;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.evo.sp.business.content.entity.vo.VideoGroupVo;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author sgt
 * @since 2019-05-20
 */
public interface VideoGroupMapper extends BaseMapper<VideoGroup> {

    /**
     *
     * 分页列表
     */
    IPage<VideoGroupVo> queryListPage(VideoGroupVo videoGroupVo);
}
