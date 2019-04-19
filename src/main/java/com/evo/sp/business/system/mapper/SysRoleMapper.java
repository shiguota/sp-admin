package com.evo.sp.business.system.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evo.sp.business.system.entity.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.evo.sp.business.system.entity.vo.SysRoleVo;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {
    /**
     *
     * 根据账号获取角色
     */
    List<SysRole> queryRoleByAccount(String account);
    
    /**
     *
     * 根据组织（机构）id查询角色
     */
    Page<SysRole> queryByNameOrg(Page page,SysRoleVo sysRoleVo);
}
