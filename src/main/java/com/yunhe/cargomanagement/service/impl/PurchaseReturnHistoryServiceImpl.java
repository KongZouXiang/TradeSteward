package com.yunhe.cargomanagement.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.cargomanagement.entity.PurComm;
import com.yunhe.cargomanagement.entity.PurchaseReturnHistory;
import com.yunhe.cargomanagement.dao.PurchaseReturnHistoryMapper;
import com.yunhe.cargomanagement.service.IPurchaseReturnHistoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 进货退货历史 服务实现类
 * </p>
 *
 * @author 史江浩
 * @since 2019-01-09
 */
@Service("purchaseReturnHistoryService")
public class PurchaseReturnHistoryServiceImpl extends ServiceImpl<PurchaseReturnHistoryMapper, PurchaseReturnHistory> implements IPurchaseReturnHistoryService {

    @Resource
    private PurchaseReturnHistoryMapper purchaseReturnHistoryMapper;

    @Override
    public Map selectPurchaseReturnHistoryPage(int pageNum, int pageSize, PurchaseReturnHistory purchaseReturnHistory) {

        Page page = new Page(pageNum,pageSize);
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        List<PurchaseReturnHistory> list = purchaseReturnHistoryMapper.selectPurchaseReturnHistoryPage(page, purchaseReturnHistory);
        Map<String,Object> map = new HashMap();
        map.put("list",list);
        map.put("total",page.getTotal());
        map.put("pages",page.getPages());
        return map;
    }

    @Override
    public int insertPurchaseReturnHistoryPage(PurchaseReturnHistory purchaseReturnHistory) {
        return purchaseReturnHistoryMapper.insert(purchaseReturnHistory);
    }

    @Override
    public int updatePurchaseReturnHistory(PurchaseReturnHistory purchaseReturnHistory) {
        return purchaseReturnHistoryMapper.updateById(purchaseReturnHistory);
    }

    @Override
    public int deletePurchaseReturnHistory(Serializable id) {
        return purchaseReturnHistoryMapper.deleteById(id);
    }

    @Override
    public List<PurchaseReturnHistory> selectPurchaseReturnHistory() {
        return purchaseReturnHistoryMapper.selectList(null);
    }

    @Override
    public PurchaseReturnHistory selectOrderXiangList(int id) {
        return purchaseReturnHistoryMapper.selectOrderXiangList(id);
    }

    @Override
    public List<PurComm> selectOrderHistZhong(int id) {
        return purchaseReturnHistoryMapper.selectOrderHistZhong(id);
    }

    public PurchaseReturnHistoryMapper getPurchaseReturnHistoryMapper() {
        return purchaseReturnHistoryMapper;
    }

    public void setPurchaseReturnHistoryMapper(PurchaseReturnHistoryMapper purchaseReturnHistoryMapper) {
        this.purchaseReturnHistoryMapper = purchaseReturnHistoryMapper;
    }
}
