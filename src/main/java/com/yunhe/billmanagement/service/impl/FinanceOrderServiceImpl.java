package com.yunhe.billmanagement.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunhe.billmanagement.dao.FinanceOrderMapper;
import com.yunhe.billmanagement.entity.FinanceOrder;
import com.yunhe.billmanagement.service.IFinanceOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 收支订单管理表(ymy) 服务实现类
 * </p>
 *
 * @author 杨明月
 * @since 2019-01-02
 */
@Service
public class FinanceOrderServiceImpl extends ServiceImpl<FinanceOrderMapper, FinanceOrder> implements IFinanceOrderService {

    @Resource
    private FinanceOrderMapper financeOrderMapper;

    @Override
    public Map selectFoPage(int current,int size,  FinanceOrder financeOrder) {
        Page page = new Page(current,size);
        Map map = new HashMap();
        List<Map<String,Object>> list = financeOrderMapper.selectFoPage(page,financeOrder);
        map.put("total",page.getTotal());
        map.put("pages",page.getPages());
        map.put("list",list);
        Map<String,Object> countListshou = financeOrderMapper.selectMoneyMapByShou();
        Map<String,Object> countListzhi = financeOrderMapper.selectMoneyMapByZhi();
        map.put("countListshou",countListshou);
        map.put("countListzhi",countListzhi);
        return map;
    }

    @Override
    public List<FinanceOrder> selectFo() {
        return financeOrderMapper.selectList(null);
    }

    @Override
    public List<Map<String,Object>> selectFoByFlag(String foFlag) {
        return financeOrderMapper.selectFoByFlag(foFlag);
    }

    @Override
    public int insertFo(FinanceOrder financeOrder) {
        return financeOrderMapper.insert(financeOrder);
    }

    @Override
    public FinanceOrder detailById(int id) {
        return financeOrderMapper.selectById(id);
    }

    @Override
    public int deleteFo(int id) {
        return financeOrderMapper.deleteById(id);
    }

    @Override
    public int maxId() {
        return financeOrderMapper.maxId();
    }

    @Override
    public int gaiFo(Map<String, Object> map) {
        return financeOrderMapper.gaiFo(map);
    }

    @Override
    public Map<String, Object> selectMoneyMapByShou() {
        return financeOrderMapper.selectMoneyMapByShou();
    }

    @Override
    public Map<String, Object> selectMoneyMapByZhi() {
        return financeOrderMapper.selectMoneyMapByZhi();
    }


}
