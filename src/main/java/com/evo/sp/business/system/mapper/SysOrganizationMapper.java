package com.evo.sp.business.system.mapper;

import com.evo.sp.business.system.entity.SysOrganization;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.evo.sp.business.system.entity.vo.SysOrganizationVo;

import java.util.List;

/**
 * <p>
 * 组织机构表 Mapper 接口
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
public interface SysOrganizationMapper extends BaseMapper<SysOrganization> {

    /**
     *
     * 根据条件获取机构（树结构）
     */
    List<SysOrganizationVo> queryListPage(String account);

}
