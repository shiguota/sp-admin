package com.evo.sp.business.content.service;

import com.evo.sp.business.content.entity.RefBookColumn;
import com.baomidou.mybatisplus.extension.service.IService;
import com.evo.sp.common.result.Result;

import java.util.List;

/**
 * <p>
 * 栏目绘本关联表 服务类
 * </p>
 *
 * @author sgt
 * @since 2019-05-22
 */
public interface IRefBookColumnService extends IService<RefBookColumn> {

    /**
     *
     * 删除
     */
    
    Result dels(List<String> ids, Integer type);
}
