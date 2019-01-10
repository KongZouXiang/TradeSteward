package com.yunhe.activitymanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.activitymanagement.entity.CommodiTytemplate;
import com.yunhe.activitymanagement.dao.CommodiTytemplateMapper;
import com.yunhe.activitymanagement.entity.TemplateCommodity;
import com.yunhe.activitymanagement.service.ICommodiTytemplateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunhe.basicdata.dao.CommodityListMapper;
import com.yunhe.basicdata.entity.CommodityList;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品模板 服务实现类
 * </p>
 *
 * @author 刘栋
 * @since 2019-01-07
 */
@Service
public class CommodiTytemplateServiceImpl extends ServiceImpl<CommodiTytemplateMapper, CommodiTytemplate> implements ICommodiTytemplateService {


    @Resource
    CommodiTytemplateMapper commodiTytemplateMapper;

    @Resource
    CommodityListMapper commodityListMapper;


        @Override
    public Map selectAllPage (int current, int size, CommodiTytemplate commodiTytemplate) {
        Page page = new Page(current,size);
        System.out.println("每页条数："+size);
        System.out.println("当前页数："+current);

        List<CommodiTytemplate> list = commodiTytemplateMapper.selectAllPage(page,commodiTytemplate);
        Map map = new HashMap();
        map.put("list",list);
        map.put("pages",page.getPages());
        map.put("total",page.getTotal());
        System.out.println("总条数："+page.getTotal());
        System.out.println("总页数："+page.getPages());
        return map;
    }


/**
 * 增加
 * */
    @Override
    @Transactional
    public List<Integer> insertCt(CommodiTytemplate commodiTytemplate) {

//        1.插入商品模板
        commodiTytemplateMapper.insert(commodiTytemplate);
//        2.查询出刚刚插入的商品模板id
        CommodiTytemplate id = commodiTytemplateMapper.selectOne(new QueryWrapper<CommodiTytemplate>().eq("id", commodiTytemplate.getId()));
//        3.用于拼接模板商品属性
        String sb="";
//        4.根据传进来的commodiTytemplate.setCommodityId() 商品列表id一次插入关联表
        for (Integer i : commodiTytemplate.getCommodityId()) {
//            获取商品模板id属性和商品列表id属性
            TemplateCommodity templateCommodity = new TemplateCommodity();
            templateCommodity.setCtId(id.getId());
            templateCommodity.setClId(i);
//            插入关联表
            templateCommodity.insert();
//            5.拼接模板商品属性
            sb+=(commodityListMapper.selectCommById(i).getClName());
        }
//        6.修改模板商品的模板商品
        CommodiTytemplate commo = new CommodiTytemplate();
        commo.setId(id.getId());
        commo.setCtTemplategoods(sb);
        commodiTytemplateMapper.updateById(commo);
        return commodiTytemplate.getCommodityId();
        }



    public List<CommodiTytemplate> selectCl() {
        return commodiTytemplateMapper.selectList(null);
    }


    /**
     * 删除
     * */
    @Override
    public int deleteCt(CommodiTytemplate commodiTytemplate) {
        return commodiTytemplateMapper.deleteById(commodiTytemplate);
    }


/**
 * 修改
* */
    @Override
    public int updateCt(CommodiTytemplate commodiTytemplate) {
        return commodiTytemplateMapper.updateById(commodiTytemplate);
    }
/**
* 查询
* */
    @Override
    public List<CommodityList> selectAllCt(Integer ctId) {
        List<CommodityList> commodityLists = commodiTytemplateMapper.selectCt(ctId);
        for (CommodityList commodityList : commodityLists) {
            if (commodityList.getId())
        }
        return commodityLists;
    }

}


