package com.evo.sp.business.content.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.evo.sp.business.content.entity.RImg;
import com.baomidou.mybatisplus.extension.service.IService;
import com.evo.sp.business.content.entity.vo.RImgVo;
import com.evo.sp.common.parameter.PageRequestParameter;

/**
 * <p>
 * 资源（图）表 服务类
 * </p>
 *
 * @author sgt
 * @since 2019-05-20
 */
public interface IRImgService extends IService<RImg> {
    
    
    /**
     *
     * 列表查询
     */
    IPage<RImgVo> queryListPage(PageRequestParameter<RImgVo> parameter);
}
