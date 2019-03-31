package com.evo.sp.basis.controller;


import com.evo.sp.basis.entity.SpUser;
import com.evo.sp.basis.entity.vo.SpUserVo;
import com.evo.sp.basis.service.ISpUserService;
import com.evo.sp.common.SpAssert;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.annotations.SpController;
import com.evo.sp.common.annotations.SpLogController;
import com.evo.sp.common.result.Result;
import com.evo.sp.common.result.ResultEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.text.translate.UnicodeUnpairedSurrogateRemover;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.credential.Md2CredentialsMatcher;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.evo.sp.common.BaseController;
import sun.misc.Cache;

import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author sgt
 * @since 2019-03-27
 */
@RestController
@RequestMapping("basis/sp-user")
@Api(tags="用户操作接口")
 //@SpController(value = "basis/sp-user",tags = {"用户操作接口"})
public class SpUserController extends BaseController<SpUser> {

    @Autowired
    private ISpUserService iSpUserService;

    /**
     * @Description: 登录
     * @Param: spUserVo user登录参数对象
     * @return: 
     * @Author: 史国涛
     * @Date: 2019-03-28
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "通过用户名密码登陆", notes = "根据用户名查询用户信息进行密码匹配")
   // @ApiImplicitParam(name = "name", value = "学生ID", paramType = "path", required = true, dataType = "Integer")
    public Result login(@RequestBody SpUserVo spUserVo) {
        Result result = null;
        SpAssert.isNullParamsObj(spUserVo);
        Subject currentUser = SecurityUtils.getSubject();
        if ( !currentUser.isAuthenticated() ) {
            UsernamePasswordToken token = new UsernamePasswordToken(spUserVo.getName(), spUserVo.getPassword());
            //token.setRememberMe(true);
            result = new Result(true,ResultEnum.LOGIN_SUCCESS.getValue(),ResultEnum.LOGIN_SUCCESS.getName());
            try {
                currentUser.login( token );
            } catch ( UnknownAccountException uae) {
                result = new Result(ResultEnum.LOGIN_FAIL_SUER_NOT_AND_PASSWORD_ERORR.getValue(),ResultEnum.LOGIN_FAIL_SUER_NOT_AND_PASSWORD_ERORR.getName());
            } catch ( IncorrectCredentialsException ice ) {
                result = new Result(ResultEnum.LOGIN_FAIL_SUER_NOT_AND_PASSWORD_ERORR.getValue(),ResultEnum.LOGIN_FAIL_SUER_NOT_AND_PASSWORD_ERORR.getName());
            } catch ( LockedAccountException lae ) {
                result = new Result(ResultEnum.LOGIN_FAIL_USER_IS_LOCKED.getValue(),ResultEnum.LOGIN_FAIL_USER_IS_LOCKED.getName());
            }
             catch ( AuthenticationException ae ) {
                 result = new Result(ResultEnum.LOGIN_FAIL.getValue(),ResultEnum.LOGIN_FAIL.getName());
            }
        }else{
            result = new Result(true,ResultEnum.LOGIN_SUCCESS.getValue(),ResultEnum.LOGIN_SUCCESS.getName());
        }
        return result;
    }

    /**
    * @Description:注销
    * @Param:  
    * @return:  
    * @Author: 史国涛
    * @Date: 2019-03-29 
    */
    @RequestMapping(value = "loginout",method = RequestMethod.POST)
    public Result userLoginOut(){
        Result result = null;
        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser.isAuthenticated()) {
            currentUser.logout();
        }
         result  = new Result(true,ResultEnum.LOGIN_OUT_SUCCESS.getValue(),ResultEnum.LOGIN_OUT_SUCCESS.getName());
        return result;
    }

    /**
    * @Description:添加用户
    * @Param:  
    * @return:  
    * @Author: 史国涛
    * @Date: 2019-03-28 
    */
    @RequiresPermissions(value = "basis:sp-user:save")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result saveUser(@RequestBody SpUser user) {
        ByteSource credentialsSalt = ByteSource.Util.bytes(user.getName());
        SimpleHash simpleHash = new SimpleHash("MD5",user.getPassword(),credentialsSalt);
        user.setPassword(simpleHash.toString());
        return save(user, iSpUserService);
    }

    /**
    * @Description:根据id删除用户
    * @Param:
    * @return:
    * @Author: 史国涛
    * @Date: 2019-03-28
    */
    @RequiresPermissions(value = "basis:sp-user:del")
    @RequestMapping(value = "/del",method = RequestMethod.POST)
    public Result delUser(String id){
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.isPermitted("del");
        return del(id,iSpUserService);
    }

    /**
    * @Description:根据条件修改用户
    * @Param:
    * @return:
    * @Author: 史国涛
    * @Date: 2019-03-28
    */
    @RequiresPermissions(value = "basis:sp-user:modify")
    @RequestMapping(value = "/modify",method = RequestMethod.POST)
    public Result modifyUser(@RequestBody SpUser spUser){
        return  modify(spUser,iSpUserService);
    }
}
