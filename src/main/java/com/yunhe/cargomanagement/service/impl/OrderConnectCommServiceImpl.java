package com.yunhe.cargomanagement.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunhe.cargomanagement.dao.OrderConnectCommMapper;
import com.yunhe.cargomanagement.entity.OrderConnectComm;
import com.yunhe.cargomanagement.service.IOrderConnectCommService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @BelongsProject: projectHouse
 * @ClassName:OrderConnectCommServiceImpl
 * @Author: 刘延琦
 * @CreateTime: 2019-1-24 17:26:32 17:26
 * @Version: 1.0
 */
@Service
public class OrderConnectCommServiceImpl extends ServiceImpl<OrderConnectCommMapper, OrderConnectComm> implements IOrderConnectCommService {


    @Resource
    private OrderConnectCommMapper orderConnectCommMapper;
    @Override
    public int insertConn(OrderConnectComm orderConnectComm) {

        return orderConnectCommMapper.insert(orderConnectComm);
    }
}
