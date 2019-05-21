package com.evo.sp.business.content.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evo.sp.business.content.entity.RFigure;
import com.evo.sp.business.content.entity.vo.RFigureVo;
import com.evo.sp.business.content.mapper.RFigureMapper;
import com.evo.sp.business.content.service.IRFigureService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.evo.sp.common.ex.SpAssert;
import com.evo.sp.common.parameter.PageRequestParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 人物表 服务实现类
 * </p>
 *
 * @author sgt
 * @since 2019-05-20
 */
@Service
public class RFigureServiceImpl extends ServiceImpl<RFigureMapper, RFigure> implements IRFigureService {


    @Autowired
    private RFigureMapper rFigureMapper;

    /**
     * 查询人物分页
     *
     * @param parameter
     */
    @Override
    public IPage<RFigureVo> queryListPage(PageRequestParameter<RFigureVo> parameter) {
        //检验参数
        SpAssert.isNull(parameter);
        Page page = parameter.pageInstance();
        SpAssert.isNull(page);
        RFigureVo rFigureVo = parameter.parameterInstance();
        SpAssert.setSort(rFigureVo);
        return rFigureMapper.queryListPage(page,rFigureVo);
    }
}
