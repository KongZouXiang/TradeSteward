package com.yunhe.core.common.login.service;

import com.yunhe.systemsetup.entity.Employ;

/**
 * <p>
 * 实现登录功能的业务层
 * </p>
 *
 * @author 孔邹祥
 * @date 2019年1月9日
 */
public interface ILoginService {

    /**
     * <p>
     * 员工登录方法
     * </p>
     *
     * @param employ 根据员工的账号密码判断是否能登录
     * @return 如果返回0表示不能等于，1表示可以登录
     */
    Employ login(Employ employ);
}
