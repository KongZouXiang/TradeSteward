package com.yunhe.activitymanagement.service.impl;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.activitymanagement.entity.CommodiTytemplate;
import com.yunhe.activitymanagement.dao.CommodiTytemplateMapper;
import com.yunhe.activitymanagement.service.ICommodiTytemplateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunhe.activitymanagement.service.ITemplateDetailsService;
import com.yunhe.basicdata.dao.CommodityListMapper;
import com.yunhe.basicdata.entity.CommodityList;
import org.springframework.stereotype.Service;


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

    @Resource
    ITemplateDetailsService templateDetailsService;


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
     * <P>
     *     查询数据
     * </P>
     * @return 商品模板表：查询所有模板的结果集
     */
    @Override
    public List<CommodiTytemplate> selectAllCt() {
        return null;
    }

    @Override
    public List<CommodityList> selectCt(Integer ctId) {
        return null;
    }



    /**
     * 增加商品模板
     * */





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
}


