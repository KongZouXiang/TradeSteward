package com.yunhe.core.shiro;

import com.yunhe.core.common.login.service.ILoginService;
import com.yunhe.systemsetup.dao.EmployMapper;
import com.yunhe.systemsetup.entity.Employ;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户Realm
 * </p>
 *
 * @author 孔邹祥
 * @date 2019年1月18日
 */

public class UserRealm extends AuthorizingRealm {

    @Resource
    ILoginService loginService;

    @Resource
    EmployMapper employMapper;


    /**
     * <p>
     * 执行授权逻辑
     * </P>
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        System.out.println("授权");

//        给资源进行授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

//        添加资源的授权字符串
//        info.addStringPermission("user:add")

//        得到数据库查询当前登录用户的授权字符串
        Subject subject = SecurityUtils.getSubject();
        Employ employ = (Employ) subject.getPrincipal();

//        根据ID查找出员工对应的板块
        List<String> list = employMapper.selectEmployPlate(employ.getId());

        for (String string : list) {
            info.addStringPermission(string);
        }

        return info;
    }

    /**
     * <p>
     * 执行认证逻辑
     * </P>
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        System.out.println("认证");
//        编写Shiro判断处理逻辑，判断用户名和密码
//        1.判断用户名
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
//            查询数据库的用户名和密码
        Employ employ = loginService.selectOneEmploy(token.getUsername());


//盐值
        ByteSource credentialsSalt = ByteSource.Util.bytes(employ.getEmUsername());
        //封装用户信息，构建AuthenticationInfo对象并返回
        AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(employ, employ.getEmPassword(),
                credentialsSalt, getName());


        SecurityUtils.getSubject().getSession().setAttribute("employ", employ);

        if (employ == null) {
//            用户名不存在
//            底层会抛出UnKnowAccountException
            return null;
        }
        return authcInfo;
//        2.判断密码
//        return new SimpleAuthenticationInfo(employ, employ.getEmPassword(), "");
    }
}
