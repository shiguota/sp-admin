package com.evo.sp.business.content.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.evo.sp.business.content.entity.CBook;
import com.baomidou.mybatisplus.extension.service.IService;
import com.evo.sp.business.content.entity.vo.CBookVo;
import com.evo.sp.common.parameter.PageRequestParameter;

/**
 * <p>
 * 绘本表 服务类
 * </p>
 *
 * @author sgt
 * @since 2019-05-20
 */
public interface ICBookService extends IService<CBook> {
        
    
    /**
     *
     *  绘本分页查询
     */
    IPage<CBookVo> queryListPage(PageRequestParameter<CBookVo> parameter);
}
