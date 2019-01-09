package com.yunhe.activitymanagement.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.activitymanagement.entity.CommodiTytemplate;
import com.yunhe.activitymanagement.dao.CommodiTytemplateMapper;
import com.yunhe.activitymanagement.service.ICommodiTytemplateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
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

    @Override
    public List<CommodiTytemplate> selectAll() {
        return commodiTytemplateMapper.selectList(null);
    }

    @Override
    public List insertCt(CommodiTytemplate commodiTytemplate) {
        return Collections.singletonList(commodiTytemplateMapper.insert(commodiTytemplate));
    }


    public List<CommodiTytemplate> selectCl() {
        return commodiTytemplateMapper.selectList(null);
    }

}
