package com.evo.sp.business.system.mapper;

import com.evo.sp.business.system.entity.SystemRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author sgt
 * @since 2019-03-27
 */
public interface SystemRoleMapper extends BaseMapper<SystemRole> {

    /**
    * @Description:通过用户名称获取当前用户拥有的角色
    * @Param:  
    * @return:  
    * @Author: 史国涛
    * @Date: 2019-03-28 
    */
    List<SystemRole> getRoleByUname(String name) ;

}
