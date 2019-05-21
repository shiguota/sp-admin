package com.evo.sp.business.content.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evo.sp.business.content.entity.CVideo;
import com.evo.sp.business.content.entity.vo.CVideoVo;
import com.evo.sp.business.content.mapper.CVideoMapper;
import com.evo.sp.business.content.service.ICVideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.ex.SpAssert;
import com.evo.sp.common.parameter.PageRequestParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 视频内容基础信息表 服务实现类
 * </p>
 *
 * @author sgt
 * @since 2019-05-20
 */
@Service
public class CVideoServiceImpl extends ServiceImpl<CVideoMapper, CVideo> implements ICVideoService {


    @Autowired
    private CVideoMapper cVideoMapper;
    /**
     * 视频分页查询
     *
     * @param parameter
     */
    @Override
    public IPage<CVideoVo> queryListPage(PageRequestParameter<CVideoVo> parameter) {
        //校验参数
        SpAssert.isNull(parameter);
        Page page = parameter.pageInstance();
        SpAssert.isNull(page);
        CVideoVo cVideoVo = parameter.parameterInstance();
        //设置排序
        SpAssert.setSort(cVideoVo);
        return cVideoMapper.queryListPage(page,cVideoVo);
    }
}
