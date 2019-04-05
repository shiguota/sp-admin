package com.evo.sp.business.system.mapper;

import com.evo.sp.business.system.entity.SystemFilterPath;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author sgt
 * @since 2019-04-05
 */
public interface SystemFilterPathMapper extends BaseMapper<SystemFilterPath> {

    LinkedList<SystemFilterPath> queryFilePath();

}
