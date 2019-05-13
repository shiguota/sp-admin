package com.evo.sp.business.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evo.sp.business.system.entity.SysDictionary;
import com.evo.sp.business.system.entity.vo.SysDictionaryVo;
import com.evo.sp.business.system.mapper.SysDictionaryMapper;
import com.evo.sp.business.system.service.ISysDictionaryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.evo.sp.common.BaseService;
import com.evo.sp.common.BaseServiceImpl;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.ex.SpAssert;
import com.evo.sp.common.parameter.PageRequestParameter;
import com.evo.sp.common.result.Result;
import com.evo.sp.common.tree.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
@SuppressWarnings("all")
public class SysDictionaryServiceImpl extends BaseServiceImpl<SysDictionaryMapper, SysDictionary>
        implements ISysDictionaryService{

    @Autowired
    private SysDictionaryMapper sysDictionaryMapper;

    /**
     *
     * 新增
     */
    @Override
    public boolean save(SysDictionary entity) {
        SpAssert.isNull(entity);
        SpAssert.isNull(entity.getDicName());
        SpAssert.isNull(entity.getDicCode());
        SpAssert.isNull(entity.getLevel());
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
    public List<Tree<SysDictionary>> queryDictionaryByLevel() {
        List<SysDictionary> list = list(new QueryWrapper<SysDictionary>().eq(SpConstantInter.TABLE_STATE, 1).eq(SpConstantInter.LEVEL, 1));
        return queryTree(list,null);
    }

    /**
     * 根据pid获取当前节点下的子节点
     *
     * @param pid
     */
    @Override
    public Result queryByPidTree(String pid,String treeId) {
        List<SysDictionary> list = list(new QueryWrapper<SysDictionary>().eq(SpConstantInter.PID, pid));
        return new Result(queryTree(list,treeId));
    }

    /**
     *
     * 构建树结构json数据
     */
    @Override
    public List<Tree<SysDictionary>> queryTree(List<SysDictionary> list,String treeId) {
        return super.queryTree(list,treeId);
    }
}
