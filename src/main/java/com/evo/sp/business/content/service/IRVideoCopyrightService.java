package com.evo.sp.business.content.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.evo.sp.business.content.entity.RVideoCopyright;
import com.baomidou.mybatisplus.extension.service.IService;
import com.evo.sp.business.content.entity.vo.RVideoCopyrightVo;
import com.evo.sp.common.parameter.PageRequestParameter;
import com.evo.sp.common.result.Result;

/**
 * <p>
 * 版权信息表 服务类
 * </p>
 *
 * @author sgt
 * @since 2019-05-20
 */
public interface IRVideoCopyrightService extends IService<RVideoCopyright> {

    /**
     * 分页列表
     */
    IPage<RVideoCopyrightVo> queryListPage(PageRequestParameter<RVideoCopyrightVo> parameter);
}
