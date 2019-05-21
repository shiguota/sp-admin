package com.evo.sp.business.content.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evo.sp.business.content.entity.RVideo;
import com.evo.sp.business.content.entity.vo.RVideoVo;
import com.evo.sp.business.content.mapper.RVideoMapper;
import com.evo.sp.business.content.service.IRVideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.evo.sp.common.ex.SpAssert;
import com.evo.sp.common.parameter.PageRequestParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 视频资源信息表 服务实现类
 * </p>
 *
 * @author sgt
 * @since 2019-05-20
 */
@Service
public class RVideoServiceImpl extends ServiceImpl<RVideoMapper, RVideo> implements IRVideoService {


    @Autowired
    private RVideoMapper rVideoMapper;
    /**
     * @param parameter
     */
    @Override
    public IPage<RVideoVo> queryListPage(PageRequestParameter<RVideoVo> parameter) {
        //校验参数
        SpAssert.isNull(parameter);
        Page page = parameter.pageInstance();
        SpAssert.isNull(page);
        RVideoVo rVideoVo = parameter.parameterInstance();
        SpAssert.setSort(rVideoVo);
        return rVideoMapper.queryListPage(page,rVideoVo);
    }
}
