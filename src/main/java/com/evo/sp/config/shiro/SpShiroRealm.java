package com.evo.sp.config.shiro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.evo.sp.business.system.entity.SysPermission;
import com.evo.sp.business.system.entity.SysRole;
import com.evo.sp.business.system.entity.SysUser;
import com.evo.sp.business.system.service.ISysPermissionService;
import com.evo.sp.business.system.service.ISysRoleService;
import com.evo.sp.business.system.service.ISysUserService;
import com.evo.sp.common.ex.SpAssert;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.ex.BaseException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Description:自定义shiro的Realm类
 * @Author: sgt
 * @Date: 2019-03-28
 */
public class SpShiroRealm extends AuthorizingRealm {

    @Autowired
    private ISysUserService iSpUserService;
    @Autowired
    private ISysRoleService iSpRoleService;
    @Autowired
    private ISysPermissionService iSpPermissionsService;

    /**
     * @Description:授权
     * @Param:
     * @return:
     * @Author: 史国涛
     * @Date: 2019-03-28
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登录用户名
        SysUser loginUser = (SysUser) principalCollection.getPrimaryPrincipal();
        //添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        try {
            List<SysRole> roleByUname = iSpRoleService.getRoleByAccount(loginUser.getAccount());
            for (SysRole spRole : roleByUname) {
                //添加角色
                simpleAuthorizationInfo.addRole(spRole.getRoleCode());
                List<SysPermission> permissionsByRName = iSpPermissionsService.getPermissionsByCode(spRole.getRoleCode());
                for (SysPermission spPermissions : permissionsByRName) {
                    //添加权限
                    simpleAuthorizationInfo.addStringPermission(spPermissions.getPerCode());
                }
            }

        } catch (BaseException e) {
            e.printStackTrace();
        }
        return simpleAuthorizationInfo;
    }

    /**
     * @Description:认证
     * @Param:
     * @return:
     * @Author: 史国涛
     * @Date: 2019-03-28
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户输入的token
        UsernamePasswordToken utoken = (UsernamePasswordToken) token;
        String username = utoken.getUsername();
        SysUser spUser = null;
        QueryWrapper<SysUser> sysUserQueryWrapper = new QueryWrapper<>();
        sysUserQueryWrapper.setEntity(new SysUser(username));
        spUser = iSpUserService.getOne(sysUserQueryWrapper);
        if (!SpAssert.isNotNull(spUser)) {
            throw new UnknownAccountException();
        }
        //盐值
        ByteSource credentialsSalt = ByteSource.Util.bytes(spUser.getAccount());
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(spUser,
                spUser.getPassword(),
                credentialsSalt,
                this.getClass().getName());
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        session.setAttribute(SpConstantInter.USER, spUser);
        return simpleAuthenticationInfo;
    }


}
