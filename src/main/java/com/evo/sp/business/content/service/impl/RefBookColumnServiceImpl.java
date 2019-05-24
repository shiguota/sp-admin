package com.evo.sp.business.content.service.impl;

import com.evo.sp.business.content.entity.RefBookColumn;
import com.evo.sp.business.content.mapper.RefBookColumnMapper;
import com.evo.sp.business.content.service.IRefBookColumnService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.evo.sp.common.ex.DelException;
import com.evo.sp.common.ex.SpAssert;
import com.evo.sp.common.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 栏目绘本关联表 服务实现类
 * </p>
 *
 * @author sgt
 * @since 2019-05-22
 */
@Service
@SuppressWarnings("all")
public class RefBookColumnServiceImpl extends ServiceImpl<RefBookColumnMapper, RefBookColumn> implements IRefBookColumnService {


    @Autowired
    private RefBookColumnMapper delsBycolumnId;
    /**
     * 删除
     *
     * @param ids id 集合
     * @param type 1 根据id，2根据栏目id ， 3根据 绘本id
     */
    @Override
    public Result dels(List<String> ids, Integer type) {
        //参数校验
        SpAssert.isNull(type);
        SpAssert.isNull(ids);
        if (type == 1) {
            SpAssert.operationAssert(super.removeByIds(ids),new DelException());
        }else if(type == 2  ){
            SpAssert.operationAssert(delsBycolumnId.delsBycolumnId(ids),new DelException());
        }else if(type == 3){
            SpAssert.operationAssert(delsBycolumnId.delsByBookId(ids),new DelException());
        }
        return new Result(true);
    }
}
