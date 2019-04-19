package com.evo.sp.business.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.evo.sp.business.system.entity.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.evo.sp.business.system.entity.vo.SysMenuVo;
import com.evo.sp.common.parameter.PageRequestParameter;
import com.evo.sp.common.result.Result;
import com.evo.sp.common.tree.Tree;

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
    List<Tree<SysMenu>> queryMenuPath();

    /**
     *
     * 增加菜单
     */
    Result menuSave(SysMenuVo sysMenuVo);

    /**
     *
     *分页查询
     */
    Result queryListPage(PageRequestParameter<SysMenuVo> pageRequestParameter);
}
