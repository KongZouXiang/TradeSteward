package com.yunhe.cargomanagement.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunhe.cargomanagement.dao.PurCommMapper;
import com.yunhe.cargomanagement.entity.PurComm;
import com.yunhe.cargomanagement.service.IPurCommService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: tradesteward
 * @description: 进货详情中间表
 * @author: 史江浩
 * @create: 2019-01-23 19:22
 **/
@Service("purCommService")
public class PurCommServiceImpl extends ServiceImpl<PurCommMapper,PurComm> implements IPurCommService {
    @Resource
    private PurCommMapper purCommMapper;

    @Override
    public int insertPurComm(PurComm purComm) {
        return purCommMapper.insert(purComm);
    }

    @Override
    public int updatePurCommByPuId(int puhId,int puId) {
        return purCommMapper.updatePurCommByPuId(puhId,puId);
    }

    @Override
    public int updatePurCommByPuhId(int warhoureId, int puhId) {
        return purCommMapper.updatePurCommByPuhId(warhoureId,puhId);
    }

    @Override
    public int[] selectPcGeshuByWId(int id) {
        return purCommMapper.selectPcGeshuByWId(id);
    }

    @Override
    public int[] selectComIdByWId(int id) {
        return purCommMapper.selectComIdByWId(id);
    }
}
