package com.yunhe.billmanagement.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yunhe.billmanagement.entity.RunningAccounts;

import java.util.List;
import java.util.Map;

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
     * <p>
     * 资金流水表
     * </p>
     * @param current 当前页
     * @param size 每页条数
     * @param runningAccounts 模糊查询的参数
     * @return 资金流水表:分页的结果集
     */
    Map selectRaPage(int current, int size, RunningAccounts runningAccounts);

    /**
     * <p>
     * 资金流水表(ymy) 服务类
     * </p>
     * @return 查询全部数据
     */
    List<RunningAccounts> selectRa();

    /**
     * <p>
     * 资金流水表(ymy) 服务类
     * </p>
     * @return 查询总收入和总支出
     */
    Map<String,Object> selectCountMap();


}
