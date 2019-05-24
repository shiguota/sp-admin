package com.evo.sp.business.content.service;

import com.evo.sp.business.content.entity.RefColumnImg;
import com.baomidou.mybatisplus.extension.service.IService;
import com.evo.sp.common.result.Result;

import java.util.List;

/**
 * <p>
 * 栏目图片关联表 服务类
 * </p>
 *
 * @author sgt
 * @since 2019-05-23
 */
public interface IRefColumnImgService extends IService<RefColumnImg> {

    /**
     *
     * 根据不同类似id删除
     */
    Result dels(List<String> ids, Integer type);
}
