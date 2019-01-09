package com.yunhe.activitymanagement.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.activitymanagement.entity.MerchandisePackage;
import com.yunhe.activitymanagement.dao.MerchandisePackageMapper;
import com.yunhe.activitymanagement.service.IMerchandisePackageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品套餐 服务实现类
 * </p>
 *
 * @author 刘栋
 * @since 2019-01-07
 */
@Service
public class MerchandisePackageServiceImpl extends ServiceImpl<MerchandisePackageMapper, MerchandisePackage> implements IMerchandisePackageService {


    @Resource
    MerchandisePackageMapper merchandisePackageMapper;

    @Override
    public Map selectmpPage (int current, int size, MerchandisePackage merchandisePackage) {
        Page page = new Page(current,size);
        System.out.println("每页条数："+size);
        System.out.println("当前页数："+current);

        List<MerchandisePackage> list = merchandisePackageMapper.selectmpPage(page,merchandisePackage);
        Map map = new HashMap();
        map.put("list",list);
        map.put("pages",page.getPages());
        map.put("total",page.getTotal());
        System.out.println("总条数："+page.getTotal());
        System.out.println("总页数："+page.getPages());
        return map;
    }

    @Override
    public List<MerchandisePackage> selectmp() {
        return merchandisePackageMapper.selectList(null);
    }
}


