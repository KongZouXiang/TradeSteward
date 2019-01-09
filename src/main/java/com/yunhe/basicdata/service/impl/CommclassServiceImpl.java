package com.yunhe.basicdata.service.impl;

import com.yunhe.basicdata.entity.Commclass;
import com.yunhe.basicdata.dao.CommclassMapper;
import com.yunhe.basicdata.service.ICommclassService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品分类 服务实现类
 * </p>
 *
 * @author 李恒奎,唐凯宽
 * @since 2019-01-02
 */
@Service
public class CommclassServiceImpl extends ServiceImpl<CommclassMapper, Commclass> implements ICommclassService {
    @Resource
    private CommclassMapper commclassMapper;

    @Override
    public List<Commclass> query() {
        return commclassMapper.query();
    }

    @Override
    public List<Commclass> sel(String name) {

        return commclassMapper.sel(name);
    }

    @Override
    public void add(String ccdefault) {
        commclassMapper.add(ccdefault);

    }

    @Override
    public void updateCommclass(Map map) {
        commclassMapper.updateCommclass(map);
    }

    @Override
    public void deleteCommclass(String name) {
        commclassMapper.deleteCommclass(name);

    }


}
