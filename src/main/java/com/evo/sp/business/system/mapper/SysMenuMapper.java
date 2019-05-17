package com.evo.sp.business.system.mapper;

import com.evo.sp.business.system.entity.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.evo.sp.business.system.entity.vo.SysMenuVo;
import com.evo.sp.common.result.Result;
import org.apache.ibatis.annotations.Param;

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
    List<SysMenuVo> queryMenuByUserAccount(@Param("account") String account, @Param("level") Integer level);
}
