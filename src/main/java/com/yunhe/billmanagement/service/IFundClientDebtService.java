package com.yunhe.billmanagement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yunhe.billmanagement.entity.FundClientDebt;

import java.util.Map;

/**
 * <p>
 * 客户应收欠款表(ymy) 服务类
 * </p>
 *
 * @author 杨明月
 * @since 2019-01-02
 */
public interface IFundClientDebtService extends IService<FundClientDebt> {

    /**
     * 客户应收欠款表
     * @param current 当前页
     * @param size 每页条数
     * @return 客户应收欠款表:分页的结果集
     */
    Map selectFcdPage(int current, int size,FundClientDebt fundClientDebt);

    /**
     * <P>
     *     增加数据
     * </P>
     * @param fundClientDebt 新增收款的参数存在一个对象里
     * @return  客户应收欠款表：增加是否成功
     */
    int insertFcd(FundClientDebt fundClientDebt);

}
