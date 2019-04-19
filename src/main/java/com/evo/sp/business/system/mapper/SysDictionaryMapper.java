package com.evo.sp.business.system.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evo.sp.business.system.entity.SysDictionary;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.evo.sp.business.system.entity.vo.SysDictionaryVo;

import java.util.List;

/**
 * <p>
 * 字典表 Mapper 接口
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
public interface SysDictionaryMapper extends BaseMapper<SysDictionary> {
    /**
     *
     * 根据名称查询/pid
     */
    Page<SysDictionary> queryByNamePid(Page page,SysDictionaryVo vo);
}
