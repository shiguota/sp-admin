package com.evo.sp.business.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evo.sp.business.system.entity.SysArea;
import com.evo.sp.business.system.entity.vo.SysAreaVo;
import com.evo.sp.business.system.mapper.SysAreaMapper;
import com.evo.sp.business.system.service.ISysAreaService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
 * 区域表 服务实现类
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
@Service
public class SysAreaServiceImpl extends BaseServiceImpl<SysAreaMapper, SysArea> implements ISysAreaService {


    @Autowired
    private SysAreaMapper sysAreaMapper;

    /**
     * 根据条件，分页查询区域
     *
     * @param sysAreaVoPageRequestParameter
     */
    @Override
    public Result queryListPage(PageRequestParameter<SysAreaVo> sysAreaVoPageRequestParameter) {
        //获取分页对象
        Page page = sysAreaVoPageRequestParameter.pageInstance();
        //获取条件参数对象
        SysAreaVo sysAreaVo = sysAreaVoPageRequestParameter.parameterInstance();
        //校验参数
        SpAssert.isNull(sysAreaVo);
        SpAssert.isNull(sysAreaVo.getId());
        SpAssert.sortAssert(sysAreaVo.getSort());
        SpAssert.sortAssert(sysAreaVo.getcSortType());
        SpAssert.sortAssert(sysAreaVo.getuSortType());
        //默认排序为sort字段ASC
        if (!SpAssert.isNotNull(sysAreaVo.getuSortType()) && !SpAssert.isNotNull(sysAreaVo.getcSortType())) {
            sysAreaVo.setSort(SpConstantInter.ASC);
        }
        return new Result(sysAreaMapper.queryAreaPage(page,sysAreaVo));
    }

    /**
     * 获取区域信息，并返回构建树结构所需对象
     */
    @Override
    public List<Tree<SysArea>> queryAreaTree() {
        //获取区域数据
        List<SysArea> list = list(new QueryWrapper<SysArea>().eq(SpConstantInter.LEVEL,1));
        return super.queryTree(list, null);
    }

    /**
     * 获取区域信息
     *
     * @param pid
     */
    @Override
    public List<Tree<SysArea>> queryAreaByPid(String pid,String treeId) {
        List<SysArea> list = list(new QueryWrapper<SysArea>().eq(SpConstantInter.PID,pid));
        return super.queryTree(list, treeId);
    }
}
