package com.evo.sp.business.content.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.evo.sp.business.content.entity.RAudio;
import com.baomidou.mybatisplus.extension.service.IService;
import com.evo.sp.business.content.entity.vo.RAudioVo;
import com.evo.sp.common.parameter.PageRequestParameter;

/**
 * <p>
 * 音频属性表 服务类
 * </p>
 *
 * @author sgt
 * @since 2019-05-20
 */
public interface IRAudioService extends IService<RAudio> {
    /**
     *
     * 查询音频分页
     */
    IPage<RAudioVo> queryListPage(PageRequestParameter<RAudioVo> parameter);
}
