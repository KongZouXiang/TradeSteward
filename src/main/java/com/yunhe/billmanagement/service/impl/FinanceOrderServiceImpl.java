package com.yunhe.billmanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunhe.billmanagement.dao.FinanceClassifyMapper;
import com.yunhe.billmanagement.dao.FinanceOrderMapper;
import com.yunhe.billmanagement.entity.FinanceClassify;
import com.yunhe.billmanagement.entity.FinanceOrder;
import com.yunhe.billmanagement.service.IFinanceOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
        System.out.println("模糊查询的内容："+financeOrder.getFoFlag()+":"+financeOrder.getFoNumList());
        Page page = new Page(current,size);
        System.out.println("每页条数："+size);
        System.out.println("当前页数："+current);
        Map map = new HashMap();
        List<FinanceOrder> list = financeOrderMapper.selectFoPage(page,financeOrder);
        System.out.println("遍历出来的长度："+list.size());
        map.put("total",page.getTotal());
        map.put("pages",page.getPages());
        map.put("list",list);
        System.out.println("总页数："+page.getPages());
        System.out.println("总条数："+page.getTotal());
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
    public List<FinanceOrder> selectFoByFlag(String foFlag) {
        return financeOrderMapper.selectList(new QueryWrapper<FinanceOrder>().eq("fo_flag",foFlag));
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
    public int updateFo(FinanceOrder financeOrder) {
        return financeOrderMapper.updateById(financeOrder);
    }

    @Override
    public int deleteFo(int id) {
        return financeOrderMapper.deleteById(id);
    }

    /*自动显示编码的SQL语句*/
    @Override
    public int maxId() {
        return financeOrderMapper.maxId();
    }

    @Override
    public int gaiFo(Map<String, Object> map) {
        System.out.println("进入修改的service");
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

    public FinanceOrderMapper getFinanceOrderMapper() {
        return financeOrderMapper;
    }

    public void setFinanceOrderMapper(FinanceOrderMapper financeOrderMapper) {
        this.financeOrderMapper = financeOrderMapper;
    }


}
