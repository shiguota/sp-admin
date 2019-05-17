package com.evo.sp.config.shiro;


import com.evo.sp.business.system.entity.SysFilterPath;
import com.evo.sp.business.system.service.ISysFilterPathService;
import org.apache.commons.collections.FastHashMap;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.credential.Md5CredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Description:shiro配置类
 * @Author: sgt
 * @Date: 2019-03-28
 */
@Configuration
public class SpShiroConfig {

    private static final String FILTER_NAME = "spfilter";

    @Autowired
    private ISysFilterPathService iSystemFilterPathService;
    /**
    * @Description:自定义Realm加入容器 
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
    * @Author: 史国涛
    * @Date: 2019-03-29 
    */
    @Bean
    public SecurityManager securityManager(Realm realm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm);
        return securityManager;
    }
    /**
    * @Description:shiro过滤器
    * @Author: 史国涛
    * @Date: 2019-03-29 
    */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        Map<String, Filter> mapFilter = new FastHashMap();
        mapFilter.put(FILTER_NAME,getSpCheckLoginFilter());
        mapFilter.put("pathfile",pathfile());
        bean.setFilters(mapFilter);
        LinkedList<SysFilterPath> systemFilterPaths = iSystemFilterPathService.queryFilePath();
        //配置访问权限
        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        for (SysFilterPath systemFilterPath : systemFilterPaths) {
            filterChainDefinitionMap.put(systemFilterPath.getPath(),systemFilterPath.getType());
        }
        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        bean.setSecurityManager(securityManager);
        return bean;
    }

    @Bean(name = "spCheckLoginFilter")
    public SpCheckLoginFilter getSpCheckLoginFilter(){
        return new SpCheckLoginFilter();
    }

    public SpPathFilter pathfile(){
        return new SpPathFilter();
    }

    /**
    * @Description:开启APO注解
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
     * 开启Shiro的注解
     * @return
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }
}
