package com.yunhe.billmanagement.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunhe.billmanagement.dao.AccountTransferMapper;

import com.yunhe.billmanagement.entity.AccountTransfer;
import com.yunhe.billmanagement.service.IAccountTransferService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 账户转账表(ymy) 服务实现类
 * </p>
 *
 * @author 杨明月
 * @since 2019-01-04
 */
@Service
public class AccountTransferServiceImpl extends ServiceImpl<AccountTransferMapper, AccountTransfer> implements IAccountTransferService {

    @Resource
    AccountTransferMapper accountTransferMapper;



    @Override
    public Map selectAtPage(int current, int size, AccountTransfer accountTransfer) {
        Page page = new Page(current,size);
        System.out.println("每页条数："+size);
        System.out.println("当前页数："+current);
        List<AccountTransfer> list = accountTransferMapper.selectAtPage(page,accountTransfer);
        Map map = new HashMap();
        map.put("list",list);
        map.put("pages",page.getPages());
        map.put("total",page.getTotal());
        System.out.println("总条数："+page.getTotal());
        System.out.println("总页数："+page.getPages());
        return map;
    }

    @Override
    public List<AccountTransfer> selectAt() {
        return accountTransferMapper.selectList(null);
    }

    @Override
    public int insertAt(AccountTransfer accountTransfer) {
        return accountTransferMapper.insert(accountTransfer);
    }

    @Override
    public int updateAt(AccountTransfer accountTransfer) {
        return accountTransferMapper.updateById(accountTransfer);
    }

    @Override
    public int deleteAt(AccountTransfer accountTransfer) {
        return accountTransferMapper.deleteById(accountTransfer);
    }
}
