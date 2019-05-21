package com.evo.sp.business.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.injector.methods.UpdateById;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evo.sp.business.system.entity.SysServerConfig;
import com.evo.sp.business.system.entity.vo.SysServerConfigVo;
import com.evo.sp.business.system.mapper.SysServerConfigMapper;
import com.evo.sp.business.system.service.ISysServerConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.ex.SpAssert;
import com.evo.sp.common.parameter.PageRequestParameter;
import com.evo.sp.common.result.Result;
import com.evo.sp.common.result.ResultEnum;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author sgt
 * @since 2019-04-25
 */
@Service
public class SysServerConfigServiceImpl extends ServiceImpl<SysServerConfigMapper, SysServerConfig> implements ISysServerConfigService {

    @Autowired
    private SysServerConfigMapper sysServerConfigMapper;


    /**
     * 获取当前启用的FTP服务配置项
     */
    @Override
    public List<SysServerConfig> queryList() {
        return sysServerConfigMapper.queryList();
    }

    /**
     * 新增
     *
     * @param sysServerConfigVo
     */
    @Override
    public Result saveServerConfig(SysServerConfigVo sysServerConfigVo) {
        //校验数据
        SpAssert.isNull(sysServerConfigVo);
        if (!SpAssert.isNotNull(sysServerConfigVo.getSysDictionaryId())) {
            SpAssert.isNull(sysServerConfigVo.getServerKey());
            SpAssert.isNull(sysServerConfigVo.getServerValue());
        }
        //通过复制对象进行类型转换
        SysServerConfig sysServerConfig = new SysServerConfig();
        BeanUtils.copyProperties(sysServerConfigVo, sysServerConfig);
        //新增操作并返回结果
        return new Result(save(sysServerConfig));
    }

    /**
     * 启用/停止FTP服务器（根据字典id）
     *
     * @param disId
     */
    @Override
    public Result startServerConfig(String disId) {
        //校验参数
        SpAssert.isNull(disId);
        SysServerConfig sysServerConfig = new SysServerConfig();
        sysServerConfig.setState(1);
        boolean update = update(sysServerConfig, new QueryWrapper<SysServerConfig>().eq(SpConstantInter.SYS_DICTIONARY_ID, disId));
        if (update) {
            return new Result(update, ResultEnum.OPERATION_SUCCESS.getValue());
        }
        return new Result(update, ResultEnum.OPERATION_FAIL.getValue());
    }

    /**
     * 修改(根据id)
     *
     * @param sysServerConfig
     */
    @Override
    public Result modifyServerConfig(SysServerConfig sysServerConfig) {
        //校验参数
        SpAssert.isNull(sysServerConfig);
        SpAssert.isNull(sysServerConfig.getId());
        SpAssert.isNull(sysServerConfig.getServerKey());
        SpAssert.isNull(sysServerConfig.getServerValue());
        boolean b = updateById(sysServerConfig);
        if (b) {
            return new Result(b, ResultEnum.MODIFY_SUCCESS.getValue());
        }
        return new Result(b, ResultEnum.MODIFY_FAIL.getValue());
    }

    /**
     * 配置项列表（分页）
     *
     * @param pageRequestParameter
     */
    @Override
    public Result queryServerConfigPage(PageRequestParameter<SysServerConfigVo> pageRequestParameter) {
        //参数校验
        SpAssert.isNull(pageRequestParameter);
        SysServerConfigVo sysServerConfigVo = pageRequestParameter.parameterInstance();
        if (SpAssert.isNotNull(sysServerConfigVo)) {
            SpAssert.sortAssert(sysServerConfigVo.getcSortType());
            SpAssert.sortAssert(sysServerConfigVo.getuSortType());
        }
        //如果参数为空,设置默认参数
        if (!SpAssert.isNotNull(pageRequestParameter)) {
            SysServerConfigVo configVo = new SysServerConfigVo();
            configVo.setcSortType(SpConstantInter.DESC);
            pageRequestParameter = new PageRequestParameter();
            pageRequestParameter.setParameter(configVo);
        }
        IPage iPage = sysServerConfigMapper.queryServerConfig(pageRequestParameter.pageInstance(),
                pageRequestParameter.parameterInstance());
        return new Result(iPage);
    }

    /**
     * 根据字典id查询服务配置信息
     *
     * @param parameter
     */
    @Override
    public Result queryServerConfigPageByDisId(PageRequestParameter<SysServerConfig> parameter) {
        //校验参数
        SpAssert.isNull(parameter);
        SpAssert.isNull(parameter.parameterInstance());
        Page page = parameter.pageInstance();
        SysServerConfig sysServerConfig = parameter.parameterInstance();
        return new Result(sysServerConfigMapper.queryServerConfigPageByDisId(page,sysServerConfig.getSysDictionaryId()));
    }


}
