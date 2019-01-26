package com.yunhe.billmanagement.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunhe.billmanagement.dao.FundProviderDebtMapper;
import com.yunhe.billmanagement.entity.FundClientDebt;
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
        Page page = new Page(current,size);
        Map map = new HashMap();
        List<FundProviderDebt> list =fundProviderDebtMapper.selectFpdPage(page,fundProviderDebt);
        map.put("list",list);
        map.put("pages",page.getPages());
        map.put("total",page.getTotal());
        return map;
    }

    @Override
    public FundProviderDebt selectIdFpdExit(String fpdName) {
        return fundProviderDebtMapper.selectFpdByName(fpdName);
    }

    @Override
    public int insertFpd(FundProviderDebt fundProviderDebt) {
        return fundProviderDebtMapper.insert(fundProviderDebt);
    }

    @Override
    public int updateFpd(FundProviderDebt fundProviderDebt) {
        return fundProviderDebtMapper.updateFpd(fundProviderDebt);
    }

    @Override
    public List<FundProviderDebt> selectFpd() {
        return fundProviderDebtMapper.selectList(null);
    }

    @Override
    public Map<String, Object> selectFpdMap() {
        return fundProviderDebtMapper.selectFpdMap();
    }
}
