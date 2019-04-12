package com.evo.sp.business.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evo.sp.business.system.entity.SysDictionary;
import com.baomidou.mybatisplus.extension.service.IService;
import com.evo.sp.business.system.entity.vo.SysDictionaryVo;
import com.evo.sp.common.parameter.PageRequestParameter;

import java.util.List;

/**
 * <p>
 * 字典表 服务类
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
public interface ISysDictionaryService extends IService<SysDictionary> {
    /**
     *
     * 根据名称查询/pid
     */
    List<SysDictionary> queryByNamePid(PageRequestParameter<SysDictionaryVo> pageRequestParameter);
}
