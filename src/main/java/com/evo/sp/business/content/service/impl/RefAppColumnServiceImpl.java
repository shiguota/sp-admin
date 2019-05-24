package com.evo.sp.business.content.service.impl;

import com.evo.sp.business.content.entity.RefAppColumn;
import com.evo.sp.business.content.mapper.RefAppColumnMapper;
import com.evo.sp.business.content.service.IRefAppColumnService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.evo.sp.common.ex.DelException;
import com.evo.sp.common.ex.SpAssert;
import com.evo.sp.common.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 应用栏目关联表 服务实现类
 * </p>
 *
 * @author sgt
 * @since 2019-05-22
 */
@Service
@SuppressWarnings("all")
public class RefAppColumnServiceImpl extends ServiceImpl<RefAppColumnMapper, RefAppColumn> implements IRefAppColumnService {


    @Autowired
    private RefAppColumnMapper refAppColumnMapper;
    /**
     * 根据不同类型的id，删除数据
     *
     * @param ids  id集合
     * @param type 1 id 删除 2 栏目id删除    3 应用id删除
     */
    @Override
    public Result dels(List<String> ids, Integer type) {
        //参数校验
        SpAssert.isNull(ids);
        SpAssert.isNull(type);
        if (type == 1) {
            SpAssert.operationAssert(super.removeByIds(ids),new DelException());
        }else if(type == 2  ){
            SpAssert.operationAssert(refAppColumnMapper.delsBycolumnId(ids),new DelException());
        }else if(type == 3){
            SpAssert.operationAssert(refAppColumnMapper.delsByAppId(ids),new DelException());
        }
        return new Result(true);
    }
}
