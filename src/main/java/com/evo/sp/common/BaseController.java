package com.evo.sp.common;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.QueryChainWrapper;
import com.evo.sp.common.result.Result;
import com.evo.sp.common.result.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisSubscribedConnectionException;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @Description: controller Base类
 * @Author: sgt
 * @Date: 2019-03-27
 */
public class BaseController<T> {

    /**
     * @Description: 新增
     * @Param:
     * @return:
     * @Author: sgt
     * @Date: 2019-03-27
     */
    public Result save(T t,IService<T> tiService) {
        Result result = null;
        boolean save = tiService.save(t);
        if (save) {
            result = new Result(save, ResultEnum.SAVE_SUCCESS.getValue(), ResultEnum.SAVE_SUCCESS.getName());
        } else {
            result = new Result(save, ResultEnum.SAVE_FAIL.getValue(), ResultEnum.SAVE_FAIL.getName());
        }

        return result;

    }


    /**
     * @Description: 删除（根据id）
     * @Param:
     * @return:
     * @Author: sgt
     * @Date: 2019-03-27
     */
    public Result del(String id,IService<T> tiService) {
        Result result = null;
        boolean b = tiService.removeById(id);
        if (b) {
            result = new Result(b, ResultEnum.REMOVE_SUCCESS.getValue(), ResultEnum.REMOVE_SUCCESS.getName());
        } else {
            result = new Result(b, ResultEnum.REMOVE_FAIL.getValue(), ResultEnum.REMOVE_FAIL.getName());
        }
        return result;

    }

    /**
     * @Description: 修改
     * @Param:
     * @return:
     * @Author: sgt
     * @Date: 2019-03-27
     */
    public Result modify(T t,IService<T> tiService) {
        Result result = null;

        boolean b = tiService.updateById(t);
        if (b) {
            result = new Result(b,ResultEnum.MODIFY_SUCCESS.getValue(),ResultEnum.MODIFY_SUCCESS.getName());
        } else {
            result = new Result(b,ResultEnum.MODIFY_FAIL.getValue(),ResultEnum.MODIFY_FAIL.getName());
        }
        return result;

    }

    /**
    * @Description:通过id查询
    * @Param:
    * @return:
    * @Date: 2019-04-03
    */
    public Result queryById(Serializable id,IService<T> tiService){
        SpAssert.isNull(id);
        SpAssert.isNull(tiService);
        T byId = tiService.getById(id);
        return new Result(byId);
    }

    /**
    * @Description:根据id查询（批量）
    * @Param:  
    * @return:  
    * @Date: 2019-04-03 
    */
    public Result queryByIds(Collection<? extends Serializable> idList,IService<T> tiService){
        SpAssert.isNull(idList);
        SpAssert.isNull(tiService);
        Collection<T> ts = tiService.listByIds(idList);
        return new Result(ts);
    }

    /**
    * @Description:根据条件查询（批量）
    * @Param:
    * @return:
    * @Date: 2019-04-04
    */
    public Result queryListsByCloumn(Map<String, Object> columnMap,IService<T> tiService){
        Collection<T> ts = tiService.listByMap(columnMap);
        return new Result(ts);
    }

    /**
    * @Description:根据条件查询一条记录
    * @Param:
    * @return:
    * @Date: 2019-04-04
    */
    public Result queryOne(Wrapper<T> queryWrapper, boolean throwEx,IService<T> tiService){
        T one = tiService.getOne(queryWrapper, throwEx);
        return new Result(one);
    }
}
