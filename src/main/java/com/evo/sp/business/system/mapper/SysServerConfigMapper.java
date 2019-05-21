package com.evo.sp.business.system.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evo.sp.business.system.entity.SysServerConfig;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.evo.sp.business.system.entity.vo.SysServerConfigVo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author sgt
 * @since 2019-04-25
 */
public interface SysServerConfigMapper extends BaseMapper<SysServerConfig> {
    /**
     * 获取当前启用的FTP服务配置项
     */
    List<SysServerConfig> queryList();

    /**
     *
     * 查询服务配置信息
     */
    IPage<SysServerConfigVo> queryServerConfig(Page page, SysServerConfigVo vo);
    /**
     *
     * 根据字典id查询服务配置信息
     */
    Map<String,Object> queryServerConfigPageByDisId(Page page,String sysDictionaryId);
}
