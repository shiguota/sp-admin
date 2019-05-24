package com.evo.sp.business.content.mapper;

import com.evo.sp.business.content.entity.RefVideoColumn;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 视频栏目关联表 Mapper 接口
 * </p>
 *
 * @author sgt
 * @since 2019-05-22
 */
public interface RefVideoColumnMapper extends BaseMapper<RefVideoColumn> {

    /**
     *  根据视频id删除
     * 
     */
    boolean delsByvideoId(List<String> videoIds);

    /**
     * 根据栏目id删除
     *
     */
    boolean delsBycolumnId(List<String> columnIds);
}
