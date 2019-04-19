package com.evo.sp.business.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evo.sp.business.system.entity.SysMenu;
import com.evo.sp.business.system.entity.SysMenuPermission;
import com.evo.sp.business.system.entity.SysUser;
import com.evo.sp.business.system.entity.vo.SysMenuVo;
import com.evo.sp.business.system.mapper.SysMenuMapper;
import com.evo.sp.business.system.mapper.SysMenuPermissionMapper;
import com.evo.sp.business.system.service.ISysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.ex.SaveException;
import com.evo.sp.common.ex.SessionException;
import com.evo.sp.common.ex.SpAssert;
import com.evo.sp.common.parameter.PageRequestParameter;
import com.evo.sp.common.result.Result;
import com.evo.sp.common.tree.Tree;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
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
     */
    @Override
    public List<Tree<SysMenu>> queryMenuPath() {
        List<Tree<SysMenu>> trees = new ArrayList<>();
        //获取session中的用户信息
        SysUser sysUser = (SysUser) SecurityUtils.getSubject().getSession().getAttribute(SpConstantInter.USER);
        //校验用户信息
        if (SpAssert.isNotNull(sysUser)) {
            if (SpAssert.isNotNull(sysUser.getAccount())) {
                List<SysMenu> sysMenus = sysMenuMapper.queryMenuPath(sysUser.getAccount());
                //构建树结构数据
                for (SysMenu sysMenu : sysMenus) {
                    Tree<SysMenu> sysMenuTree = new Tree<>();
                    sysMenuTree.setId(sysMenu.getId());
                    sysMenuTree.setParentId(sysMenu.getPid());
                    sysMenuTree.setText(sysMenu.getMenuName());
                    trees.add(sysMenuTree);
                }
            } else {
                throw new SessionException();
            }
        } else {
            throw new SessionException();
        }
        return trees;
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
        //校验参数
        SpAssert.isNull(sysMenuVo);
        //转换参数类型
        BeanUtils.copyProperties(sysMenuVo, sysMenu);
        //新增菜单操作
        int insert = sysMenuMapper.insert(sysMenu);
        if (insert == SpConstantInter.CURDVAL) {
            //获取菜单权限参数
            SysMenuPermission sysMenuPermission = sysMenuVo.getSysMenuPermission();
            //校验菜单权限参数
            if (SpAssert.isNotNull(sysMenuPermission)) {
                sysMenuPermission.setSysMenuId(sysMenu.getId());
                if (sysMenuPermissionMapper.insert(sysMenuPermission) == SpConstantInter.CURDVAL) {
                    throw new SaveException();
                }
            }
        } else {
            throw new SaveException();
        }
        return null;
    }

    /**
     * 分页查询
     *
     * @param pageRequestParameter
     */
    @Override
    public Result queryListPage(PageRequestParameter<SysMenuVo> pageRequestParameter) {
        //排序类型
        boolean isAsc = false;
        //获取分页对象
        Page page = pageRequestParameter.pageInstance();
        //获取查询条件
        SysMenuVo sysMenuVo = pageRequestParameter.parameterInstance();
        //创建wrapper
        QueryWrapper<SysMenu> sysMenuQueryWrapper = new QueryWrapper<>();
        //校验参数
        if (SpAssert.isNotNull(sysMenuVo)) {
            //设置pid查询某个菜单下的子菜单
            if (SpAssert.isNotNull(sysMenuVo.getId())) {
                sysMenuQueryWrapper.eq(SpConstantInter.PID, sysMenuVo.getId());
            }
            //根据菜单名模糊查询
            if (SpAssert.isNotNull(sysMenuVo.getMenuName())) {
                sysMenuQueryWrapper.like(SpConstantInter.SYS_MENU_NAME, sysMenuVo.getMenuName());
            }
            //根据创建时间排序
            if (SpAssert.isNotNull(sysMenuVo.getCSortType())) {
                if (sysMenuVo.getCSortType().equals(SpConstantInter.ASC)) {
                    isAsc = true;
                }
                sysMenuQueryWrapper.orderBy(true, isAsc, SpConstantInter.TABLE_CREATE_TIME);
                //根据修改时间排序
            } else if (SpAssert.isNotNull(sysMenuVo.getUSortType())) {
                if (sysMenuVo.getUSortType().equals(SpConstantInter.ASC)) {
                    isAsc = true;
                }
                sysMenuQueryWrapper.orderBy(true, isAsc, SpConstantInter.TABLE_UPDATE_TIME);
                //默认通过手动排序
            } else {
                sysMenuQueryWrapper.orderBy(true, true, SpConstantInter.SORT);
            }
        } else {
            SpAssert.isNull(sysMenuVo);
        }

        return new Result(page(page, sysMenuQueryWrapper));
    }
}
