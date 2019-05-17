package com.evo.sp.business.system.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evo.sp.business.system.entity.SysArea;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.evo.sp.business.system.entity.vo.SysAreaVo;

/**
 * <p>
 * 区域表 Mapper 接口
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
public interface SysAreaMapper extends BaseMapper<SysArea> {

    
    /**
     *
     * 地址列表
     */
    IPage<SysArea> queryAreaPage(Page page, SysAreaVo vo);
}
