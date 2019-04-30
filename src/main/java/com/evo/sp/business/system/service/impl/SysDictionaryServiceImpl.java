package com.evo.sp.business.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evo.sp.business.system.entity.SysDictionary;
import com.evo.sp.business.system.entity.vo.SysDictionaryVo;
import com.evo.sp.business.system.mapper.SysDictionaryMapper;
import com.evo.sp.business.system.service.ISysDictionaryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.ex.SpAssert;
import com.evo.sp.common.parameter.PageRequestParameter;
import com.evo.sp.common.result.Result;
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
    public Page<SysDictionary> queryByNamePid(PageRequestParameter<SysDictionaryVo> pageRequestParameter) {
        //获取分页对象
        Page page = pageRequestParameter.pageInstance();
        //获取条件参数对象
        SysDictionaryVo sysDictionaryVo = pageRequestParameter.parameterInstance();
        if (SpAssert.isNotNull(sysDictionaryVo)) {
            if (SpAssert.isNotNull(sysDictionaryVo.getCSortType()) || SpAssert.isNotNull(sysDictionaryVo.getUSortType())) {
                sysDictionaryVo.setDicSort(null);
            }
        }
        return sysDictionaryMapper.queryByNamePid(page,sysDictionaryVo);
    }

    /**
     * 根据字典code编码获取数据
     *
     * @param code
     */
    @Override
    public Result queryByCode(String code) {
        //校验
        SpAssert.isNull(code);
        SysDictionary sysDictionary = new SysDictionary();
        sysDictionary.setDicCode(code);
        //设置条件
        QueryWrapper<SysDictionary> sysDictionaryQueryWrapper = new QueryWrapper<>();
        sysDictionaryQueryWrapper.setEntity(sysDictionary);
        return new Result(sysDictionaryQueryWrapper);
    }

    /**
     * 根据级别查询字典值
     */
    @Override
    public List<SysDictionary> queryDictionaryByLevel() {
        return list(new QueryWrapper<SysDictionary>().eq(SpConstantInter.LEVEL,1));
    }


}
