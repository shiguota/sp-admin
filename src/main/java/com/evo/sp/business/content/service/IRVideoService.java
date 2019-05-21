package com.evo.sp.business.content.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.evo.sp.business.content.entity.RVideo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.evo.sp.business.content.entity.vo.RVideoVo;
import com.evo.sp.common.parameter.PageRequestParameter;
import com.evo.sp.common.result.Result;

/**
 * <p>
 * 视频资源信息表 服务类
 * </p>
 *
 * @author sgt
 * @since 2019-05-20
 */
public interface IRVideoService extends IService<RVideo> {


    /**
     *
     *
     */
   IPage<RVideoVo> queryListPage(PageRequestParameter<RVideoVo> parameter);
}
