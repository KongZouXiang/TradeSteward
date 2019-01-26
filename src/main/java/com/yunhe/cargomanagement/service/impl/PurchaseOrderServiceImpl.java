package com.yunhe.cargomanagement.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.cargomanagement.entity.PurComm;
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
    public PurchaseOrder getPurchaseById(Integer id) {
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

    @Override
    public List<PurComm> selectPuOrder(PurchaseOrder purchaseOrder) {
        List<PurComm> array = null;
        List<PurchaseOrder> list = purchaseOrderMapper.selectPuOrder(purchaseOrder);
        System.out.println(list+"kl;;4*/*/**********/**");
        for (PurchaseOrder order : list) {
            List<PurComm> purComms = order.getPurComm();
        array = purComms;
        }
        System.out.println(array+"/*-*=/*-=/*-=/*-/=*-/=*");
        return array;
    }

    @Override
    public List<PurComm> selectComZhong(int id) {
        return purchaseOrderMapper.selectComZhong(id);
    }

    public PurchaseOrderMapper getPurchaseOrderMapper() {
        return purchaseOrderMapper;
    }

    public void setPurchaseOrderMapper(PurchaseOrderMapper purchaseOrderMapper) {
        this.purchaseOrderMapper = purchaseOrderMapper;
    }

    /**
     * <p>
     *     销售报表
     * </p>
     * @param pageNum 当前页
     * @param pageSize 每页条数
     * @return 所有信息集合
     */
    @Override
    public Map selectsaleMap(int pageNum, int pageSize) {
        Page page=new Page(pageNum,pageSize);
        List<Map<String,Object>> purch = purchaseOrderMapper.selectsaleMap(page);
        System.out.println("查询所有信息："+purch);
        Map map = new HashMap();
        map.put("total", page.getTotal());
        map.put("pages", page.getPages());
        map.put("purch", purch);
        return map;
    }
}
