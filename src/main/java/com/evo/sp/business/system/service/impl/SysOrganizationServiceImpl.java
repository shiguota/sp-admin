package com.evo.sp.business.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evo.sp.business.system.entity.SysOrganization;
import com.evo.sp.business.system.entity.SysUser;
import com.evo.sp.business.system.entity.vo.SysOrganizationVo;
import com.evo.sp.business.system.mapper.SysOrganizationMapper;
import com.evo.sp.business.system.service.ISysOrganizationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.evo.sp.common.BaseServiceImpl;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.ex.SessionException;
import com.evo.sp.common.ex.SpAssert;
import com.evo.sp.common.parameter.PageRequestParameter;
import com.evo.sp.common.result.Result;
import com.evo.sp.common.tree.Tree;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 组织机构表 服务实现类
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
@Service
public class SysOrganizationServiceImpl extends BaseServiceImpl<SysOrganizationMapper, SysOrganization> implements ISysOrganizationService {


    @Autowired
    private SysOrganizationMapper sysOrganizationMapper;

    /**
     * 根据机构id查询子机构（分页）
     *
     * @param sysOrganizationVoPageRequestParameter
     */
    @Override
    public Result queryListPage(PageRequestParameter<SysOrganizationVo> sysOrganizationVoPageRequestParameter) {
        SpAssert.isNull(sysOrganizationVoPageRequestParameter);
        boolean isAsc = true;
        //获取page对象
        Page page = sysOrganizationVoPageRequestParameter.pageInstance();
        //获取参数对象
        SysOrganizationVo sysOrganizationVo = sysOrganizationVoPageRequestParameter.parameterInstance();
        SpAssert.isNull(sysOrganizationVo);
        SpAssert.isNull(sysOrganizationVo.getId());
        SpAssert.sortAssert(sysOrganizationVo.getOrgSort());
        SpAssert.sortAssert(sysOrganizationVo.getcSortType());
        SpAssert.sortAssert(sysOrganizationVo.getuSortType());
        //创建queryWrapper
        QueryWrapper<SysOrganization> queryWrapper = new QueryWrapper<>();
        //校验参数
        if (SpAssert.isNotNull(sysOrganizationVo)) {
            //设置pid查询某个菜单下的子菜单
            if (SpAssert.isNotNull(sysOrganizationVo.getId())) {
                queryWrapper.eq(SpConstantInter.PID, sysOrganizationVo.getId());
            }
            //如果查询条件"机构名称不为空"，添加查询条件
            if (SpAssert.isNotNull(sysOrganizationVo.getOrgName())) {
                queryWrapper.like(SpConstantInter.SYS_ORG_NAME,sysOrganizationVo.getOrgName());
            }
            //根据创建时间排序
            if (SpAssert.isNotNull(sysOrganizationVo.getcSortType())) {
                if (sysOrganizationVo.getcSortType().equals(SpConstantInter.DESC)) {
                    isAsc = false;
                }
                queryWrapper.orderBy(true, isAsc, SpConstantInter.TABLE_CREATE_TIME);
                //根据修改时间排序
            } else if (SpAssert.isNotNull(sysOrganizationVo.getuSortType())) {
                if (sysOrganizationVo.getuSortType().equals(SpConstantInter.DESC)) {
                    isAsc = false;
                }
                queryWrapper.orderBy(true, isAsc, SpConstantInter.TABLE_UPDATE_TIME);
                //默认通过手动排序
            } else {
                if (SpAssert.isNotNull(sysOrganizationVo.getOrgSort())) {
                    if (sysOrganizationVo.getOrgSort().equals(SpConstantInter.DESC)) {
                        isAsc = false;
                    }
                }
                queryWrapper.orderBy(true, isAsc, SpConstantInter.SORT);
            }
        }
        queryWrapper.eq(SpConstantInter.PID,sysOrganizationVo.getId());
        return new Result(page(page,queryWrapper));
    }

    /**
     * 根据用户id查询组织机构
     *
     * @param userId
     */
    @Override
    public List<Tree<SysOrganization>> queryOrgByUserId(String userId) {
        SpAssert.isNull(userId);
        //获取session中user对象
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        SysUser sysUser = (SysUser) session.getAttribute(session.getId());
        //校验参数
        SpAssert.isNull(sysUser);
        if (!sysUser.getId().equals(userId)) {
            throw new SessionException();
        }
        List<SysOrganization> sysOrganizations = sysOrganizationMapper.queryOrgByUserId(userId);
        return queryTree(sysOrganizations,null);
    }

    @Override
    public List<Tree<SysOrganization>> queryTree(List<SysOrganization> list, String treeId) {
        return super.queryTree(list,treeId);
    }
}
