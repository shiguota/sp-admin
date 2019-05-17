package com.evo.sp.business.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evo.sp.business.system.entity.SysUser;
import com.evo.sp.business.system.entity.SysUserInfo;
import com.evo.sp.business.system.entity.vo.SysUserVo;
import com.evo.sp.business.system.mapper.SysUserInfoMapper;
import com.evo.sp.business.system.mapper.SysUserMapper;
import com.evo.sp.business.system.service.ISysUserInfoService;
import com.evo.sp.business.system.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.ex.DelException;
import com.evo.sp.common.ex.SpAssert;
import com.evo.sp.common.result.Result;
import com.evo.sp.common.result.ResultEnum;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author sgt
 * @since 2019-04-10
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {
    private final String USER_PERMISSIONS = "permission";

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysUserInfoMapper sysUserInfoMapper;
    @Autowired
    private ISysUserInfoService iSysUserInfoService;
    /**
     * 新增用户
     *
     * @param sysUserVo
     */
    @Override
    public Result saveUser(SysUserVo sysUserVo) {
        //验证参数
        SpAssert.isNull(sysUserVo);
        SpAssert.isNull(sysUserVo.getAccount());
        SpAssert.isNull(sysUserVo.getPassword());
        SysUserInfo sysUserInfo = sysUserVo.getInfo();
        SpAssert.isNull(sysUserInfo);
        //查询数据库是否已存在当前用户
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq(SpConstantInter.SYS_USER_ACCOUNT,sysUserVo.getAccount());
        SysUser one = super.getOne(wrapper);
        if (!SpAssert.isNotNull(one)) {
            //判断新增用户详情是否成功
            if (sysUserInfoMapper.insert(sysUserInfo) == SpConstantInter.CURDVAL) {
                sysUserVo.setSysUserInfoId(sysUserInfo.getId());
                //创建user实体对象
                SysUser sysUser = new SysUser();
                BeanUtils.copyProperties(sysUserVo,sysUser);
                //用户密码加密,加密方式MD5
                ByteSource credentialsSalt = ByteSource.Util.bytes(sysUser.getAccount());
                SimpleHash simpleHash = new SimpleHash(SpConstantInter.ENCRYPTION_TYPE, sysUser.getPassword(), credentialsSalt);
                sysUser.setPassword(simpleHash.toString());
                //如果成功添加用户详情信息，再次新增用户基础信息
                if (sysUserMapper.insert(sysUser) == SpConstantInter.CURDVAL) {
                    return new Result(true);
                }
            }
        }else{
            return new Result(false, ResultEnum.USER_IS_EXIST.getValue(),ResultEnum.USER_IS_EXIST.getName());
        }
        return new Result(false);
    }

    /**
     * 查询用户信息，根据组织（机构）id
     *
     * @param page
     * @param userVo
     */
    @Override
    public Result queryUserByOrg(Page page, SysUserVo userVo) {
        SpAssert.isNull(userVo.getSysOrganizationId());
        return new Result(sysUserMapper.queryUserByOrg(page, userVo));
    }

    /**
     * 查询用户信息通过id
     *
     * @param id
     */
    @Override
    public Result queryUserById(String id) {
        SpAssert.isNull(id);
        return new Result(sysUserMapper.queryUserById(id));
    }

    /**
     * 根据用户id获取账号已存在的角色
     *
     * @param id
     */
    @Override
    public Result queryRoleById(String id) {
        SpAssert.isNull(id);
        return new Result(sysUserMapper.queryRoleById(id));
    }

    /**
     * 通过当前登录账号的信息，获取当前账号下的角色（不包括，已经分配给选中的当前账号的角色）
     *
     * @param loginId 当前登录系统的用户id
     * @param seleId  被选中账号的用户id
     */
    @Override
    public Result queryUnRoleById(String loginId, String seleId) {
        SpAssert.isNull(loginId);
        SpAssert.isNull(seleId);
        return new Result(sysUserMapper.queryUnRoleById(loginId,seleId));
    }

    /**
     * 登录
     *
     * @param account
     * @param password
     */
    @Override
    public Result login(String account, String password) {
        Result result = null;
        SpAssert.isNull(account);
        SpAssert.isNull(password);
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(account, password);
            // token.setRememberMe(true);
            currentUser.login(token);
            currentUser.isPermitted(USER_PERMISSIONS);
            result = new Result(session.getAttribute(session.getId()), ResultEnum.LOGIN_SUCCESS.getValue(), ResultEnum.LOGIN_SUCCESS.getName());
        } else {
            result = new Result(session.getAttribute(session.getId()), ResultEnum.LOGIN_SUCCESS.getValue(), ResultEnum.LOGIN_SUCCESS.getName());
        }
        return result;
    }

    /**
     * 注销
     */
    @Override
    public Result userLoginOut() {
        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser.isAuthenticated()) {
            currentUser.logout();
        }
        return new Result(true, ResultEnum.LOGIN_OUT_SUCCESS.getValue(), ResultEnum.LOGIN_OUT_SUCCESS.getName());
    }

    /**
     * 删除
     *
     * @param sysUserVos
     */
    @Override
    @Transactional
    public Result dels(List<SysUserVo> sysUserVos) {
        //校验参数
        SpAssert.isNull(sysUserVos);
        List<String> userIds = new ArrayList<>();
        List<String> userInfoIds = new ArrayList<>();
        //向集合中填充数据
        for (SysUserVo sysUserVo : sysUserVos) {
            userIds.add(sysUserVo.getId());
            userInfoIds.add(sysUserVo.getSysUserInfoId());
        }
        //删除用户
        if (removeByIds(userIds)) {
            //删除用户信息
            if (iSysUserInfoService.removeByIds(userInfoIds)) {
                return new Result(true);
            }else{
                throw new DelException(ResultEnum.REMOVE_SUCCESS.getValue(),ResultEnum.REMOVE_SUCCESS.getName());
            }
        }else{
            throw new DelException(ResultEnum.REMOVE_SUCCESS.getValue(),ResultEnum.REMOVE_SUCCESS.getName());
        }
    }
}
