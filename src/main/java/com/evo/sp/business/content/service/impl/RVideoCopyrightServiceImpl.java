package com.evo.sp.business.content.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evo.sp.business.content.entity.RVideoCopyright;
import com.evo.sp.business.content.entity.vo.RVideoCopyrightVo;
import com.evo.sp.business.content.mapper.RVideoCopyrightMapper;
import com.evo.sp.business.content.service.IRVideoCopyrightService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.evo.sp.common.ex.SpAssert;
import com.evo.sp.common.parameter.PageRequestParameter;
import org.springframework.stereotype.Service;

import javax.lang.model.type.ReferenceType;

/**
 * <p>
 * 版权信息表 服务实现类
 * </p>
 *
 * @author sgt
 * @since 2019-05-20
 */
@Service
public class RVideoCopyrightServiceImpl extends ServiceImpl<RVideoCopyrightMapper, RVideoCopyright> implements IRVideoCopyrightService {


    private RVideoCopyrightMapper rVideoCopyrightMapper;
    /**
     * 分页列表
     *
     * @param parameter
     */
    @Override
    public IPage<RVideoCopyrightVo> queryListPage(PageRequestParameter<RVideoCopyrightVo> parameter) {
        //校验参数
        SpAssert.isNull(parameter);
        Page page = parameter.pageInstance();
        SpAssert.isNull(page);
        RVideoCopyrightVo rVideoCopyrightVo = parameter.parameterInstance();
        SpAssert.setSort(rVideoCopyrightVo);

        return rVideoCopyrightMapper.queryListPage(page,rVideoCopyrightVo);
    }
}
