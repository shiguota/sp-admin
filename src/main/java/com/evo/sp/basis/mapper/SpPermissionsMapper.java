package com.evo.sp.basis.mapper;

import com.evo.sp.basis.entity.SpPermissions;
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
public interface SpPermissionsMapper extends BaseMapper<SpPermissions> {
    /**
    * @Description:通过角色名称获取权限
    * @Param: name：角色权限
    * @return: 权限列表
    * @Author: 史国涛
    * @Date: 2019-03-28
    */
    List<SpPermissions> getPermissionsByRName(String name);

}
