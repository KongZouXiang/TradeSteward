package com.yunhe.billmanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.billmanagement.entity.FinanceClassify;
import com.yunhe.billmanagement.dao.FinanceClassifyMapper;
import com.yunhe.billmanagement.service.IFinanceClassifyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Wrapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 收支分类管理表(ymy) 服务实现类
 * </p>
 *
 * @author 杨明月
 * @since 2019-01-02
 */
@Service
public class FinanceClassifyServiceImpl extends ServiceImpl<FinanceClassifyMapper, FinanceClassify> implements IFinanceClassifyService {

    @Resource
    private FinanceClassifyMapper financeClassifyMapper;


    @Override
    public Map selectFcPage(int current, int size,FinanceClassify financeClassify) {
        Map map = new HashMap();
        Page page = new Page(current,size);
        System.out.println("每页条数："+size);
        System.out.println("当前页数："+current);
        List<FinanceClassify> list = financeClassifyMapper.selectFcPage(page,financeClassify);
        map.put("list",list);
        map.put("total",page.getTotal());
        map.put("pages",page.getPages());
        System.out.println("总条数："+page.getTotal());
        System.out.println("总页数："+page.getPages());
        return map;
    }

    @Override
    public List<FinanceClassify> selectFc() {
        return financeClassifyMapper.selectList(null);
    }

    @Override
    public int insertFc(FinanceClassify financeClassify) {
        return financeClassifyMapper.insert(financeClassify);
    }

    @Override
    public int updateFc(FinanceClassify financeClassify) {
        return financeClassifyMapper.updateById(financeClassify);
    }

    @Override
    public int deleteFc(FinanceClassify financeClassify) {
        return financeClassifyMapper.deleteById(financeClassify);
    }


    public FinanceClassifyMapper getFinanceClassifyMapper() {
        return financeClassifyMapper;
    }

    public void setFinanceClassifyMapper(FinanceClassifyMapper financeClassifyMapper) {
        this.financeClassifyMapper = financeClassifyMapper;
    }
}
