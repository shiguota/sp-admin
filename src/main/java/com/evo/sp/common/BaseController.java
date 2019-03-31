package com.evo.sp.common;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.QueryChainWrapper;
import com.evo.sp.common.result.Result;
import com.evo.sp.common.result.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;

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
}
