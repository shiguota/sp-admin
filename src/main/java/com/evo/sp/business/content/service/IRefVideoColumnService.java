package com.evo.sp.business.content.service;

import com.evo.sp.business.content.entity.RefVideoColumn;
import com.baomidou.mybatisplus.extension.service.IService;
import com.evo.sp.common.result.Result;

import java.util.List;

/**
 * <p>
 * 视频栏目关联表 服务类
 * </p>
 *
 * @author sgt
 * @since 2019-05-22
 */
public interface IRefVideoColumnService extends IService<RefVideoColumn> {

    /**
     *
     * 根据id删除
     */
    Result delsById(List<String> ids,Integer type);


}
