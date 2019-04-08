package com.evo.sp.business.system.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evo.sp.business.system.entity.SystemUser;
import com.evo.sp.business.system.entity.vo.SystemUserVo;
import com.evo.sp.business.system.service.ISystemUserService;
import com.evo.sp.common.BaseController;
import com.evo.sp.common.ex.SpAssert;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.parameter.PageRequestParameter;
import com.evo.sp.common.result.Result;
import com.evo.sp.common.result.ResultEnum;
import com.evo.sp.config.swagger.SwaggerConstantInter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author sgt
 * @since 2019-04-01
 */
@RestController
@RequestMapping(SpConstantInter.SYSTEM_USER)
@Api(tags = "用户")
public class SystemUserController extends BaseController {

    private final String USER_PERMISSIONS = "permission";

    @Autowired
    private ISystemUserService iSpUserService;

    /**
     * @Description: 登录
     * @Param: spUserVo user登录参数对象
     * @return:
     * @Author: 史国涛
     * @Date: 2019-03-28
     */
    @RequestMapping(value = SpConstantInter.SYSTEM_USER_LOGIN, method = RequestMethod.POST)
    @ApiOperation(value = SwaggerConstantInter.SWAGGER_SYSTEM_SUER_LOGIN_VLUES)
    public Result login(@RequestBody SystemUserVo spUserVo) {
        Result result = null;
        SpAssert.isNullParamsObj(spUserVo);
        Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(spUserVo.getName(), spUserVo.getPassword());
            result = new Result(true, ResultEnum.LOGIN_SUCCESS.getValue(), ResultEnum.LOGIN_SUCCESS.getName());
            currentUser.login(token);
            currentUser.isPermitted(USER_PERMISSIONS);
        } else {
            result = new Result(true, ResultEnum.LOGIN_SUCCESS.getValue(), ResultEnum.LOGIN_SUCCESS.getName());
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
    @ApiOperation(value = SwaggerConstantInter.SWAGGER_SYSTEM_SUER_LOGIN_OUT_VLUES)
    @RequestMapping(value = SpConstantInter.SYSTEM_USER_LOGIN_OUT, method = RequestMethod.POST)
    public Result userLoginOut() {
        Result result = null;
        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser.isAuthenticated()) {
            currentUser.logout();
        }
        result = new Result(true, ResultEnum.LOGIN_OUT_SUCCESS.getValue(), ResultEnum.LOGIN_OUT_SUCCESS.getName());
        return result;
    }

    /**
     * @Description:添加用户
     * @Param:
     * @return:
     * @Author: 史国涛
     * @Date: 2019-03-28
     */
    @ApiOperation(SwaggerConstantInter.SWAGGER_SYSTEM_SUER_SAVE_VLUES)
    @RequiresPermissions(value = SpConstantInter.PERMISSION_SYSTEM_USER_SAVE)
    @RequestMapping(value = SpConstantInter.SYSTEM_USER_SAVE, method = RequestMethod.POST)
    public Result saveUser(@RequestBody SystemUser user) {
        SpAssert.isNull(user.getName());
        SpAssert.isNull(user.getPassword());
        ByteSource credentialsSalt = ByteSource.Util.bytes(user.getName());
        SimpleHash simpleHash = new SimpleHash(SpConstantInter.ENCRYPTION_TYPE, user.getPassword(), credentialsSalt);
        user.setPassword(simpleHash.toString());
        QueryWrapper<SystemUser> systemUserQueryWrapper = new QueryWrapper<>();
        systemUserQueryWrapper.setEntity(new SystemUser());
        systemUserQueryWrapper.eq(SpConstantInter.SYSTEM_USER_NAME, user.getName());
        Result result = queryOne(systemUserQueryWrapper, false, iSpUserService);
        if (!SpAssert.isNotNull(result.getDate())) {
            return save(user, iSpUserService);
        } else {
            return new Result(false, ResultEnum.REGISTER_FAIL.getValue(), ResultEnum.REGISTER_FAIL.getName());
        }
    }

    /**
     * @Description:根据id删除用户
     * @Param:
     * @return:
     * @Author: 史国涛
     * @Date: 2019-03-28
     */
    @ApiOperation(SwaggerConstantInter.SWAGGER_SYSTEM_SUER_DEL_VLUES)
    @RequiresPermissions(value = SpConstantInter.PERMISSION_SYSTEM_USER_DEL)
    @RequestMapping(value = SpConstantInter.SYSTEM_USER_DEL, method = RequestMethod.POST)
    public Result delUser(String id) {
        return del(id, iSpUserService);
    }

    /**
     * @Description:根据id修改用户信息
     * @Param:
     * @return:
     * @Author: 史国涛
     * @Date: 2019-03-28
     */
    @SuppressWarnings("all")
    @ApiOperation(SwaggerConstantInter.SWAGGER_SYSTEM_SUER_MODIFY_VLUES)
    @RequiresPermissions(value = SpConstantInter.PERMISSION_SYSTEM_USER_MODIFY)
    @RequestMapping(value = SpConstantInter.SYSTEM_USER_MODIFY, method = RequestMethod.POST)
    public Result modifyUser(@RequestBody SystemUser user) {
        SpAssert.isNull(user.getId());
        if (SpAssert.isNotNull((user.getPassword()))) {
            ByteSource credentialsSalt = ByteSource.Util.bytes(user.getName());
            SimpleHash simpleHash = new SimpleHash(SpConstantInter.ENCRYPTION_TYPE, user.getPassword(), credentialsSalt);
            user.setPassword(simpleHash.toString());
        }
        return modify(user, iSpUserService);
    }

    /**
     * 获取分页列表
     */
    @RequestMapping(value = SpConstantInter.SYSTEM_USER_PAGES, method = RequestMethod.POST)
    public Result queryListPages(@RequestBody PageRequestParameter<SystemUser> pageRequestParameter) {
        IPage pageInstance = pageRequestParameter.pageInstance();
        return queryListPage(pageInstance, pageRequestParameter.parameterInstance(), iSpUserService);
    }
}
