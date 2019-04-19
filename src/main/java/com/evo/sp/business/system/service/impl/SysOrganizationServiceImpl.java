package com.evo.sp.business.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evo.sp.business.system.entity.SysOrganization;
import com.evo.sp.business.system.entity.SysUser;
import com.evo.sp.business.system.entity.vo.SysOrganizationVo;
import com.evo.sp.business.system.mapper.SysOrganizationMapper;
import com.evo.sp.business.system.service.ISysOrganizationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.ex.SpAssert;
import com.evo.sp.common.parameter.PageRequestParameter;
import com.evo.sp.common.result.Result;
import com.evo.sp.common.tree.Tree;
import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
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
public class SysOrganizationServiceImpl extends ServiceImpl<SysOrganizationMapper, SysOrganization> implements ISysOrganizationService {


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
        //获取page对象
        Page page = sysOrganizationVoPageRequestParameter.pageInstance();
        //获取参数对象
        SysOrganizationVo sysOrganizationVo = sysOrganizationVoPageRequestParameter.parameterInstance();
        //校验参数
        SpAssert.isNull(sysOrganizationVo);
        SpAssert.isNull(sysOrganizationVo.getId());
        //创建queryWrapper
        QueryWrapper<SysOrganization> queryWrapper = new QueryWrapper<>();
        //如果查询条件"机构名称不为空"，添加查询条件
        if (SpAssert.isNotNull(sysOrganizationVo.getOrgName())) {
            queryWrapper.like(SpConstantInter.SYS_ORG_NAME,sysOrganizationVo.getOrgName());
        }
        queryWrapper.eq(SpConstantInter.PID,sysOrganizationVo.getId());
        return new Result(page(page,queryWrapper));
    }

    /**
     * 根据条件获取机构（树结构）
     *
     * @param
     */
    @Override
    public List<Tree<SysOrganizationVo>> queryListTree() {
        //获取session中user对象
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        SysUser sysUser = (SysUser) session.getAttribute(SpConstantInter.USER);
        //校验参数
        SpAssert.isNull(sysUser);
        SpAssert.isNull(sysUser.getAccount());
        //创建
        List<Tree<SysOrganizationVo>> trees = new ArrayList<>();
        List<SysOrganizationVo> sysOrganizationVos = sysOrganizationMapper.queryListPage(sysUser.getAccount());
        for (SysOrganizationVo sysOrganizationVo : sysOrganizationVos) {
            Tree<SysOrganizationVo> sysOrganizationVoTree = new Tree<>();
            sysOrganizationVoTree.setId(sysOrganizationVo.getId());
            sysOrganizationVoTree.setParentId(sysOrganizationVo.getPid());
            sysOrganizationVoTree.setText(sysOrganizationVo.getAreaName());
            trees.add(sysOrganizationVoTree);
        }
        return trees;
    }
}
