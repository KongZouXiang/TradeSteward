package com.yunhe.billmanagement.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.billmanagement.entity.RunningAccounts;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 资金流水表(ymy) Mapper 接口
 * </p>
 *
 * @author 杨明月
 * @since 2019-01-02
 */
@Repository
public interface RunningAccountsMapper extends BaseMapper<RunningAccounts> {

    /**
     * <P>
     *     资金流水表
     * </P>
     * @param page 分页的参数存在一个对象里
     * @param runningAccounts 资金流水
     * @return 供应商应付欠款表：分页的结果集
     */
    List<RunningAccounts> selectRaPage(Page page, RunningAccounts runningAccounts);

    /**
     * <p>
     * 资金流水表(ymy) 服务类
     * </p>
     * @return 查询总收入和总支出
     */
    @Select("select SUM(ra_income) as incomes,SUM(ra_outcome) AS outcomes from running_accounts")
    Map<String,Object> selectCountMap();

    /**
     * @author 史江浩
     * @since 2019-01-24 12:18
     * 查询最大id值的所剩金额
     * @return 最大id值的所剩金额
     */
    RunningAccounts selectRunningMaxIdMoney();
}
