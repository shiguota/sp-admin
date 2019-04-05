package com.evo.sp.business.system.service.impl;

import com.evo.sp.business.system.entity.SystemFilterPath;
import com.evo.sp.business.system.mapper.SystemFilterPathMapper;
import com.evo.sp.business.system.service.ISystemFilterPathService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sgt
 * @since 2019-04-05
 */
@Service
public class SystemFilterPathServiceImpl extends ServiceImpl<SystemFilterPathMapper, SystemFilterPath> implements ISystemFilterPathService {

    @Autowired
    private SystemFilterPathMapper systemFilterPathMapper;

    @Override
    public LinkedList<SystemFilterPath> queryFilePath() {
        return systemFilterPathMapper.queryFilePath();
    }
}
