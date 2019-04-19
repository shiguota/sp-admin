package com.evo.sp.business.system.service;

import com.evo.sp.business.system.entity.SysArea;
import com.baomidou.mybatisplus.extension.service.IService;
import com.evo.sp.business.system.entity.vo.SysAreaVo;
import com.evo.sp.common.parameter.PageRequestParameter;
import com.evo.sp.common.result.Result;
import com.evo.sp.common.tree.Tree;

import java.util.List;

/**
 * <p>
 * 区域表 服务类
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
public interface ISysAreaService extends IService<SysArea> {
    /**
     *
     * 根据条件，分页查询区域
     */
    Result queryListPage(PageRequestParameter<SysAreaVo> sysAreaVoPageRequestParameter);

    /**
     *
     * 获取区域信息，并返回构建树结构所需对象
     */
    List<Tree<SysArea>> queryAreaTree();
}
