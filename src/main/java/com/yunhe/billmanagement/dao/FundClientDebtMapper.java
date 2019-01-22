package com.yunhe.billmanagement.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.billmanagement.entity.FundClientDebt;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 客户应收欠款表(ymy) Mapper 接口
 * </p>
 *
 * @author 杨明月
 * @since 2019-01-02
 */
@Repository
public interface FundClientDebtMapper extends BaseMapper<FundClientDebt> {
    /**
     * <P>
     *     客户应收欠款表
     * </P>
     * @param page 分页的参数存在一个对象里
     * @return 客户应收欠款表：分页的结果集
     */
    List<FundClientDebt> selectFcdPage(Page page, FundClientDebt fundClientDebt);

    /**
     * <P>
     *     客户应收欠款表
     * </P>
     * @return 查询所有款项之和
     */
    @Select("select SUM(fcd_begin_debt) as fcdBegin,SUM(fcd_add_debt) as fcdAdd,SUM(fcd_back_debt) as fcdBack,SUM(fcd_discount) as fcdDiscount,SUM(fcd_offset_deb) as fcdOffset,SUM(fcd_receivable) as fcdReceive from fund_client_debt")
    Map<String,Object> selectFcdMap();

    /**
     * <P>
     *    通过id查找该客户是否欠款
     * </P>
     * @return 集合
     */
    FundClientDebt selectFcdByName(String fcdName);

    @Update("update fund_client_debt set fcd_begin_debt = #{fcdBeginDebt},fcd_back_debt=#{fcdBackDebt},fcd_discount=#{fcdDiscount},fcd_receivable=#{fcdReceivable} where fcd_name=#{fcdName} ")
    int updateFcd(FundClientDebt fundClientDebt);
}