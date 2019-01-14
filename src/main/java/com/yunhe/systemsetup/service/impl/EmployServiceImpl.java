package com.yunhe.systemsetup.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.systemsetup.entity.Employ;
import com.yunhe.systemsetup.dao.EmployMapper;
import com.yunhe.systemsetup.service.IEmployService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 员工管理 服务实现类
 * </p>
 *
 * @author 刘延奇,heyuji
 * @since 2019-01-02
 */
@Service
public class EmployServiceImpl extends ServiceImpl<EmployMapper, Employ> implements IEmployService {
    @Autowired
    private EmployMapper employMapper;
    @Override
    public List<Employ> selectPageEmploy(Page page, Employ employ) {
        return employMapper.selectPageEmploy(page,employ);

    }

    @Override
    public void insertEmploy(Employ employ) {
        employMapper.insertEmploy(employ);

    }

    public EmployMapper getEmployMapper() {
        return employMapper;
    }

    public void setEmployMapper(EmployMapper employMapper) {
        this.employMapper = employMapper;
    }
}
