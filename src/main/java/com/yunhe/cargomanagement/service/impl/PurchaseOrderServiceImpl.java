package com.yunhe.cargomanagement.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.cargomanagement.entity.PurchaseOrder;
import com.yunhe.cargomanagement.dao.PurchaseOrderMapper;
import com.yunhe.cargomanagement.service.IPurchaseOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 进货订单历史 服务实现类
 * </p>
 *
 * @author 史江浩
 * @since 2019-01-02
 */
@Service("purchaseOrderService")
public class PurchaseOrderServiceImpl extends ServiceImpl<PurchaseOrderMapper, PurchaseOrder> implements IPurchaseOrderService {
    @Resource
    private PurchaseOrderMapper purchaseOrderMapper;

    @Override
    public Map getPurchaseByPoNumber(int pageNum, int pageSize, PurchaseOrder purchaseOrder) {
        Page page = new Page(pageNum,pageSize);
        page.setCurrent(pageNum);
        page.setSize(pageSize);

        List<PurchaseOrder> list = purchaseOrderMapper.getPurchaseByPoNumber(page,purchaseOrder);
        Map<String, Object> map = new HashMap<>();
        System.out.println("");
        map.put("list",list);
        map.put("total",page.getTotal());
        map.put("pages",page.getPages());
        return map;
    }



    @Override
    public int insertPurchaseOrder(PurchaseOrder purchaseOrder) {
        return purchaseOrderMapper.insert(purchaseOrder);
    }

    @Override
    public int deleteById(Serializable id) {
        return purchaseOrderMapper.deleteById(id);
    }

    @Override
    public void updategetPurchaseById(PurchaseOrder purchaseOrder) {
        purchaseOrderMapper.updategetPurchaseById(purchaseOrder);
    }

    @Override
    public PurchaseOrder selectById(Serializable id) {
        return purchaseOrderMapper.selectById(id);
    }

    @Override
    public List<PurchaseOrder> getPurchaseById(Integer id) {
        return purchaseOrderMapper.getPurchaseById(id);
    }

    @Override
    public int updateHistState(PurchaseOrder purchaseOrder) {
        return purchaseOrderMapper.updateHistState(purchaseOrder);
    }

    @Override
    public int updateHistStateByid(PurchaseOrder purchaseOrder) {
        return purchaseOrderMapper.updateById(purchaseOrder);
    }

    @Override
    public List<PurchaseOrder> selectPurchaseOrder() {
        return purchaseOrderMapper.selectList(null);
    }

    public PurchaseOrderMapper getPurchaseOrderMapper() {
        return purchaseOrderMapper;
    }

    public void setPurchaseOrderMapper(PurchaseOrderMapper purchaseOrderMapper) {
        this.purchaseOrderMapper = purchaseOrderMapper;
    }
}
