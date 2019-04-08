package com.evo.sp.common;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.IService;
import com.evo.sp.business.system.entity.SystemUser;
import com.evo.sp.common.ex.SpAssert;
import com.evo.sp.common.result.Result;
import com.evo.sp.common.result.ResultEnum;
import com.evo.sp.common.tree.BuildTree;
import com.evo.sp.common.tree.Test;
import com.evo.sp.common.tree.Tree;

import java.io.Serializable;
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


    /**
     *
     * 根据条件（分页查询）
     */
    public Result queryListPage(IPage<T> page,T t,IService<T> tiService){
        if (!SpAssert.isNotNull(t)) {
            return new  Result(tiService.page(page, Wrappers.emptyWrapper()));
        }else{
            return new  Result(tiService.page(page,new QueryWrapper<>(t)));
        }
    }
    
    /**
     *
     * 返回树形结构json
     */
    public Result queryJsonData(List<Tree<T>> trees){
        return new Result(BuildTree.build(trees));
    }
}
