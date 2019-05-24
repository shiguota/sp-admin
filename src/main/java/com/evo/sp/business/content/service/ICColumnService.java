package com.evo.sp.business.content.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.evo.sp.business.content.entity.CColumn;
import com.baomidou.mybatisplus.extension.service.IService;
import com.evo.sp.business.content.entity.vo.CColumnVo;
import com.evo.sp.common.parameter.PageRequestParameter;
import com.evo.sp.common.result.Result;
import com.evo.sp.common.tree.Tree;

import java.util.List;

/**
 * <p>
 * 栏目表 服务类
 * </p>
 *
 * @author sgt
 * @since 2019-05-22
 */
public interface ICColumnService extends IService<CColumn> {

    /**
     *
     * 列表分页
     */
    IPage<CColumnVo> queryListPage(PageRequestParameter<CColumnVo> parameter);
    
    /**
     *
     * 栏目树
     */
    List<Tree<CColumn>> queryListTree(String pId,String treeId,Integer type);
    
    /**
     *
     * 新增
     */
    Result saveColumn(CColumnVo cColumn);

}
