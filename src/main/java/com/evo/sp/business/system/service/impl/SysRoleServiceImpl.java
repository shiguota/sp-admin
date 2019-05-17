package com.evo.sp.business.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evo.sp.business.system.controller.SysOrganizationRoleController;
import com.evo.sp.business.system.entity.SysOrganizationRole;
import com.evo.sp.business.system.entity.SysRole;
import com.evo.sp.business.system.entity.SysRolePermission;
import com.evo.sp.business.system.entity.vo.SysRoleVo;
import com.evo.sp.business.system.mapper.SysOrganizationRoleMapper;
import com.evo.sp.business.system.mapper.SysRoleMapper;
import com.evo.sp.business.system.mapper.SysRolePermissionMapper;
import com.evo.sp.business.system.service.ISysOrganizationRoleService;
import com.evo.sp.business.system.service.ISysRolePermissionService;
import com.evo.sp.business.system.service.ISysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.ex.DelException;
import com.evo.sp.common.ex.SaveException;
import com.evo.sp.common.ex.SpAssert;
import com.evo.sp.common.ex.SpParameterException;
import com.evo.sp.common.result.Result;
import com.evo.sp.common.result.ResultEnum;
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
    private ISysRolePermissionService iSysRolePermissionService;
    @Autowired
    private ISysOrganizationRoleService iSysOrganizationRoleService;

    /**
     * 根据账号获取角色
     *
     * @param account
     */
    @Override
    public List<SysRole> queryRoleByAccount(String account) {
        SpAssert.isNull(account);
        return sysRoleMapper.queryRoleByAccount(account);
    }

    /**
     * 根据组织（机构）id查询角色
     *
     * @param sysRoleVo
     */
    @Override
    public Result queryByNameOrg(Page page, SysRoleVo sysRoleVo) {
        //校验参数
        SpAssert.isNull(sysRoleVo);
        SpAssert.isNull(sysRoleVo.getOrgId());
        SpAssert.sortAssert(sysRoleVo.getcSortType());
        SpAssert.sortAssert(sysRoleVo.getuSortType());
        //排序功能不支持同时多个字段
        if (SpAssert.isNotNull(sysRoleVo.getcSortType()) && SpAssert.isNotNull(sysRoleVo.getuSortType())) {
            throw new SpParameterException();
        }else if(!SpAssert.isNotNull(sysRoleVo.getcSortType()) && !SpAssert.isNotNull(sysRoleVo.getuSortType())){
            sysRoleVo.setcSortType(SpConstantInter.DESC);
        }
        return new Result(sysRoleMapper.queryByNameOrg(page, sysRoleVo));
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
        SpAssert.isNull(sysRoleVo.getOrgId());
        SpAssert.isNull(sysRoleVo.getRoleCode());
        SpAssert.isNull(sysRoleVo.getRoleName());
        //转换类型
        BeanUtils.copyProperties(sysRoleVo, sysRole);
        //判断是否添加成功
        int saveRple = sysRoleMapper.insert(sysRole);
        if (saveRple != SpConstantInter.CURDVAL) {
            throw new SaveException();
        } else {
            //新增机构角色数据
            SysOrganizationRole sysOrganizationRole = new SysOrganizationRole();
            sysOrganizationRole.setSysRoleId(sysRole.getId());
            sysOrganizationRole.setSysOrganizationId(sysRoleVo.getOrgId());
            if (!iSysOrganizationRoleService.save(sysOrganizationRole)) {
                throw new SaveException();
            }
        }
        return new Result(true);
    }

    /**
     * 为角色授权
     *
     * @param sysRoleVo
     */
    @Override
    public Result authorizationRole(SysRoleVo sysRoleVo) {
        //校验参数
        SpAssert.isNull(sysRoleVo);
        //校验是否为角色配置相对应的权限
        if (SpAssert.isNotNull(sysRoleVo.getSysRolePermission())) {
            //获取为用户匹配的角色列表对象
            List<SysRolePermission> sysRolePermission = sysRoleVo.getSysRolePermission();
            for (SysRolePermission rolePermission : sysRolePermission) {
                //为角色权限对象，添加角色id
                rolePermission.setSysRoleId(sysRoleVo.getRoleId());
            }
            //为角色配置权限后，则应对角色和权限做关联,保存失败抛出异常
            if (!iSysRolePermissionService.saveBatch(sysRolePermission)) {
                throw new SaveException();
            }
        }

        return null;
    }

    /**
     * 修改角色
     *
     * @param sysRoleVo
     */
    @Override
    @Transactional
    public Result modifyRole(SysRoleVo sysRoleVo) {
        //检验参数
        SpAssert.isNull(sysRoleVo);
        SpAssert.isNull(sysRoleVo.getRoleId());
        SysRole sysRole = new SysRole();
        BeanUtils.copyProperties(sysRoleVo, sysRole);
        sysRole.setId(sysRoleVo.getRoleId());
        if (!updateById(sysRole)) {
            throw new SaveException();
        }
        //机构id是否为空
        if (SpAssert.isNotNull(sysRoleVo.getOrgId())) {
            //如果组织机构id不为空，做更新操作
            SysOrganizationRole organizationRole = new SysOrganizationRole();
            organizationRole.setSysRoleId(sysRoleVo.getOrgId());
            QueryWrapper<SysOrganizationRole> wrapper = new QueryWrapper<>();
            wrapper.eq(SpConstantInter.SYS_ORG_ROLEID, sysRoleVo.getRoleId());
            if (!iSysOrganizationRoleService.update(organizationRole, wrapper)) {
                throw new SaveException();
            }

        }
        return new Result(true);
    }

    /**
     * 删除角色，同时删除机构角色表中的相关信息
     *
     * @param ids
     */
    @Override
    @Transactional
    public Result delRoles(List<String> ids) {
        if (removeByIds(ids)) { //删除角色表信息
            for (String id : ids) {
                if (iSysOrganizationRoleService.remove( // 删除机构角色表信息
                        new UpdateWrapper<SysOrganizationRole>().eq(SpConstantInter.SYS_ORG_ROLEID, id))) {
                    return new Result(ResultEnum.REMOVE_SUCCESS.getValue());
                } else {
                    throw new DelException();
                }
            }
        } else {
            throw new DelException();
        }
        return null;
    }
}
