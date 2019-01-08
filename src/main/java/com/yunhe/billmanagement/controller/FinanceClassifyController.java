package com.yunhe.billmanagement.controller;


import com.yunhe.billmanagement.entity.FinanceClassify;
import com.yunhe.billmanagement.service.IFinanceClassifyService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 收支分类管理表(ymy) 前端控制器
 * </p>
 *
 * @author 杨明月
 * @since 2019-01-02
 */
@RestController
@RequestMapping("/billManagement/finance-classify")
public class FinanceClassifyController {

    @Resource
    IFinanceClassifyService financeClassifyService;

    /**
     * <P>
     *     分页
     * </P>
     * @param current 当前页数
     * @param size 每页条数
     * @return  收支分类管理表：分页的结果集
     */
    @RequestMapping(value = "/selectFcPage",method = RequestMethod.POST)
    public Map selectFcPage(int current, int size, FinanceClassify financeClassify) {

        return financeClassifyService.selectFcPage(current, size,financeClassify);
    }
    /**
     * <P>
     *     查询数据
     * </P>
     * @return 收支分类管理表：查询的结果集
     */
    @RequestMapping(value = "/selectFc",method = RequestMethod.POST)
    public List<FinanceClassify> selectFc() {
        return financeClassifyService.selectFc();
    }
    /**
     * <P>
     *     增加数据
     * </P>
     * @return  收支分类管理表：增加是否成功true or false
     */
    @RequestMapping(value = "/insertFc",method = RequestMethod.POST)
    public int insertFc(FinanceClassify financeClassify) {
        return financeClassifyService.insertFc(financeClassify);
    }
    /**
     * <P>
     *     修改数据
     * </P>
     * @return  收支分类管理表：修改是否成功true or false
     */
    @RequestMapping(value = "/updateFc",method = RequestMethod.POST)
    public int updateFc(FinanceClassify financeClassify) {
        return financeClassifyService.updateFc(financeClassify);
    }
    /**
     * <P>
     *     删除数据
     * </P>
     * @return  收支分类管理表：删除是否成功true or false
     */
    @RequestMapping(value = "/deleteFc",method = RequestMethod.POST)
    public int deleteFc(FinanceClassify financeClassify) {
        return financeClassifyService.deleteFc(financeClassify);
    }

}
