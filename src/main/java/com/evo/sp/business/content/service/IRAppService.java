package com.evo.sp.business.content.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.evo.sp.business.content.entity.RApp;
import com.baomidou.mybatisplus.extension.service.IService;
import com.evo.sp.business.content.entity.vo.RAppVo;
import com.evo.sp.common.parameter.PageRequestParameter;
import com.evo.sp.common.result.Result;
import com.evo.sp.common.tree.Tree;

import java.util.List;

/**
 * <p>
 * 应用表 服务类
 * </p>
 *
 * @author sgt
 * @since 2019-05-22
 */
public interface IRAppService extends IService<RApp> {

    /**
     *
     * 列表分页
     */
    IPage<RAppVo> queryListPage(PageRequestParameter<RAppVo> parameter);

    /**
     *
     * 树结构
     */
    List<Tree<RApp>> queryAppTree();
    
    /**
     *
     * 新增
     */
    Result saveApp(RAppVo rApp);
    
    /**
     *
     * 查询app
     */
    Result
}
