package com.evo.sp.business.system.mapper;

import com.evo.sp.business.system.entity.SysFilterPath;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.LinkedList;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author sgt
 * @since 2019-04-05
 */
public interface SysFilterPathMapper extends BaseMapper<SysFilterPath> {
    
    /**
     *
     * 获取过滤路径
     */
    LinkedList<SysFilterPath> queryFilePath();

}
