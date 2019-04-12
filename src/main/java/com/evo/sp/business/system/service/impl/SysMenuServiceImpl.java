package com.evo.sp.business.system.service.impl;

import com.evo.sp.business.system.entity.SysMenu;
import com.evo.sp.business.system.mapper.SysMenuMapper;
import com.evo.sp.business.system.service.ISysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.evo.sp.common.ex.SpAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {


    @Autowired
    private SysMenuMapper sysMenuMapper;


    /**
     * 查询用户可用菜单
     *
     * @param account
     */
    @Override
    public List<SysMenu> queryMenuPath(String account) {
        SpAssert.isNull(account);
        return sysMenuMapper.queryMenuPath(account);
    }
}
