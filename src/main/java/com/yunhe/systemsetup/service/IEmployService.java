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
 * @author heyuji
 * @since 2019-01-02
 */
public interface IEmployService extends IService<Employ> {
    public List<Employ> selectPageEmploy(Page page, Employ employ);

    public int insertEmploy(Employ employ);

    public boolean checkname(Employ employ);

    Employ selectEmployById(int id);

    public  int updatePassword(Employ employ);

    public int updateMessage(Employ employ);
}
