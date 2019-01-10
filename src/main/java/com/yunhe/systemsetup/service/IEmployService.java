package com.yunhe.systemsetup.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.systemsetup.entity.Employ;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 员工管理 服务类
 * </p>
 *
 * @author 刘延奇,heyuji
 * @since 2019-01-02
 */
public interface IEmployService extends IService<Employ> {
    public List<Employ> selectPageEmploy(Page page, Employ employ);

    public void insertEmploy(Employ employ);
}
