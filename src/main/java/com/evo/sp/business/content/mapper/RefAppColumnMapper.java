package com.evo.sp.business.content.mapper;

import com.evo.sp.business.content.entity.RefAppColumn;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 应用栏目关联表 Mapper 接口
 * </p>
 *
 * @author sgt
 * @since 2019-05-22
 */
public interface RefAppColumnMapper extends BaseMapper<RefAppColumn> {
    
    /**
     *
     *  根据栏目id删除
     */
    boolean delsBycolumnId(List<String> columnIds);

    /**
     *
     * 根据应用id删除
     */
    boolean delsByAppId(List<String> appIds);
}
