package com.evo.sp.business.system.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evo.sp.business.system.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.evo.sp.business.system.entity.vo.SysUserVo;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     *
     * 查询用户信息，根据组织（机构）id
     */
    Page<SysUserVo> queryUserByOrg(Page page,SysUserVo u);
    
    /**
     *
     * 通过用户id查询用户信息
     */
    SysUserVo queryUserById(Serializable id);
}
