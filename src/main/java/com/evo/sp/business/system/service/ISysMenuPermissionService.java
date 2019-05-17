package com.evo.sp.business.system.service;

import com.evo.sp.business.system.entity.SysMenuPermission;
import com.baomidou.mybatisplus.extension.service.IService;
import com.evo.sp.business.system.entity.vo.SysMenuPermissionVo;
import com.evo.sp.business.system.mapper.SysMenuPermissionMapper;
import com.evo.sp.common.result.Result;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 菜单权限表 服务类
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
public interface ISysMenuPermissionService extends IService<SysMenuPermission> {


    /**
     *
     * 菜单授权
     */
    Result saveMenuPermission(SysMenuPermissionVo sysMenuPermissionVo);


}
