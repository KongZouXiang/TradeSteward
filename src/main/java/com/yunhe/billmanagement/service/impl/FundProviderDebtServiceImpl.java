package com.yunhe.billmanagement.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunhe.billmanagement.dao.FundProviderDebtMapper;
import com.yunhe.billmanagement.entity.FundProviderDebt;
import com.yunhe.billmanagement.service.IFundProviderDebtService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 供应商应付欠款表(ymy) 服务实现类
 * </p>
 *
 * @author 杨明月
 * @since 2019-01-02
 */
@Service
public class FundProviderDebtServiceImpl extends ServiceImpl<FundProviderDebtMapper, FundProviderDebt> implements IFundProviderDebtService {

    @Resource
    private FundProviderDebtMapper fundProviderDebtMapper;

    @Override
    public Map selectFpdPage(int current, int size,FundProviderDebt fundProviderDebt) {
        System.out.println("每页条数："+size);
        System.out.println("当前页数："+current);
        Page page = new Page(current,size);
        System.out.println("总条数："+page.getTotal());
        System.out.println("总页数："+page.getPages());
        Map map = new HashMap();
        List<FundProviderDebt> list =fundProviderDebtMapper.selectFpdPage(page,fundProviderDebt);
        System.out.println(list);
        map.put("list",list);
        map.put("pages",page.getPages());
        map.put("total",page.getTotal());
        return map;
    }

    @Override
    public int insertFpd(FundProviderDebt fundProviderDebt) {
        return fundProviderDebtMapper.insert(fundProviderDebt);
    }

    @Override
    public FundProviderDebt selectFpd(int id) {
        return fundProviderDebtMapper.selectById(id);
    }
}
