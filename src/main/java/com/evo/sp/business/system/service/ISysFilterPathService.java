package com.evo.sp.business.system.service;

import com.evo.sp.business.system.entity.SysFilterPath;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.LinkedList;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sgt
 * @since 2019-04-05
 */
public interface ISysFilterPathService extends IService<SysFilterPath> {
    LinkedList<SysFilterPath> queryFilePath();
}
