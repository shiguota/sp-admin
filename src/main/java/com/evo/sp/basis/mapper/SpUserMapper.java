package com.evo.sp.basis.mapper;

import com.evo.sp.basis.entity.SpUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.evo.sp.basis.entity.vo.SpRolePermissionsVo;
import com.evo.sp.basis.entity.vo.SpUserVo;
import com.evo.sp.common.ex.BaseException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author sgt
 * @since 2019-03-27
 */
public interface SpUserMapper extends BaseMapper<SpUser> {

    SpUser userByname(String name) throws BaseException;

}
