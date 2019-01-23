package com.yunhe.billmanagement.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunhe.billmanagement.dao.RunningAccountsMapper;
import com.yunhe.billmanagement.entity.RunningAccounts;
import com.yunhe.billmanagement.service.IRunningAccountsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 资金流水表(ymy) 服务实现类
 * </p>
 *
 * @author 杨明月
 * @since 2019-01-02
 */
@Service
public class RunningAccountsServiceImpl extends ServiceImpl<RunningAccountsMapper, RunningAccounts> implements IRunningAccountsService {

    @Resource
    private RunningAccountsMapper runningAccountsMapper;

    @Override
    public Map selectRaPage(int current, int size,RunningAccounts runningAccounts) {
        Map map = new HashMap();
        Page page = new Page(current,size);
        List<RunningAccounts> list = runningAccountsMapper.selectRaPage(page,runningAccounts);
        map.put("list",list);
        map.put("pages",page.getPages());
        map.put("total",page.getTotal());
        return map;
    }

    @Override
    public List<RunningAccounts> selectRa() {
        return runningAccountsMapper.selectList(null);
    }

    @Override
    public Map<String,Object> selectCountMap() {
        return runningAccountsMapper.selectCountMap();
    }

}
