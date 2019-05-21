package com.evo.sp.business.content.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.evo.sp.business.content.entity.RFigure;
import com.baomidou.mybatisplus.extension.service.IService;
import com.evo.sp.business.content.entity.vo.RFigureVo;
import com.evo.sp.common.parameter.PageRequestParameter;

/**
 * <p>
 * 人物表 服务类
 * </p>
 *
 * @author sgt
 * @since 2019-05-20
 */
public interface IRFigureService extends IService<RFigure> {
        
    
    /**
     *
     * 查询人物分页
     */
    IPage<RFigureVo> queryListPage(PageRequestParameter<RFigureVo> parameter);
}
