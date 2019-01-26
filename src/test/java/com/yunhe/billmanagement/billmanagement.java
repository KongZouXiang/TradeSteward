package com.yunhe.billmanagement;

import com.yunhe.billmanagement.dao.FinanceOrderMapper;
import com.yunhe.billmanagement.dao.RunningAccountsMapper;
import com.yunhe.billmanagement.entity.FinanceClassify;
import com.yunhe.billmanagement.entity.RunningAccounts;
import com.yunhe.billmanagement.service.IFinanceClassifyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * Test 测试
 * </p>
 *
 * @author 杨明月
 * @since 2019-01-04
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class billmanagement {

    @Resource
    IFinanceClassifyService financeClassifyService;
    @Resource
    FinanceOrderMapper financeOrderMapper;

    @Resource
    RunningAccountsMapper runningAccountsMapper;

   

    @Test
    public void contextLoads() {
        System.out.println("1");
    }

    /*查询项目分类数据*/
    @Test
    public void test1(){
        List<FinanceClassify> fc =financeClassifyService.list();
        System.out.println(fc);
    }
    /*增加项目分类数据*/
    @Test
    public void test2(){
        FinanceClassify fc = new FinanceClassify();
        fc.setFcSort("1213");
        fc.setFcType("1231");
        fc.setFcRemark("1231");
        boolean i =financeClassifyService.save(fc);
        System.out.println(i);
    }
    /*修改项目分类数据*/
    @Test
    public void test3(){
        FinanceClassify fc = new FinanceClassify();
        fc.setId(11);
        fc.setFcSort("2222");
        fc.setFcType("2222");
        fc.setFcRemark("2222");
        boolean i =financeClassifyService.updateById(fc);
        System.out.println(i);
    }
    /*删除项目分类数据*/
    @Test
    public void test4(){
        FinanceClassify fc = new FinanceClassify();
        fc.setId(11);
        boolean i =financeClassifyService.removeById(fc);
        System.out.println(i);
    }
    /*项目分类表 分页*/
    /*@Test
    public void test5(){
        List<FinanceClassify> financeClassifies = financeClassifyService.selectPage(1, 2,"");
        for (FinanceClassify financeClassify : financeClassifies) {
            System.out.println(financeClassifies);
        }
    }*/

    @Test
    public void test6(){
        System.out.println(runningAccountsMapper.selectCountMap());
    }

}

