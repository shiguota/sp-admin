package com.evo.sp.business.content.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evo.sp.business.content.entity.CColumn;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.evo.sp.business.content.entity.vo.CColumnVo;

import java.util.List;

/**
 * <p>
 * 栏目表 Mapper 接口
 * </p>
 *
 * @author sgt
 * @since 2019-05-22
 */
public interface CColumnMapper extends BaseMapper<CColumn> {

    /**
     *
     * 分页列表
     */
    IPage<CColumnVo> queryListPage(Page pageInstance, CColumnVo cColumnVo);

}
