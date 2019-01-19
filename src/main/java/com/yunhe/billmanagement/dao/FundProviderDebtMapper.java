package com.yunhe.billmanagement.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.billmanagement.entity.FundProviderDebt;
import org.springframework.stereotype.Repository;

import java.util.List;

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
}
