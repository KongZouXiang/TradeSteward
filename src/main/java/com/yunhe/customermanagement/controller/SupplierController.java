package com.yunhe.customermanagement.controller;


import com.yunhe.customermanagement.entity.Supplier;
import com.yunhe.customermanagement.service.ISupplierService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 * 供应商管理 前端控制器
 * </p>
 *
 * @author 蔡慧鹏
 * @since 2019-01-02
 */
@RestController
@RequestMapping("/customermanagement/supplier")
public class SupplierController {
    @Resource
    ISupplierService supplierService;

    /**
     * <p>
     *查询并分页
     * </p>
     *
     * @param current  当前页数
     * @param size     每页显示条数
     * @param supplier 模糊查询内容
     * @return total 总条数 pages 总页数 supplierList 客户表
     */
    @RequestMapping("/selectAllSupplier")
    @ResponseBody
    public Map selectAllSupplier(int current, int size, Supplier supplier) {
        return supplierService.selectAllSupplier(current, size, supplier);
    }


    /**
     * <p>
     *     查询供应商信息
     * </p>
     * @param supplier 查询供应商
     * @return 供应商对象
     */
    @RequestMapping("/selectSupplier")
    @ResponseBody
    public Supplier selectAllSupplier(Supplier supplier) {
        return supplier;
    }


    /**
     *<p>
     *     修改供应商信息
     *</p>
     * @param supplier 供应商
     * @return list页面
     */
    @RequestMapping("/updateSupplier")
    @ResponseBody
    public String updateSupplier(Supplier supplier) {
        supplierService.updateSupplier(supplier);

        return "list";
    }

    /**
     *<p>
     *     新增供应商
     *</p>
     * @param  supplier 新增供应商
     * @return list页面
     */
    @RequestMapping("/insertSupplier")
    @ResponseBody
    public String insertSupplier(Supplier supplier){
        supplierService.insertSupplier(supplier);
        return "list";
    }

    /**
     *<p>
     *    根据id删除供应商
     *</p>
     * @param id 根据id删除
     * @return list页面
     */

    @PostMapping("/deleteSupplier")
    @ResponseBody
    public String deleteSupplier(int id) {
        supplierService.deleteSupplier(id);
        return "list";
    }
}
