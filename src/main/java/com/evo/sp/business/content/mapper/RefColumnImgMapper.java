package com.evo.sp.business.content.mapper;

import com.evo.sp.business.content.entity.RefColumnImg;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 栏目图片关联表 Mapper 接口
 * </p>
 *
 * @author sgt
 * @since 2019-05-23
 */
public interface RefColumnImgMapper extends BaseMapper<RefColumnImg> {

    /**
     *
     * 根据栏目id删除
     */
    boolean delByColumnIds(List<String> columnIds);

    /**
     *
     * 根据图片id删除
     */
    boolean delImgIds(List<String> imgIds);
}
