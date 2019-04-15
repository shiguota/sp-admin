package com.evo.sp.business.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evo.sp.business.system.entity.SysRole;
import com.evo.sp.business.system.entity.vo.SysRoleVo;
import com.evo.sp.business.system.mapper.SysRoleMapper;
import com.evo.sp.business.system.mapper.SysRolePermissionMapper;
import com.evo.sp.business.system.service.ISysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.ex.SaveException;
import com.evo.sp.common.ex.SpAssert;
import com.evo.sp.common.result.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;
import java.util.List;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;

    /**
     * 根据账号获取角色
     *
     * @param account
     */
    @Override
    public List<SysRole> queryRoleByAccount(String account) {
        return sysRoleMapper.getRoleByAccount(account);
    }

    /**
     * 根据组织（机构）id查询角色
     *
     * @param sysRoleVo
     */
    @Override
    public Result queryByNameOrg(Page page,SysRoleVo sysRoleVo) {
        SpAssert.isNull(sysRoleVo.getOrgId());
        return new Result(sysRoleMapper.queryByNameOrg(page,sysRoleVo));
    }

    /**
     * 新增角色
     *
     * @param sysRoleVo
     */
    @Override
    @Transactional
    public Result saveRole(SysRoleVo sysRoleVo) {
        //创建角色对象
        SysRole sysRole = new SysRole();
        //校验参数
        SpAssert.isNull(sysRoleVo);
        //转换类型
        BeanUtils.copyProperties(sysRoleVo,sysRole);
        //判断是否添加成功
        int saveRple = sysRoleMapper.insert(sysRole);
        if (saveRple == SpConstantInter.CURDVAL) {
            //校验是否为角色配置相对应的权限
            if (SpAssert.isNotNull(sysRoleVo.getSysRolePermission())) {
                //为角色配置权限后，则应对角色和权限做关联
                if (sysRolePermissionMapper.insert(sysRoleVo.getSysRolePermission()) == SpConstantInter.CURDVAL) {
                    throw new SaveException();
                }
            }
        }else{
            throw new SaveException();
        }


        return null;
    }
}
