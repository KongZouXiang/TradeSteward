package com.yunhe.billmanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunhe.billmanagement.dao.FinanceClassifyMapper;
import com.yunhe.billmanagement.entity.FinanceClassify;
import com.yunhe.billmanagement.service.IFinanceClassifyService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
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
    public Map selectFcPage(int current, int size, FinanceClassify financeClassify) {
        Map map = new HashMap();
        Page page = new Page(current,size);
        List<FinanceClassify> list = financeClassifyMapper.selectFcPage(page,financeClassify);
        map.put("list",list);
        map.put("total",page.getTotal());
        map.put("pages",page.getPages());
        return map;
    }

    @Override
    public List<FinanceClassify> selectFc() {
        return financeClassifyMapper.selectList(null);
    }

    @Override
    public List<FinanceClassify> selectFcBySort(FinanceClassify financeClassify) {
        return financeClassifyMapper.selectList(new QueryWrapper<FinanceClassify>().eq("fc_sort",financeClassify.getFcSort()));
    }

    @Override
    public int insertFc(FinanceClassify financeClassify) {
        return financeClassifyMapper.insert(financeClassify);
    }

    @Override
    public boolean checkFcExit(FinanceClassify financeClassify) {
        List<FinanceClassify> list = financeClassifyMapper.selectList(new QueryWrapper<FinanceClassify>().eq("fc_type",financeClassify.getFcType()));
        boolean b = false;
        if (list.size()==0){
            b=false;
        }else {
            b=true;
        }
        return b;
    }

    @Override
    public FinanceClassify selectFcById(int id) {
        return financeClassifyMapper.selectById(id);
    }

    @Override
    public int updateFc(FinanceClassify financeClassify) {
        return financeClassifyMapper.updateById(financeClassify);
    }

    @Override
    public int deleteFc(int id) {
        return financeClassifyMapper.deleteById(id);
    }

}