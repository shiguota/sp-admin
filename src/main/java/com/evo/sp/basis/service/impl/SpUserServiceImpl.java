package com.evo.sp.basis.service.impl;

import com.evo.sp.basis.entity.SpUser;
import com.evo.sp.basis.entity.vo.SpRolePermissionsVo;
import com.evo.sp.basis.entity.vo.SpUserVo;
import com.evo.sp.basis.mapper.SpUserMapper;
import com.evo.sp.basis.service.ISpUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.evo.sp.common.SpAssert;
import com.evo.sp.common.annotations.SpLogService;
import com.evo.sp.common.ex.BaseException;
import org.apache.shiro.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sgt
 * @since 2019-03-27
 */
@Service
public class SpUserServiceImpl extends ServiceImpl<SpUserMapper, SpUser> implements ISpUserService {


    @Autowired
    private SpUserMapper spUserMapper;

    @Override
    @SpLogService(description = "这是一个测试")
    public SpUser userByname(String name) throws BaseException {
        SpAssert.isNull(name);
        SpUser spUser = spUserMapper.userByname(name);
        return spUser;
    }
}
