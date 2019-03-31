package com.evo.sp.basis.mapper;

import com.evo.sp.basis.entity.SpRole;
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
public interface SpRoleMapper extends BaseMapper<SpRole> {

    /**
    * @Description:通过用户名称获取当前用户拥有的角色
    * @Param:  
    * @return:  
    * @Author: 史国涛
    * @Date: 2019-03-28 
    */
    List<SpRole> getRoleByUname(String name) ;

}
