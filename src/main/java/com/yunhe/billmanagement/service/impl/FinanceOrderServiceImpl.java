package com.yunhe.billmanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.billmanagement.entity.FinanceOrder;
import com.yunhe.billmanagement.dao.FinanceOrderMapper;
import com.yunhe.billmanagement.service.IFinanceOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Wrapper;
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
        System.out.println("每页条数："+size);
        System.out.println("当前页数："+current);
        Map map = new HashMap();
        List<FinanceOrder> list = financeOrderMapper.selectFoPage(page,financeOrder);
        map.put("list",list);
        map.put("total",page.getTotal());
        map.put("pages",page.getPages());
        System.out.println("总页数："+page.getPages());
        System.out.println("总条数："+page.getTotal());
       return map;
    }

    @Override
    public List<FinanceOrder> selectFo(int foFlag) {
        return financeOrderMapper.selectList(new QueryWrapper<FinanceOrder>().eq("fo_flag","foFlag"));
    }

    @Override
    public int insertFo(FinanceOrder financeOrder) {
        return financeOrderMapper.updateById(financeOrder);
    }

    @Override
    public int updateFo(FinanceOrder financeOrder) {
        return financeOrderMapper.updateById(financeOrder);
    }

    @Override
    public int deleteFo(FinanceOrder financeOrder) {
        return financeOrderMapper.deleteById(financeOrder);
    }

    public FinanceOrderMapper getFinanceOrderMapper() {
        return financeOrderMapper;
    }

    public void setFinanceOrderMapper(FinanceOrderMapper financeOrderMapper) {
        this.financeOrderMapper = financeOrderMapper;
    }


}
