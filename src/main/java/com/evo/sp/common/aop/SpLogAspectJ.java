package com.evo.sp.common.aop;

import com.alibaba.fastjson.JSON;
import com.evo.sp.business.system.entity.SysUser;
import com.evo.sp.business.system.entity.SystemLog;
import com.evo.sp.business.system.service.ISysLogService;
import com.evo.sp.common.BaseEntity;
import com.evo.sp.common.ex.SpAssert;
import com.evo.sp.common.annotations.SpLogController;
import com.evo.sp.common.annotations.SpLogService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.time.LocalDateTime;

@Component
@Aspect
@SuppressWarnings("all")
public class SpLogAspectJ {

    //注入Service用于把日志保存数据库，实际项目入库采用队列做异步
    @Resource
    private ISysLogService iSpLogService;

    //本地异常日志记录对象
    private static final Logger logger = LoggerFactory.getLogger(SpLogAspectJ.class);

    //Service层切点
    @Pointcut("@annotation(com.evo.sp.common.annotations.SpLogService)")
    public void serviceAspect() {
    }

    //Controller层切点
    @Pointcut("@annotation(com.evo.sp.common.annotations.SpLogController)")
    public void controllerAspect() {
    }

    /**
     * @Description:前置通知 用于拦截Controller层记录用户的操作
     * @Param:
     * @return:
     * @Author: 史国涛
     * @Date: 2019-03-29
     */

    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String ip = HttpIp.getUserIP(request);
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        SysUser user = (SysUser) session.getAttribute(session.getId());
        SystemLog spLog = new SystemLog();
        try {
            if (SpAssert.isNotNull(user)) {
                spLog.setUserName(user.getAccount());
                spLog.setUserId(user.getId());
            }
            spLog.setRespTime(LocalDateTime.now());
            spLog.setParasms(JSON.toJSONString(joinPoint.getArgs()));
            spLog.setMethodName((joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName()));
            spLog.setOperationType(getControllerMethodDescription(joinPoint));
            System.out.println(JSON.toJSONString(spLog));
            iSpLogService.save(spLog);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description:异常通知 用于拦截service层记录异常日志
     * @Param:
     * @return:
     * @Author: 史国涛
     * @Date: 2019-03-29
     */
    @AfterThrowing(pointcut = "serviceAspect()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String ip = HttpIp.getUserIP(request);
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        try {
            if (SpAssert.isNotNull(session)) {
                SysUser user = (SysUser) session.getAttribute(session.getId());
                SystemLog spLog = new SystemLog();
                spLog.setUserName(user.getAccount());
                spLog.setUserId(user.getId());
                spLog.setErrorCode(e.getClass().getName());
                spLog.setErrorMsg(e.getMessage());
                spLog.setRespTime(LocalDateTime.now());
                spLog.setParasms(JSON.toJSONString(joinPoint.getArgs()));
                spLog.setMethodName((joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName()));
                spLog.setOperationType(getControllerMethodDescription(joinPoint));
                iSpLogService.save(spLog);
                System.out.println(JSON.toJSONString(spLog));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    /**
     * @Description:获取注解中对方法的描述信息 用于service层注解
     * @Param:
     * @return:
     * @Author: 史国涛
     * @Date: 2019-03-29
     */
    public static String getServiceMethodDescription(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description = method.getAnnotation(SpLogService.class).description();
                    break;
                }
            }
        }
        return description;
    }


    /**
     * @Description:获取注解中对方法的描述信息 用于Controller层注解
     * @Param:
     * @return:
     * @Author: 史国涛
     * @Date: 2019-03-29
     */
    public static String getControllerMethodDescription(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();//目标方法名
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description = method.getAnnotation(SpLogController.class).description();
                    break;
                }
            }
        }
        return description;
    }


}
