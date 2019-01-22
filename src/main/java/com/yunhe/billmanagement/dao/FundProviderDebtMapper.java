package com.yunhe.billmanagement.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.billmanagement.entity.FundProviderDebt;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 供应商应付欠款表(ymy) Mapper 接口
 * </p>
 *
 * @author 杨明月
 * @since 2019-01-02
 */
@Repository
public interface FundProviderDebtMapper extends BaseMapper<FundProviderDebt> {
    /**
     * <P>
     *     供应商应付欠款表
     * </P>
     * @param page 分页的参数存在一个对象里
     * @return 供应商应付欠款表：分页的结果集
     */
    List<FundProviderDebt> selectFpdPage(Page page, FundProviderDebt fundProviderDebt);

    /**
     * <P>
     *     客户应收欠款表
     * </P>
     * @return 查询所有款项之和
     */
    @Select("select SUM(fpd_begin_debt) as fpdBegin,SUM(fpd_add_debt) as fpdAdd,SUM(fpd_pay_debt) as fpdPay,SUM(fpd_discount) as fpdDiscount,SUM(fpd_offset_deb) as fpdOffset,SUM(fpd_receivable) as fpdReceive from fund_provider_debt")
    Map<String,Object> selectFpdMap();
}
