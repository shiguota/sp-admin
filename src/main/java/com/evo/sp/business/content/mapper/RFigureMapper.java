package com.evo.sp.business.content.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evo.sp.business.content.entity.RFigure;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.evo.sp.business.content.entity.vo.RFigureVo;

/**
 * <p>
 * 人物表 Mapper 接口
 * </p>
 *
 * @author sgt
 * @since 2019-05-20
 */
public interface RFigureMapper extends BaseMapper<RFigure> {
    
    
    /**
     *
     * 查询人物分页
     */
    IPage<RFigureVo> queryListPage(Page page,RFigureVo vo);
}
