package com.evo.sp.business.system.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evo.sp.business.system.entity.SystemUser;
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
public interface SystemUserMapper extends BaseMapper<SystemUser> {

    SystemUser userByname(String name) throws BaseException;

}
