package com.yunhe.activitymanagement;

import com.yunhe.activitymanagement.entity.CommodiTytemplate;
import com.yunhe.activitymanagement.service.ICommodiTytemplateService;
import com.yunhe.billmanagement.entity.FinanceClassify;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 刘栋
 * @date 2019/1/9 16:52
 */


@RunWith(SpringRunner.class)
@SpringBootTest
public class activitymanagement {


    @Resource
    ICommodiTytemplateService commodiTytemplateService;


    @Test
    public void contextLoads() {
        System.out.println("1");
    }


    /*查询商品模板数据*/
   /* @Test
    public void test1() {
        List<CommodiTytemplate> ct = commodiTytemplateService.list();
        System.out.println(ct);
    }
    *//*增加商品模板数据*//*
    @Test
    public void test2(){
        CommodiTytemplate ct = new CommodiTytemplate();
        ct.setCtTemplateNumber("777");
        ct.setCtTytemplateName("哎呀");
        ct.setCtTemplategoods("巧克力");
        ct.setCtRemarks("终于");
        boolean i =commodiTytemplateService.save(ct);
        System.out.println(i);
    }
    *//*修改商品模板数据*//*
    @Test
    public void test3(){
        CommodiTytemplate ct = new CommodiTytemplate();
        ct.setId(8);
        ct.setCtTemplateNumber("12121");
        ct.setCtTytemplateName("改变");
        ct.setCtTemplategoods("蛋糕");
        boolean i =commodiTytemplateService.updateById(ct);
        System.out.println(i);
    }
    *//*删除商品模板数据*//*
    @Test
    public void test4(){
        CommodiTytemplate ct = new CommodiTytemplate();
        ct.setId(8);
        boolean i =commodiTytemplateService.removeById(ct);
        System.out.println(i);
    }*/

}