package com.yunhe.systemsetup.service.impl;

import com.yunhe.systemsetup.entity.Employ;
import com.yunhe.systemsetup.dao.EmployMapper;
import com.yunhe.systemsetup.service.IEmployService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
