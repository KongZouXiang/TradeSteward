package com.yunhe.billmanagement.service.impl;

import com.yunhe.billmanagement.entity.RunningAccounts;
import com.yunhe.billmanagement.dao.RunningAccountsMapper;
import com.yunhe.billmanagement.service.IRunningAccountsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 资金流水表(ymy) 服务实现类
 * </p>
 *
 * @author 杨明月
 * @since 2019-01-02
 */
@Service
public class RunningAccountsServiceImpl extends ServiceImpl<RunningAccountsMapper, RunningAccounts> implements IRunningAccountsService {

    @Resource RunningAccountsMapper runningAccountsMapper;

    @Override
    public int insertRunningAccountsOne(RunningAccounts runningAccounts) {
        return runningAccountsMapper.insert(runningAccounts);
    }

    @Override
    public RunningAccounts selectRunningMaxIdMoney() {
        return runningAccountsMapper.selectRunningMaxIdMoney();
    }
}
