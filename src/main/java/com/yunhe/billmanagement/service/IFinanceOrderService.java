package com.yunhe.billmanagement.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.yunhe.billmanagement.entity.FinanceOrder;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 收支订单管理表(ymy) 服务类
 * </p>
 *
 * @author 杨明月
 * @since 2019-01-02
 */
public interface IFinanceOrderService extends IService<FinanceOrder> {
    /**
     * <P>
     *      日常收支表：分页
     * </P>
     * @param size 每页条数
     * @param current 当前页数
     * @param financeOrder 条件参数存在financeOrder中
     * @return 日常收支表：分页的结果集
     */
    Map selectFoPage(int size, int current, FinanceOrder financeOrder);

    /**
     * <P>
     *     查询数据
     * </P>
     * @return 日常收支表：查询的结果集
     */
    List<FinanceOrder> selectFo();

    /**
     * <P>
     *     增加数据
     * </P>
     * @param financeOrder 日常收支类对象
     * @return  日常收支表：增加是否成功
     */
    int insertFo(FinanceOrder financeOrder);

    /**
     * <P>
     *     通过id查找数据，显示详情
     * </P>
     * @param id  查询数据的条件
     * @return FinanceOrder对象
     */
    FinanceOrder detailById(int id);

    /**
     * <P>
     *     修改数据
     * </P>
     * @param financeOrder 日常收支类对象
     * @return  日常收支表：修改是否成功
     */
    int updateFo(FinanceOrder financeOrder);

    /**
     * <P>
     *     删除数据
     * </P>
     * @param financeOrder 日常收支类对象
     * @return  日常收支表：删除是否成功
     */
    int deleteFo(FinanceOrder financeOrder);

    /**
     * <P>
     *     自动显示编码的SQL语句
     * </P>
     * @return 当前所有数据中最大ID
     */
    int maxId();

    /**
     * <P>
     *      修改订单编号
     * </P>
     * @param map 需要修改的参数信息
     * @return 修改是否成功
     */
    int gaiFo(Map<String, Object> map);
}
