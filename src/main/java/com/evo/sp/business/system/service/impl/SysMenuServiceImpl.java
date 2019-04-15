package com.evo.sp.business.system.service.impl;

import com.evo.sp.business.system.entity.SysMenu;
import com.evo.sp.business.system.entity.SysMenuPermission;
import com.evo.sp.business.system.entity.vo.SysMenuVo;
import com.evo.sp.business.system.mapper.SysMenuMapper;
import com.evo.sp.business.system.mapper.SysMenuPermissionMapper;
import com.evo.sp.business.system.service.ISysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.ex.SaveException;
import com.evo.sp.common.ex.SpAssert;
import com.evo.sp.common.result.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Autowired
    private SysMenuPermissionMapper sysMenuPermissionMapper;

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

    /**
     * 增加菜单
     *
     * @param sysMenuVo
     */
    @Override
    @Transactional
    public Result menuSave(SysMenuVo sysMenuVo) {
        //声明需要保存的菜单对象
        SysMenu sysMenu = new SysMenu();
        String menuId = null;
        //校验参数
        SpAssert.isNull(sysMenuVo);
        //转换参数类型
        BeanUtils.copyProperties(sysMenuVo,sysMenu);
        //新增菜单操作
        int insert = sysMenuMapper.insert(sysMenu);
        if(insert == SpConstantInter.CURDVAL){
            //获取菜单权限参数
            SysMenuPermission sysMenuPermission = sysMenuVo.getSysMenuPermission();
            sysMenuPermission.setSysMenuId(menuId);
            //校验菜单权限参数
            if (SpAssert.isNotNull(sysMenuPermission)) {
                if (sysMenuPermissionMapper.insert(sysMenuPermission) == SpConstantInter.CURDVAL) {
                    throw new SaveException();
                }
            }
        }else{
            throw new SaveException();
        }
        return null;
    }
}
