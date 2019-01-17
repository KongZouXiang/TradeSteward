package com.yunhe.activitymanagement.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.activitymanagement.entity.CommodiTytemplate;
import com.yunhe.activitymanagement.entity.MerchandisePackage;
import com.yunhe.activitymanagement.dao.MerchandisePackageMapper;
import com.yunhe.activitymanagement.service.IMerchandisePackageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
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
  private MerchandisePackageMapper merchandisePackageMapper;

    @Override
    public Map queryLikeList(int current, int size, MerchandisePackage merchandisePackage) {
        Page page=new Page(current,size);
        List<MerchandisePackage> merchanlist =merchandisePackageMapper.selectmpPage(page);
        Map map = new HashMap();
        map.put("total", page.getTotal());
        map.put("pages", page.getPages());
        map.put("merchandisePackage",merchandisePackage);
        map.put("merchanlist", merchanlist);
        return map;
    }


    /**
     * 删除
     * */
    @Override
    public int deleteById(Serializable id) {
        return merchandisePackageMapper.deleteById(id);
    }

}


