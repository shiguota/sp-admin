package com.evo.sp.business.content.service.impl;

import com.evo.sp.business.content.entity.RefVideoColumn;
import com.evo.sp.business.content.mapper.RefVideoColumnMapper;
import com.evo.sp.business.content.service.IRefVideoColumnService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.evo.sp.common.ex.DelException;
import com.evo.sp.common.ex.SpAssert;
import com.evo.sp.common.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 视频栏目关联表 服务实现类
 * </p>
 *
 * @author sgt
 * @since 2019-05-22
 */
@Service
public class RefVideoColumnServiceImpl extends ServiceImpl<RefVideoColumnMapper, RefVideoColumn> implements IRefVideoColumnService {



    @Autowired
    private RefVideoColumnMapper refVideoColumnMapper;


    /**
     * 根据id删除
     *
     * @param ids
     * @param type  1 根据id删除， 2根据 栏目id删除   3根据视频id删除
     */
    @Override
    public Result delsById(List<String> ids,Integer type) {
        //参数校验
        SpAssert.isNull(type);
        SpAssert.isNull(ids);
        if (type == 1) {
            SpAssert.operationAssert(super.removeByIds(ids),new DelException());
        }else if(type == 2  ){
            SpAssert.operationAssert(refVideoColumnMapper.delsBycolumnId(ids),new DelException());
        }else if(type == 3){
            SpAssert.operationAssert(refVideoColumnMapper.delsByvideoId(ids),new DelException());
        }
        return new Result(true);
    }
}
