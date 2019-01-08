package com.yunhe.cargomanagement.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.cargomanagement.entity.PurchaseHistory;
import com.yunhe.cargomanagement.dao.PurchaseHistoryMapper;
import com.yunhe.cargomanagement.service.IPurchaseHistoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 进货历史 服务实现类
 * </p>
 *
 * @author 史江浩
 * @since 2019-01-07
 */
@Service("purchaseHistoryService")
public class PurchaseHistoryServiceImpl extends ServiceImpl<PurchaseHistoryMapper, PurchaseHistory> implements IPurchaseHistoryService {

    @Resource
    PurchaseHistoryMapper purchaseHistoryMapper;

    @Override
    public Map getPurchaseHistoryByPhNumber(int pageNum, int pageSize, PurchaseHistory purchaseHistory) {
        Page page = new Page(pageNum,pageSize);
        //当前页
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        System.out.println("进货历史_当前页数："+pageNum);
        System.out.println("进货历史_每页条数："+pageSize);
        List<PurchaseHistory> list = purchaseHistoryMapper.getPurchaseHistoryByPhNumber(page, purchaseHistory);
        Map<String, Object> map = new HashMap<>();
        map.put("total",page.getTotal());
        map.put("pages",page.getPages());
        System.out.println("");
        map.put("list",list);
        return map;
    }

    public PurchaseHistoryMapper getPurchaseHistoryMapper() {
        return purchaseHistoryMapper;
    }

    public void setPurchaseHistoryMapper(PurchaseHistoryMapper purchaseHistoryMapper) {
        this.purchaseHistoryMapper = purchaseHistoryMapper;
    }
}
