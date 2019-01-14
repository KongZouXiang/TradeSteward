package com.yunhe.billmanagement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yunhe.billmanagement.entity.FinanceClassify;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 收支分类管理表(ymy) 服务类
 * </p>
 *
 * @author 杨明月
 * @since 2019-01-02
 */
public interface IFinanceClassifyService extends IService<FinanceClassify> {
    /**
     * <P>
     *     收支项目管理表
     * </P>
     * @param current 当前页数
     * @param size 每页条数
     * @param financeClassify 查询条件放在对象里
     * @return 收支分类管理表：分页的结果集
     */
    Map selectFcPage(int current, int size, FinanceClassify financeClassify);

    /**
     * <P>
     *     查询数据
     * </P>
     * @return 收支分类管理表：查询的结果集
     */
    List<FinanceClassify> selectFc();

    /**
     * <P>
     *     增加数据
     * </P>
     * @param financeClassify 查询条件放在对象里
     * @return  收支分类管理表：增加是否成功true or false
     */
    int insertFc(FinanceClassify financeClassify);

    /**
     * <P>
     *     通过ID查询数据
     * </P>
     * @param id 要修改的的账目类型的ID
     * @return 要修改的账目类型的集合
     */
    FinanceClassify selectFcById(int id);

    /**
     * <P>
     *     修改数据
     * </P>
     * @param financeClassify 查询条件放在对象里
     * @return  收支分类管理表：修改是否成功true or false
     */
    int updateFc(FinanceClassify financeClassify);

    /**
     * <P>
     *     删除数据
     * </P>
     * @param financeClassify 查询条件放在对象里
     * @return  收支分类管理表：删除是否成功true or false
     */
    int deleteFc(FinanceClassify financeClassify);
}