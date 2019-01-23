package com.yunhe.billmanagement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yunhe.billmanagement.entity.FundProviderDebt;

import java.util.Map;

/**
 * <p>
 * 供应商应付欠款表(ymy) 服务类
 * </p>
 *
 * @author 杨明月
 * @since 2019-01-02
 */
public interface IFundProviderDebtService extends IService<FundProviderDebt> {
    /**
     * <P>
     *     供应商应付欠款表
     * </P>
     * @param current 当前页
     * @param size 每页条数
     * @return 供应商应付欠款表：分页的结果集
     */
    Map selectFpdPage(int current, int size, FundProviderDebt fundProviderDebt);

    /**
     * <P>
     *     增加数据
     * </P>
     * @param fundProviderDebt 新增付款的参数存在一个对象里
     * @return  供应商应付欠款表：增加是否成功
     */
    int insertFpd(FundProviderDebt fundProviderDebt);

    /**
     * <P>
     *     增加数据
     * </P>
     * @param id 要查看的数据的id
     * @return  一行或多行数据
     */
    FundProviderDebt selectFpd(int id);

    /**
     * <P>
     *     供应商应付欠款表
     * </P>
     * @return 查询所有款项之和
     */
    Map<String,Object> selectFpdMap();
}
