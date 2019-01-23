package com.yunhe.billmanagement.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.billmanagement.entity.FinanceClassify;
import com.yunhe.billmanagement.entity.FinanceOrder;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 收支订单管理表(ymy) Mapper 接口
 * </p>
 *
 * @author 杨明月
 * @since 2019-01-02
 */
@Repository
public interface FinanceOrderMapper extends BaseMapper<FinanceOrder> {

    /**
     * <P>
     *     日常收支表：分页
     * </P>
     * @param page 分页所有参数存在page中
     * @param financeOrder 模糊查询的参数存在financeOrder中
     * @return 日常收支表：分页的结果集
     */
    @Select("select fo.id as oid,fo.fo_num_list as foNumList,fo.fo_time as foTime,fo.fo_money as foMoney,fo.fo_account as foAccount,fo.fo_remark as foRemark,fo.fo_flag as foFlag,fc.fc_type as fcType from finance_order fo,finance_classify fc where fc.id = fo.fc_id and (fo.fo_flag like concat('%',#{financeOrder.foFlag},'%')) and(fo.fo_num_list like concat('%',#{financeOrder.foNumList},'%')) order by fo.id desc")
    List<Map<String,Object>> selectFoPage(Page page, FinanceOrder financeOrder);

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

    /**
     * <p>
     * 日常收支表
     * </p>
     * @return 查询收入总金额
     */
    @Select("select SUM(fo_money) as moneyshou from finance_order where fo_flag='收入'")
    Map<String,Object> selectMoneyMapByShou();

    /**
     * <p>
     * 日常收支表
     * </p>
     * @return 查询支出总金额
     */
    @Select("select SUM(fo_money) as moneyzhi from finance_order where fo_flag='支出'")
    Map<String,Object> selectMoneyMapByZhi();

    @Select("select fo.id as oid,fo.fo_num_list as foNumList,fo.fo_time as foTime,fo.fo_money as foMoney,fo.fo_account as foAccount,fo.fo_remark as foRemark,fo.fo_flag as foFlag,fc.fc_type as fcType from finance_order fo,finance_classify fc where fc.id = fo.fc_id")
    List<Map<String,Object>> selectFoByFlag(String flag);
}
