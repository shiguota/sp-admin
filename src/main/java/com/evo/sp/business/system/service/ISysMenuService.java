package com.evo.sp.business.system.service;

import com.evo.sp.business.system.entity.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
public interface ISysMenuService extends IService<SysMenu> {
    /**
     *
     * 查询用户可用菜单
     */
    List<SysMenu> queryMenuPath(String account);
}
