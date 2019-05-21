package com.evo.sp.business.content.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evo.sp.business.content.entity.CBook;
import com.evo.sp.business.content.entity.vo.CBookVo;
import com.evo.sp.business.content.mapper.CBookMapper;
import com.evo.sp.business.content.service.ICBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.ex.SpAssert;
import com.evo.sp.common.parameter.PageRequestParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 绘本表 服务实现类
 * </p>
 *
 * @author sgt
 * @since 2019-05-20
 */
@Service
public class CBookServiceImpl extends ServiceImpl<CBookMapper, CBook> implements ICBookService {

    @Autowired
    private CBookMapper cBookMapper;


    /**
     * 绘本分页查询
     *
     * @param parameter
     */
    @Override
    public IPage<CBookVo> queryListPage(PageRequestParameter<CBookVo> parameter) {
        //参数校验
        SpAssert.isNull(parameter);
        Page page = parameter.pageInstance();
        SpAssert.isNull(page);
        CBookVo cBookVo = parameter.parameterInstance();
        SpAssert.isNull(cBookVo);
        //判断排序值是否正确
        SpAssert.sortAssert(cBookVo.getcSortType());
        SpAssert.sortAssert(cBookVo.getuSortType());
        //默认创建时间倒序排序
        if (SpAssert.isNotNull(cBookVo.getcSortType())) {
            if (SpAssert.isNotNull(cBookVo.getuSortType())) {
                cBookVo.setcSortType(SpConstantInter.DESC);
            }
        }
        return cBookMapper.queryListPage(page, cBookVo);
    }
}
