package com.evo.sp.business.content.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evo.sp.business.content.entity.CVideo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.evo.sp.business.content.entity.vo.CVideoVo;

/**
 * <p>
 * 视频内容基础信息表 Mapper 接口
 * </p>
 *
 * @author sgt
 * @since 2019-05-20
 */
public interface CVideoMapper extends BaseMapper<CVideo> {


    IPage<CVideoVo> queryListPage(Page page,CVideoVo vo);
}
