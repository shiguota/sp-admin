package com.evo.sp.business.content.mapper;

import com.evo.sp.business.content.entity.RefBookColumn;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 栏目绘本关联表 Mapper 接口
 * </p>
 *
 * @author sgt
 * @since 2019-05-22
 */
public interface RefBookColumnMapper extends BaseMapper<RefBookColumn> {

    /**
     *
     * 根据绘本id删除
     */
    boolean delsByBookId(List<String> bookIds);
    /**
     *
     * 根据栏目id删除
     */
    boolean delsBycolumnId(List<String> columnIds);
}
