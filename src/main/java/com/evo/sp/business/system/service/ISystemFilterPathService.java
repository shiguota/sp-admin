package com.evo.sp.business.system.service;

import com.evo.sp.business.system.entity.SystemFilterPath;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sgt
 * @since 2019-04-05
 */
public interface ISystemFilterPathService extends IService<SystemFilterPath> {
    LinkedList<SystemFilterPath> queryFilePath();
}
