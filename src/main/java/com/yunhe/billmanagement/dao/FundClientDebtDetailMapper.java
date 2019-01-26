package com.yunhe.billmanagement.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.billmanagement.entity.FinanceOrder;
import com.yunhe.billmanagement.entity.FundClientDebtDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 欠款详细表 Mapper 接口
 * </p>
 *
 * @author 杨明月
 * @since 2019-01-21
 */
public interface FundClientDebtDetailMapper extends BaseMapper<FundClientDebtDetail> {

    /**
     * <P>
     *     自动显示编码的SQL语句
     * </P>
     * @return 当前所有数据中最大ID
     */
    int maxId();

    /**
     * <P>
     *     欠款详细表：分页
     * </P>
     * @param page 分页所有参数存在page中
     * @param fundClientDebtDetail 模糊查询的参数存在fundClientDebtDetail中
     * @return 欠款详细表：分页的结果集
     */
    List<FundClientDebtDetail> selectFcddPage(Page page,FundClientDebtDetail fundClientDebtDetail);

    /**
     * <p>
     * 欠款详细表
     * </p>
     * @return 查询总金额
     */
    @Select("select SUM(fcdd_begin_debt) as beginDebt, SUM(fcdd_back_debt) as backDebt,SUM(fcdd_discount) as discount,SUM(fcdd_receivable) as receivable from fund_client_debt_detail where fcdd_fcd_name like concat('%',#{fcddFcdName},'%')")
    Map<String,Object> selectMoneyMapByName(String fcddFcdName);
}
