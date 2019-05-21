package com.evo.sp.business.content.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evo.sp.business.content.entity.RVideo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.evo.sp.business.content.entity.vo.RVideoVo;

/**
 * <p>
 * 视频资源信息表 Mapper 接口
 * </p>
 *
 * @author sgt
 * @since 2019-05-20
 */
public interface RVideoMapper extends BaseMapper<RVideo> {


    /**
     *
     * 查询分页列表
     */
    IPage<RVideoVo> queryListPage(Page page,RVideoVo vo);
}
