package com.evo.sp.business.content.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evo.sp.business.content.entity.RVideoCopyright;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.evo.sp.business.content.entity.vo.RVideoCopyrightVo;

/**
 * <p>
 * 版权信息表 Mapper 接口
 * </p>
 *
 * @author sgt
 * @since 2019-05-20
 */
public interface RVideoCopyrightMapper extends BaseMapper<RVideoCopyright> {

    /**
     *
     * 分页列表
     */
    IPage<RVideoCopyrightVo> queryListPage(Page page, RVideoCopyrightVo rVideoCopyrightVo);
}
