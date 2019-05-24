package com.evo.sp.business.content.service.impl;

import com.evo.sp.business.content.entity.RefColumnImg;
import com.evo.sp.business.content.mapper.RefColumnImgMapper;
import com.evo.sp.business.content.service.IRefColumnImgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.evo.sp.common.ex.DelException;
import com.evo.sp.common.ex.SpAssert;
import com.evo.sp.common.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 栏目图片关联表 服务实现类
 * </p>
 *
 * @author sgt
 * @since 2019-05-23
 */
@Service
public class RefColumnImgServiceImpl extends ServiceImpl<RefColumnImgMapper, RefColumnImg> implements IRefColumnImgService {


    @Autowired
    private RefColumnImgMapper refColumnImgMapper;

    /**
     * 根据不同类似id删除
     *
     * @param ids
     * @param type
     */
    @Override
    public Result dels(List<String> ids, Integer type) {
        //校验参数
        SpAssert.isNull(ids);
        SpAssert.isNull(type);
        if (type == 1) {
            SpAssert.operationAssert(super.removeByIds(ids), new DelException());
        } else if (type == 2) {
            SpAssert.operationAssert(refColumnImgMapper.delByColumnIds(ids), new DelException());
        } else if (type == 3) {
            SpAssert.operationAssert(refColumnImgMapper.delImgIds(ids), new DelException());
        }
        return null;
    }
}
