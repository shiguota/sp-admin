package com.evo.sp.business.system.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evo.sp.business.system.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.evo.sp.business.system.entity.vo.SysRoleVo;
import com.evo.sp.business.system.entity.vo.SysUserVo;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

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
    Page<Map> queryUserByOrg(Page page, SysUserVo u);
    
    /**
     *
     * 通过用户id查询用户信息
     */
    SysUserVo queryUserById(String id);
    
    /**
     *
     * 根据用户id获取账号已存在的角色
     */
    List<SysRoleVo> queryRoleById(String id);

    /**
     *通过当前登录账号的信息，获取当前账号下的角色（不包括，已经分配给选中的当前账号的角色）
     *
     * @param loginId 当前登录系统的用户id
     * @param seleId  被选中账号的用户id
     */
    List<SysRoleVo> queryUnRoleById(String loginId,String seleId);
}
