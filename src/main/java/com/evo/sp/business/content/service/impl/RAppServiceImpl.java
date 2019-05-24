package com.evo.sp.business.content.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evo.sp.business.content.entity.RApp;
import com.evo.sp.business.content.entity.RefAppColumn;
import com.evo.sp.business.content.entity.vo.RAppVo;
import com.evo.sp.business.content.mapper.RAppMapper;
import com.evo.sp.business.content.service.IRAppService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.evo.sp.business.content.service.IRefAppColumnService;
import com.evo.sp.common.BaseService;
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
 * 应用表 服务实现类
 * </p>
 *
 * @author sgt
 * @since 2019-05-22
 */
@Service
public class RAppServiceImpl extends BaseServiceImpl<RAppMapper, RApp> implements IRAppService {


    @Autowired
    private RAppMapper rAppMapper;
    @Autowired
    private IRefAppColumnService iRefAppColumnService;
    /**
     * 列表分页
     *
     * @param parameter
     */
    @Override
    public IPage<RAppVo> queryListPage(PageRequestParameter<RAppVo> parameter) {
        //检验数据
        SpAssert.isNull(parameter);
        Page page = parameter.pageInstance();
        SpAssert.isNull(page);
        RAppVo rAppVo = parameter.parameterInstance();
        if (SpAssert.isNotNull(rAppVo)) {
            SpAssert.sortAssert(rAppVo.getcSortType());
            SpAssert.sortAssert(rAppVo.getuSortType());
            SpAssert.sortAssert(rAppVo.getSort());
        }else{
            rAppVo.setSort(SpConstantInter.ASC);
        }
        return rAppMapper.queryListPage(page,rAppVo);
    }

    /**
     * 树结构
     */
    @Override
    public List<Tree<RApp>> queryAppTree() {
        return queryTree(list(),null);
    }

    /**
     * 新增
     *
     * @param rAppVo
     */
    @Override
    @Transactional
    public Result saveApp(RAppVo rAppVo) {
        //校验参数
        SpAssert.isNull(rAppVo.getName());
        SpAssert.isNull(rAppVo.getCode());
        SpAssert.isNull(rAppVo.getIsPublish());
        SpAssert.isNull(rAppVo.getType());
        RApp rApp = new RApp();
        BeanUtils.copyProperties(rAppVo,rApp);
        //新增
        if (!save(rApp)){
            throw new  SaveException();
        }else{
            if (SpAssert.isNotNull(rAppVo.getColumnId())) {
                //保存应用栏目
                RefAppColumn refAppColumn = new RefAppColumn();
                refAppColumn.setAppId(rApp.getId());
                refAppColumn.setColumnId(rAppVo.getColumnId());
                SpAssert.operationAssert(iRefAppColumnService.save(refAppColumn),new SaveException());
            }
        }
        return new Result(true);
    }
}
