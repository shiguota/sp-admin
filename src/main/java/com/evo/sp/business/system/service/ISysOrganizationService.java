package com.evo.sp.business.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.evo.sp.business.system.entity.SysOrganization;
import com.evo.sp.business.system.entity.vo.SysOrganizationVo;
import com.evo.sp.common.BaseService;
import com.evo.sp.common.parameter.PageRequestParameter;
import com.evo.sp.common.result.Result;
import com.evo.sp.common.tree.Tree;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 组织机构表 服务类
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
public interface ISysOrganizationService extends IService<SysOrganization> {

    /**
     * 根据机构id查询子机构（分页）
     */
    Result queryListPage(PageRequestParameter<SysOrganizationVo> sysOrganizationVoPageRequestParameter);

    /**
     *
     * 根据用户id查询组织机构
     */
    List<Tree<SysOrganization>> queryOrgByUserId(String userId);
}
