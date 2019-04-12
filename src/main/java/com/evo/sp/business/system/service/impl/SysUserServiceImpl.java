package com.evo.sp.business.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evo.sp.business.system.entity.SysUser;
import com.evo.sp.business.system.entity.SysUserInfo;
import com.evo.sp.business.system.entity.vo.SysUserVo;
import com.evo.sp.business.system.mapper.SysUserInfoMapper;
import com.evo.sp.business.system.mapper.SysUserMapper;
import com.evo.sp.business.system.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.ex.SpAssert;
import com.evo.sp.common.result.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {


    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * 查询用户信息，根据组织（机构）id
     *
     * @param page
     * @param userVo
     */
    @Override
    public Result queryUserByOrg(Page page, SysUserVo userVo) {
        SpAssert.isNull(userVo.getSysOrganizationId());
        return new Result(sysUserMapper.queryUserByOrg(page, userVo));
    }

    /**
     * 查询用户信息通过id
     *
     * @param id
     */
    @Override
    public Result queryUserById(Serializable id) {
        SpAssert.isNull(id);
        return new Result(sysUserMapper.queryUserById(id));
    }
}
