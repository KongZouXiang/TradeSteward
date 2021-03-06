package com.yunhe.billmanagement.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.billmanagement.entity.AccountTransfer;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


/**
 * <p>
 * 账户转账表(ymy) Mapper 接口
 * </p>
 * @author 杨明月
 * @since 2019-01-02
 */
@Repository
public interface AccountTransferMapper extends BaseMapper<AccountTransfer> {
    /**
     * <P>
     *     账户转账表
     * </P>
     * @param accountTransfer 收支分类内的参数存在一个对象里
     * @param page 分页的参数存在一个对象里
     * @return 账户转账表：分页的结果集
     */
    List<AccountTransfer> selectAtPage(Page page, AccountTransfer accountTransfer);

    /**
     * <p>
     *     账户转账表
     * </p>
     * @return 查询总金额和总手续费
     */
    @Select("select SUM(at_money) as money,SUM(at_charge) AS charge from account_transfer")
    Map<String,Object> selectAtCountMap();
}
