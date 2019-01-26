package com.yunhe.customermanagement.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.yunhe.customermanagement.entity.Customer;
import com.yunhe.customermanagement.entity.Supplier;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.Collection;
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
     * 删除（根据ID 批量删除）
     * </p>
     *
     * @param idList 主键ID列表(不能为 null 以及 empty)
     * @return 删除成功记录数
     */
    int deleteBatchIds(@Param(Constants.COLLECTION) Collection<? extends Serializable> idList);



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
     *     模糊查询分页
     * </p>
     * @param supplier
     * @return 模糊查询分页list
     */
    IPage<Supplier> selectPage(int current, int size, Supplier supplier);

    /**
     * @author 史江浩
     * @since 2019-01-14
     * @return 查询所有供应商信息
     */
    Map selectList();

    /**
     * <p>
     *      查询最大ID
     * </p>
     *@author 杨明月
     * @return zuidaID
     */
    int maxId();
}
