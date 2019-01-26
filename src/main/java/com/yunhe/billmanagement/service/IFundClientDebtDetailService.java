package com.yunhe.billmanagement.service;

import com.yunhe.billmanagement.entity.FundClientDebtDetail;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 欠款详细表 服务类
 * </p>
 *
 * @author 杨明月
 * @since 2019-01-21
 */
public interface IFundClientDebtDetailService extends IService<FundClientDebtDetail> {

    /**
     * <P>
     *     自动显示编码的SQL语句
     * </P>
     * @return 当前所有数据中最大ID
     */
    int maxId();

    /**
     * <P>
     *     通过用户名称查找该用户的欠款记录
     * </P>
     * @return  该用户的欠款记录
     */
    List<FundClientDebtDetail> selectDetailByName(String fcddFcdName);

    /**
     * <P>
     *      欠款详细表：分页
     * </P>
     * @param size 每页条数
     * @param current 当前页数
     * @param fundClientDebtDetail 条件
     * @return 欠款详细表：分页的结果集
     */
    Map selectFcddPage(int current,int size, FundClientDebtDetail fundClientDebtDetail);

    /**
     * <p>
     * 欠款详细表
     * </p>
     * @return 查询总金额
     */
    Map<String,Object> selectMoneyMapByName(String fcddFcdName);
}
