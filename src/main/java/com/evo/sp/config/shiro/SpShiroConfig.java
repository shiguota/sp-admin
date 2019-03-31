package com.evo.sp.config.shiro;


import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.credential.Md5CredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

/**
 * @Description:shiro配置类
 * @Author: sgt
 * @Date: 2019-03-28
 */
@Configuration
public class SpShiroConfig {

    /**
    * @Description:自定义Realm加入容器 
    * @Param:  
    * @return:  
    * @Author: 史国涛
    * @Date: 2019-03-29 
    */
    @Bean
    public SpShiroRealm myShiroRealm() {
        SpShiroRealm myShiroRealm = new SpShiroRealm();
        myShiroRealm.setCredentialsMatcher(MD5credentialsMatcher());
        return myShiroRealm;
    }

    /**
    * @Description:加密（MD5） 
    * @Param:  
    * @return:  
    * @Author: 史国涛
    * @Date: 2019-03-29 
    */
    @Bean
    public HashedCredentialsMatcher MD5credentialsMatcher(){
        Md5CredentialsMatcher md5CredentialsMatcher = new Md5CredentialsMatcher();
        md5CredentialsMatcher.setStoredCredentialsHexEncoded(true);
        return  md5CredentialsMatcher;
    }

    /**
    * @Description:权限管理，配置主要是Realm的管理认证
    * @Param:  
    * @return:  
    * @Author: 史国涛
    * @Date: 2019-03-29 
    */
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        return securityManager;
    }
    /**
    * @Description:shiro过滤器
    * @Param:  
    * @return:  
    * @Author: 史国涛
    * @Date: 2019-03-29 
    */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager);
        //配置访问权限
        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/basis/sp-user/login", "anon");
        filterChainDefinitionMap.put("/basis/sp-user/*", "authc");
//        filterChainDefinitionMap.put("/druid/*", "anon");
//        filterChainDefinitionMap.put("/**/*.js", "anon");
//        filterChainDefinitionMap.put("/**/*.gif", "anon");
//        filterChainDefinitionMap.put("/**/*.jpg", "anon");
//        filterChainDefinitionMap.put("/**/*.bmp", "anon");
//        filterChainDefinitionMap.put("/**/*.png", "anon");
//        filterChainDefinitionMap.put("/**/*.css", "anon");
//        filterChainDefinitionMap.put("/**/*.ico", "anon");
//        filterChainDefinitionMap.put("/**/*.*", "anon");
//        //filterChainDefinitionMap.put("/*", "authc");//表示需要认证才可以访问
//        //filterChainDefinitionMap.put("/**", "authc");
//        filterChainDefinitionMap.put("/**", "authc");
        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return bean;
    }

    /**
    * @Description:开启APO注解
    * @Param:  
    * @return:  
    * @Author: 史国涛
    * @Date: 2019-03-29 
    */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }


    /**
     * 开启Shiro的注解(如@RequiresRoles,@RequiresPermissions),需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证
     * 配置以下两个bean(DefaultAdvisorAutoProxyCreator和AuthorizationAttributeSourceAdvisor)即可实现此功能
     *
     * @return
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }
}
