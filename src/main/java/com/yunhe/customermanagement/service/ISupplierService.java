package com.yunhe.customermanagement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yunhe.customermanagement.entity.Supplier;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 供应商管理 服务类
 * </p>
 *
 * @author 蔡慧鹏
 * @since 2019-01-02
 */
public interface ISupplierService extends IService<Supplier> {
    /**
     * <p>
     *根据id修改供应商
     * </p>
     *
     * @param传过来supplier对象
     * @return返回int类型
     */
    int updateSupplier(Supplier supplier);



    /**
     * <p>
     *        根据id删除供应商
     *    </p>
     * @param id 传过来id值
     * @return int
     */
    int deleteSupplier(int id);

    /**
     * <p>
     *     插入供应商信息
     * </p>
     * @param supplier 供应商对象
     * @return int
     */
    int insertSupplier(Supplier supplier);

    /**
     * <p>
     *     excel表格导入导出
     * </p>
     * @return 供应商列表
     */
    List<Supplier> selectAllExcel();

    /**
     * <p>
     *     查询并分页
     * </p>
     * @param current  当前页
     * @param size     每页显示的条数

     * @return
     */
    Map selectAll(int current,int size);



    /**
     * @author 史江浩
     * @since 2019-01-14
     * @return 查询所有供应商信息
     */
    Map selectList();
}
