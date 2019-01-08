package com.yunhe.billmanagement.controller;

import com.yunhe.billmanagement.entity.FinanceClassify;
import com.yunhe.billmanagement.entity.FinanceOrder;
import com.yunhe.billmanagement.service.IFinanceOrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 收支订单管理表(ymy) 前端控制器
 * </p>
 *
 * @author 杨明月
 * @since 2019-01-02
 */
@RestController
@RequestMapping("/billManagement/finance-order")
public class FinanceOrderController {

    @Resource
    private IFinanceOrderService financeOrderService;

    /**
     * <P>
     *     日常收支表
     * </P>
     * @param current 当前页
     * @param size 每页条数
     * @param financeOrder 日常收支的参数存在一个对象里
     * @return 日常收支表：分页的结果集
     */
    @PostMapping(value = "/selectFoPage")
    public Map selectFoPage(int current, int size,FinanceOrder financeOrder){
        return financeOrderService.selectFoPage(current,size,financeOrder);
    }

    /**
     * <P>
     *     查询数据
     * </P>
     * @param foFlag 判断收入、支出的标志
     * @return 日常收支表：查询的结果集
     */
    @PostMapping(value = "/selectFo")
    public List<FinanceOrder> selectFo(int foFlag) {
        return financeOrderService.selectFo(foFlag);
    }
    /**
     * <P>
     *     增加数据
     * </P>
     * @param financeOrder 日常收支类对象
     * @return  日常收支表：增加是否成功
     */
    @PostMapping(value = "/insertFo")
    public int insertFo(FinanceOrder financeOrder) {
        return financeOrderService.insertFo(financeOrder);
    }
    /**
     * <P>
     *     修改数据
     * </P>
     * @param financeOrder 日常收支类对象
     * @return  日常收支表：修改是否成功
     */
    @PostMapping(value = "/updateFo")
    public int updateFo(FinanceOrder financeOrder) {
        return financeOrderService.updateFo(financeOrder);
    }
    /**
     * <P>
     *     删除数据
     * </P>
     * @param financeOrder 日常收支类对象
     * @return  日常收支表：删除是否成功
     */
    @PostMapping(value = "/deleteFo")
    public int deleteFo(FinanceOrder financeOrder) {
        return financeOrderService.deleteFo(financeOrder);
    }
}
