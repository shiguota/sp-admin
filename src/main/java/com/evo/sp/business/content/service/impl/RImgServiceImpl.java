package com.evo.sp.business.content.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evo.sp.business.content.entity.RImg;
import com.evo.sp.business.content.entity.vo.RImgVo;
import com.evo.sp.business.content.mapper.RImgMapper;
import com.evo.sp.business.content.service.IRImgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.evo.sp.common.ex.SpAssert;
import com.evo.sp.common.parameter.PageRequestParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 资源（图）表 服务实现类
 * </p>
 *
 * @author sgt
 * @since 2019-05-20
 */
@Service
public class RImgServiceImpl extends ServiceImpl<RImgMapper, RImg> implements IRImgService {


    @Autowired
    private RImgMapper rImgMapper;
    /**
     * 列表查询
     *
     * @param parameter
     */
    @Override
    public IPage<RImgVo> queryListPage(PageRequestParameter<RImgVo> parameter) {
        //检验参数
        SpAssert.isNull(parameter);
        Page page = parameter.pageInstance();
        SpAssert.isNull(page);
        RImgVo rImgVo = parameter.parameterInstance();
        SpAssert.setSort(rImgVo);
        return rImgMapper.queryListPage(page,rImgVo);
    }
}
