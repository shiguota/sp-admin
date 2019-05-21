package com.evo.sp.business.content.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evo.sp.business.content.entity.CBook;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.evo.sp.business.content.entity.vo.CBookVo;

/**
 * <p>
 * 绘本表 Mapper 接口
 * </p>
 *
 * @author sgt
 * @since 2019-05-20
 */
public interface CBookMapper extends BaseMapper<CBook> {
    /**
     *
     * 分页查询
     */
    IPage<CBookVo> queryListPage(Page page, CBookVo cBookVo);
}
