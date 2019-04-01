package com.evo.sp.business.system.mapper;

import com.evo.sp.business.system.entity.SpUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.evo.sp.common.ex.BaseException;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author sgt
 * @since 2019-04-01
 */
public interface SpUserMapper extends BaseMapper<SpUser> {

    SpUser userByname(String name) throws BaseException;
}
