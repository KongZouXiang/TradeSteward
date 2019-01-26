package com.yunhe.billmanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.billmanagement.entity.FundClientDebtDetail;
import com.yunhe.billmanagement.dao.FundClientDebtDetailMapper;
import com.yunhe.billmanagement.service.IFundClientDebtDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 欠款详细表 服务实现类
 * </p>
 *
 * @author 杨明月
 * @since 2019-01-21
 */
@Service
public class FundClientDebtDetailServiceImpl extends ServiceImpl<FundClientDebtDetailMapper, FundClientDebtDetail> implements IFundClientDebtDetailService {

    @Resource
    private FundClientDebtDetailMapper fundClientDebtDetailMapper;

    @Override
    public int maxId() {
        return fundClientDebtDetailMapper.maxId();
    }

    @Override
    public List<FundClientDebtDetail> selectDetailByName(String fcddFcdName) {
        return fundClientDebtDetailMapper.selectList(new QueryWrapper<FundClientDebtDetail>().eq("fcdd_fcd_name",fcddFcdName));
    }

    @Override
    public Map selectFcddPage(int current, int size,FundClientDebtDetail fundClientDebtDetail) {
        Page page = new Page(current,size);
        Map map = new HashMap();
        List<FundClientDebtDetail> list = fundClientDebtDetailMapper.selectFcddPage(page,fundClientDebtDetail);
        map.put("total",page.getTotal());
        map.put("pages",page.getPages());
        map.put("list",list);
        return map;
    }

    @Override
    public Map<String, Object> selectMoneyMapByName(String fcddFcdName) {
        return fundClientDebtDetailMapper.selectMoneyMapByName(fcddFcdName);
    }

}
