package com.evo.sp.business.content.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evo.sp.business.content.entity.RAudio;
import com.evo.sp.business.content.entity.vo.RAudioVo;
import com.evo.sp.business.content.mapper.RAudioMapper;
import com.evo.sp.business.content.service.IRAudioService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.evo.sp.common.ex.SpAssert;
import com.evo.sp.common.parameter.PageRequestParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 音频属性表 服务实现类
 * </p>
 *
 * @author sgt
 * @since 2019-05-20
 */
@Service
public class RAudioServiceImpl extends ServiceImpl<RAudioMapper, RAudio> implements IRAudioService {


    @Autowired
    private RAudioMapper rAudioMapper;


    /**
     * 查询音频分页
     *
     * @param parameter
     */
    @Override
    public IPage<RAudioVo> queryListPage(PageRequestParameter<RAudioVo> parameter) {
        //校验参数
        SpAssert.isNull(parameter);
        Page page = parameter.pageInstance();
        SpAssert.isNull(page);
        RAudioVo rAudioVo = parameter.parameterInstance();
        SpAssert.setSort(rAudioVo);
        return rAudioMapper.queryListPage(page,rAudioVo);
    }
}
