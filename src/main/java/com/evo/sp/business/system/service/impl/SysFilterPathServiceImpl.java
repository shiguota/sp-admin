package com.evo.sp.business.system.service.impl;

import com.evo.sp.business.system.entity.SysFilterPath;
import com.evo.sp.business.system.mapper.SysFilterPathMapper;
import com.evo.sp.business.system.service.ISysFilterPathService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class SysFilterPathServiceImpl extends ServiceImpl<SysFilterPathMapper, SysFilterPath> implements ISysFilterPathService {

    @Autowired
    private SysFilterPathMapper systemFilterPathMapper;

    @Override
    public LinkedList<SysFilterPath> queryFilePath() {
        return systemFilterPathMapper.queryFilePath();
    }
}
