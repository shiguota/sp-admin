package com.evo.sp.business.content.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evo.sp.business.content.entity.RAudio;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.evo.sp.business.content.entity.vo.RAudioVo;

/**
 * <p>
 * 音频属性表 Mapper 接口
 * </p>
 *
 * @author sgt
 * @since 2019-05-20
 */
public interface RAudioMapper extends BaseMapper<RAudio> {

    /**
     *
     * 查询音频分页
     */
    IPage<RAudioVo> queryListPage(Page page,RAudioVo vo);
}
