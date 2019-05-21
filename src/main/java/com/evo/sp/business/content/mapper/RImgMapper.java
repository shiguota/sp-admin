package com.evo.sp.business.content.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evo.sp.business.content.entity.RImg;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.evo.sp.business.content.entity.vo.RImgVo;

/**
 * <p>
 * 资源（图）表 Mapper 接口
 * </p>
 *
 * @author sgt
 * @since 2019-05-20
 */
public interface RImgMapper extends BaseMapper<RImg> {
        
    
    /**
     *
     * 列表分页
     */
    IPage<RImgVo> queryListPage(Page page,RImgVo vo);
}
