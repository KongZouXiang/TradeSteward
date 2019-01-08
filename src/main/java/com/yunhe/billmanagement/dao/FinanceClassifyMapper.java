package com.yunhe.billmanagement.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.billmanagement.entity.FinanceClassify;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 收支分类管理表(ymy) Mapper 接口
 * </p>
 *
 * @author 杨明月
 * @since 2019-01-02
 */
@Repository
public interface FinanceClassifyMapper extends BaseMapper<FinanceClassify> {
    /**
     * <P>
     *     收支分类管理表
     * </P>
     * @param financeClassify 收支分类内的参数存在一个对象里
     * @param page 分页的参数存在一个对象里
     * @return 收支分类管理表：分页的结果集
     */
    List<FinanceClassify> selectFcPage(Page page,FinanceClassify financeClassify);


}
