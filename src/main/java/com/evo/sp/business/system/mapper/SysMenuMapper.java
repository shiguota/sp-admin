package com.evo.sp.business.system.mapper;

import com.evo.sp.business.system.entity.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.evo.sp.common.result.Result;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     *
     * 查询用户可用菜单
     */
    List<SysMenu> queryMenuPath(String account);
}
