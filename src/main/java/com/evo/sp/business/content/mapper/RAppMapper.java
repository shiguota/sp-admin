package com.evo.sp.business.content.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evo.sp.business.content.entity.RApp;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.evo.sp.business.content.entity.vo.RAppVo;

/**
 * <p>
 * 应用表 Mapper 接口
 * </p>
 *
 * @author sgt
 * @since 2019-05-22
 */
public interface RAppMapper extends BaseMapper<RApp> {

    /**
     *
     * 列表分页
     */
    IPage<RAppVo> queryListPage(Page page, RAppVo rAppVo);
}
