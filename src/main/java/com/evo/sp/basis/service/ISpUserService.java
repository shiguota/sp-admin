package com.evo.sp.basis.service;

import com.evo.sp.basis.entity.SpUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.evo.sp.basis.entity.vo.SpRolePermissionsVo;
import com.evo.sp.basis.entity.vo.SpUserVo;
import com.evo.sp.common.annotations.SpLogService;
import com.evo.sp.common.ex.BaseException;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author sgt
 * @since 2019-03-27
 */
public interface ISpUserService extends IService<SpUser> {
    /**
     * @Description: 通过用户名获取密码
     * @Param:
     * @return:
     * @Author: sgt
     * @Date: 2019-03-28
     */
    SpUser userByname(String name) throws BaseException;

}
