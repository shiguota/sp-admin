package com.evo.sp.business.content.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.evo.sp.business.content.entity.CColumn;
import com.evo.sp.business.content.entity.vo.CColumnVo;
import com.evo.sp.business.content.mapper.CColumnMapper;
import com.evo.sp.business.content.mapper.RAppMapper;
import com.evo.sp.business.content.service.ICColumnService;
import com.evo.sp.business.content.service.IRAppService;
import com.evo.sp.business.content.service.IRefAppColumnService;
import com.evo.sp.common.BaseServiceImpl;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.ex.SaveException;
import com.evo.sp.common.ex.SpAssert;
import com.evo.sp.common.parameter.PageRequestParameter;
import com.evo.sp.common.result.Result;
import com.evo.sp.common.tree.Tree;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 栏目表 服务实现类
 * </p>
 *
 * @author sgt
 * @since 2019-05-22
 */
@Service
public class CColumnServiceImpl extends BaseServiceImpl<CColumnMapper, CColumn> implements ICColumnService {

    //栏目type
    private static final Integer COLUMN_TYPE = 0;


    @Autowired
    private CColumnMapper cColumnMapper;
    @Autowired
    private IRAppService irAppService;

    @Override
    public IPage<CColumnVo> queryListPage(PageRequestParameter<CColumnVo> parameter) {
        //校验参数
        SpAssert.isNull(parameter);
        SpAssert.isNull(parameter.pageInstance());
        CColumnVo cColumnVo = parameter.parameterInstance();
        if (SpAssert.isNotNull(cColumnVo)) {
            SpAssert.sortAssert(cColumnVo.getcSortType());
            SpAssert.sortAssert(cColumnVo.getuSortType());
        }else {
            SpAssert.setSort(cColumnVo);
        }
        return cColumnMapper.queryListPage(parameter.pageInstance(),cColumnVo);
    }

    /**
     * 栏目树
     * @param pId
     */
    @Override
    public List<Tree<CColumn>> queryListTree(String pId,String treeId,Integer type) {
        if(type == COLUMN_TYPE){
            irAppService.
        }
        return queryTree(list(new QueryWrapper<CColumn>().eq(SpConstantInter.PID,pId)),treeId);
    }

    /**
     * 新增
     *
     * @param cColumn
     */
    @Override
    @Transactional
    public Result saveColumn(CColumnVo cColumn) {
        //校验参数
        SpAssert.isNull(cColumn);
        SpAssert.isNull(cColumn.getType());
        SpAssert.isNull(cColumn.getName());
        CColumn cC = new CColumn();
        //复制对象
        BeanUtils.copyProperties(cColumn,cC);
        //保存栏目
        if (!save(cC)) {
            throw new SaveException();
        }
        return new Result(true);
    }
}
