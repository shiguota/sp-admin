package com.evo.sp.business.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evo.sp.business.system.entity.SysDictionary;
import com.evo.sp.business.system.entity.vo.SysDictionaryVo;
import com.evo.sp.business.system.mapper.SysDictionaryMapper;
import com.evo.sp.business.system.service.ISysDictionaryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.evo.sp.common.ex.SpAssert;
import com.evo.sp.common.parameter.PageRequestParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 字典表 服务实现类
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
@Service
public class SysDictionaryServiceImpl extends ServiceImpl<SysDictionaryMapper, SysDictionary> implements ISysDictionaryService {

    @Autowired
    private SysDictionaryMapper sysDictionaryMapper;


    /**
     * 字典级别
     * 1为一级（第一层）
     * 2为二级（第二层）
     */
    private  final Integer DIC_LEVEL= 2;

    /**
     *
     * 新增
     */
    @Override
    public boolean save(SysDictionary entity) {
        SpAssert.isNull(entity);
        SpAssert.isNull(entity.getDicName());
        SpAssert.isNull(entity.getDicCode());
        if(SpAssert.isNotNull(entity.getPid())){
            entity.setLevel(DIC_LEVEL);
        }
        return super.save(entity);
    }


    /**
     * 根据名称查询/pid
     *
     * @param pageRequestParameter
     */
    @Override
    public List<SysDictionary> queryByNamePid(PageRequestParameter<SysDictionaryVo> pageRequestParameter) {
        //获取分页对象
        Page page = pageRequestParameter.pageInstance();
        //获取条件参数对象
        SysDictionaryVo sysDictionaryVo = pageRequestParameter.parameterInstance();
        if (SpAssert.isNotNull(sysDictionaryVo)) {
            if (SpAssert.isNotNull(sysDictionaryVo.getCTimeOrder()) || SpAssert.isNotNull(sysDictionaryVo.getUTimeOrder())) {
                sysDictionaryVo.setDicSort(null);
            }
        }
        return sysDictionaryMapper.queryByNamePid(page,sysDictionaryVo);
    }
}
