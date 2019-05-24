package com.evo.sp.business.content.service.impl;

import com.evo.sp.business.content.entity.RefAppImg;
import com.evo.sp.business.content.mapper.RefAppImgMapper;
import com.evo.sp.business.content.service.IRefAppImgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.evo.sp.common.ex.DelException;
import com.evo.sp.common.ex.SpAssert;
import com.evo.sp.common.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 应用图片关联表 服务实现类
 * </p>
 *
 * @author sgt
 * @since 2019-05-22
 */
@Service
public class RefAppImgServiceImpl extends ServiceImpl<RefAppImgMapper, RefAppImg> implements IRefAppImgService {


    @Autowired
    private RefAppImgMapper refAppImgMapper;
    /**
     * 根据不同类型的id删除
     *
     * @param ids
     * @param type
     */
    @Override
    public Result dels(List<String> ids, Integer type) {
        //校验数据
        SpAssert.isNull(ids);
        SpAssert.isNull(type);
        if(type == 1){
            SpAssert.operationAssert(super.removeByIds(ids),new DelException());
        }else if(type ==2){
            SpAssert.operationAssert(refAppImgMapper.delByAppId(ids),new DelException());
        }else if(type ==3){
            SpAssert.operationAssert(refAppImgMapper.delByImgId(ids),new DelException());
        }
        return null;
    }
}
