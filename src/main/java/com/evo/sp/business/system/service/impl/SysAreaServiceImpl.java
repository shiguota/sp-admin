package com.evo.sp.business.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evo.sp.business.system.entity.SysArea;
import com.evo.sp.business.system.entity.vo.SysAreaVo;
import com.evo.sp.business.system.mapper.SysAreaMapper;
import com.evo.sp.business.system.service.ISysAreaService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class SysAreaServiceImpl extends ServiceImpl<SysAreaMapper, SysArea> implements ISysAreaService {


    @Autowired
    private SysAreaMapper sysAreaMapper;

    /**
     * 根据条件，分页查询区域
     *
     * @param sysAreaVoPageRequestParameter
     */
    @Override
    public Result queryListPage(PageRequestParameter<SysAreaVo> sysAreaVoPageRequestParameter) {
        boolean sortType = false;
        //获取分页对象
        Page page = sysAreaVoPageRequestParameter.pageInstance();
        //获取条件参数对象
        SysAreaVo sysAreaVo = sysAreaVoPageRequestParameter.parameterInstance();
        //校验参数
        SpAssert.isNull(sysAreaVo);
        //创建查询对象
        QueryWrapper<SysArea> sysAreaQueryWrapper = new QueryWrapper<>();
        SpAssert.isNull(sysAreaVo.getId());
        sysAreaQueryWrapper.eq(SpConstantInter.PID,sysAreaVo.getId());
        //如果区域名称不为空，则添加查询条件
        if (SpAssert.isNotNull(sysAreaVo.getAreaName())) {
            sysAreaQueryWrapper.like(SpConstantInter.SYS_AREA_NAME,sysAreaVo.getAreaName());
        }
        //根据排序类型的值，改变排序的方式。默认是desc排序
        if (SpAssert.isNotNull(sysAreaVo.getSort())) {
            if (sysAreaVo.getSort().equals(SpConstantInter.ASC)) {
                sortType = true;
            }
        }
        sysAreaQueryWrapper.orderBy(true,sortType,SpConstantInter.SORT);

        return new Result(page(page,sysAreaQueryWrapper));
    }

    /**
     * 获取区域信息，并返回构建树结构所需对象
     */
    @Override
    public List<Tree<SysArea>> queryAreaTree() {
        //创建树结构需要对象类型
        List<Tree<SysArea>> trees = new ArrayList<>();
        //获取区域数据
        List<SysArea> list = list();
        //便利区域数据
        for (SysArea sysArea : list) {
            Tree<SysArea> tree = new Tree<SysArea>();
            tree.setId(sysArea.getId());
            tree.setParentId(sysArea.getPid());
            tree.setText(sysArea.getAreaName());
            trees.add(tree);
        }
        return trees;
    }
}
