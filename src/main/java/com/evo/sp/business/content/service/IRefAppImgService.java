package com.evo.sp.business.content.service;

import com.evo.sp.business.content.entity.RefAppImg;
import com.baomidou.mybatisplus.extension.service.IService;
import com.evo.sp.common.result.Result;

import java.util.List;

/**
 * <p>
 * 应用图片关联表 服务类
 * </p>
 *
 * @author sgt
 * @since 2019-05-22
 */
public interface IRefAppImgService extends IService<RefAppImg> {

    /**
     *
     * 根据不同类型的id删除
     */
    Result dels(List<String> ids, Integer type);
}
