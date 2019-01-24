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
     * @param name 根据员工的账号查询出员工
     * @return 返回员工信息
     */
    Employ selectOneEmploy(String name);
}
