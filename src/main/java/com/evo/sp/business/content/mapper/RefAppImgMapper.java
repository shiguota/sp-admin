package com.evo.sp.business.content.mapper;

import com.evo.sp.business.content.entity.RefAppImg;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 应用图片关联表 Mapper 接口
 * </p>
 *
 * @author sgt
 * @since 2019-05-22
 */
public interface RefAppImgMapper extends BaseMapper<RefAppImg> {

    /**
     *
     * 根据应用id删除
     */
    boolean delByAppId(List<String> appIds);

    /**
     *
     * 根据img id删除
     */
    boolean delByImgId(List<String> imgIds);
}
