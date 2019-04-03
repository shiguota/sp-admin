package com.evo.sp.config.shiro;

import com.evo.sp.business.system.entity.SystemPermissions;
import com.evo.sp.business.system.entity.SystemRole;
import com.evo.sp.business.system.entity.SystemUser;
import com.evo.sp.business.system.entity.vo.SystemUserVo;
import com.evo.sp.business.system.service.ISystemPermissionsService;
import com.evo.sp.business.system.service.ISystemRoleService;
import com.evo.sp.business.system.service.ISystemUserService;
import com.evo.sp.common.SpAssert;
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
    private ISystemUserService iSpUserService;
    @Autowired
    private ISystemRoleService iSpRoleService;
    @Autowired
    private ISystemPermissionsService iSpPermissionsService;

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
        SystemUserVo loginUser = (SystemUserVo) principalCollection.getPrimaryPrincipal();
        //查询用户名称
        SystemUser user = new SystemUser();
        //添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        try {
            List<SystemRole> roleByUname = iSpRoleService.getRoleByUname(loginUser.getName());
            for (SystemRole spRole : roleByUname) {
                //添加角色
                simpleAuthorizationInfo.addRole(spRole.getRoleName());
                List<SystemPermissions> permissionsByRName = iSpPermissionsService.getPermissionsByRName(spRole.getRoleName());
                for (SystemPermissions spPermissions : permissionsByRName) {
                    //添加权限
                    simpleAuthorizationInfo.addStringPermission(spPermissions.getPermissionsTag());
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
        SystemUser spUser = null;
        spUser = iSpUserService.userByname(username);
        if (!SpAssert.isNotNull(spUser)) {
            throw new UnknownAccountException();
        }
        //盐值
        ByteSource credentialsSalt = ByteSource.Util.bytes(spUser.getName());
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
