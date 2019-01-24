package com.yunhe.core.shiro;


import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <per>
 * Shiro配置类
 * 1.配置ShiroFilterFactory
 * 2.配置SecurityManager
 * </per>
 *
 * @author 孔邹祥
 * @date 2019年1月17日
 */
@Configuration
public class ShiroConfig {

    /**
     * 安全管理器
     * 创建ShrioFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//            设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
//        添加Shiro内置过滤器

        /**
         * Shior内置过滤器，可以实现权限相关的拦截器
         *      常用拦截器
         *          anon: 无需认证（登录）可以访问
         *          authc:  必须认证才可以访问
         *          user:   如果使用rememberMe的功能才可以直接访问
         *          perms:  该资源必须得到资源权限才可以访问
         *          pole:   该资源必须得到角色权限才可以访问
         */
        Map<String, String> filterMap = new LinkedHashMap<>();
//        Shiro放行的页面
        filterMap.put("/login", "anon");
        filterMap.put("/", "anon");

//        授权过滤器 注意: 当签授权拦截后，Shiro会自动跳转到未授权页面
        filterMap.put("/add", "perms[user:add]");

//        增加用户的板块
        filterMap.put("/ad", "perms[activitymanagement]");
        filterMap.put("/add", "perms[basicdata]");
        filterMap.put("/add", "perms[billmanagement]");
        filterMap.put("/add", "perms[cargomanagement]");
        filterMap.put("/add", "perms[customermanagement]");
        filterMap.put("/add", "perms[reportanalysis]");
        filterMap.put("/add", "perms[systemsetup]");

//        Shiro拦截的页面
          filterMap.put("/*", "authc");

//        修改调整的登录页面
        shiroFilterFactoryBean.setLoginUrl("toLogin");

//        设置未授权提示页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/noAuth");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 创建DefaultWebSecurityManager
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {

        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联Realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    /**
     * 创建Realm
     */
    @Bean(name = "userRealm")
    public UserRealm getRealm() {
        return new UserRealm();
    }

    /**
     * <p>
     * 用于thymeleaf模板使用shiro标签
     * </p>
     */
    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }



}
