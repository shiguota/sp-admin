package com.evo.sp.business.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evo.sp.business.system.entity.SysDictionary;
import com.baomidou.mybatisplus.extension.service.IService;
import com.evo.sp.business.system.entity.vo.SysDictionaryVo;
import com.evo.sp.common.BaseService;
import com.evo.sp.common.parameter.PageRequestParameter;
import com.evo.sp.common.result.Result;
import com.evo.sp.common.tree.Tree;

import java.util.List;

/**
 * <p>
 * 字典表 服务类
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
public interface ISysDictionaryService extends IService<SysDictionary>, BaseService<SysDictionary> {
    /**
     *
     * 根据名称查询/pid
     */
    Page<SysDictionary> queryByNamePid(PageRequestParameter<SysDictionaryVo> pageRequestParameter);



    /**
     *
     * 根据字典code编码获取数据
     */
    Result queryByCode(String code);

    /**
     *
     * 根据条件查询字典值
     */
    List<Tree<SysDictionary>> queryDictionaryByLevel();

    
    /**
     *
     * 根据pid获取当前节点下的子节点
     */
    Result queryByPidTree(String pid,String treeId);

}
