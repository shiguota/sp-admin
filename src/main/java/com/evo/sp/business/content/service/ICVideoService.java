package com.evo.sp.business.content.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.evo.sp.business.content.entity.CVideo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.evo.sp.business.content.entity.vo.CVideoVo;
import com.evo.sp.common.parameter.PageRequestParameter;

/**
 * <p>
 * 视频内容基础信息表 服务类
 * </p>
 *
 * @author sgt
 * @since 2019-05-20
 */
public interface ICVideoService extends IService<CVideo> {

    /**
     *
     * 视频分页查询
     */
    IPage<CVideoVo> queryListPage(PageRequestParameter<CVideoVo> parameter);
}
