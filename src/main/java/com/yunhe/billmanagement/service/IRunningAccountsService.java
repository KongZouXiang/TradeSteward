package com.yunhe.billmanagement.service;

import com.yunhe.billmanagement.entity.RunningAccounts;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 资金流水表(ymy) 服务类
 * </p>
 *
 * @author 杨明月
 * @since 2019-01-02
 */
public interface IRunningAccountsService extends IService<RunningAccounts> {
    /**
     * @author 史江浩
     * @since 2019-01-24 12:18
     * 插入资金流水
     * @return int
     */
    int insertRunningAccountsOne(RunningAccounts runningAccounts);

    /**
     * @author 史江浩
     * @since 2019-01-24 12:18
     * 查询最大id值的所剩金额
     * @return 最大id值的所剩金额
     */
    RunningAccounts selectRunningMaxIdMoney();
}
