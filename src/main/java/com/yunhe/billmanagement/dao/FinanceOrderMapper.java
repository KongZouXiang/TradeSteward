package com.yunhe.billmanagement.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.billmanagement.entity.FinanceOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
    List<FinanceOrder> selectFoPage(Page page,FinanceOrder financeOrder);

}
