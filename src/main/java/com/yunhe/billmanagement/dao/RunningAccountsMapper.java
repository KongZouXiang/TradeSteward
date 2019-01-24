package com.yunhe.billmanagement.dao;

import com.yunhe.billmanagement.entity.RunningAccounts;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 资金流水表(ymy) Mapper 接口
 * </p>
 *
 * @author 杨明月
 * @since 2019-01-02
 */
@Repository
@Mapper
public interface RunningAccountsMapper extends BaseMapper<RunningAccounts> {

    /**
     * @author 史江浩
     * @since 2019-01-24 12:18
     * 查询最大id值的所剩金额
     * @return 最大id值的所剩金额
     */
    RunningAccounts selectRunningMaxIdMoney();
}
