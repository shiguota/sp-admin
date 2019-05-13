package com.evo.sp.common;


import com.baomidou.mybatisplus.extension.service.IService;
import com.evo.sp.common.tree.Tree;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author sgt
 * @since 2019-05-13 12:54
 */
public interface BaseService<T> extends IService<T> {

     List<Tree<T>> queryTree(List<T> list, String treeId);

}
