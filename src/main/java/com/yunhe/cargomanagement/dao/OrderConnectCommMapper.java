package com.yunhe.cargomanagement.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yunhe.cargomanagement.entity.OrderConnectComm;
import com.yunhe.cargomanagement.entity.SalesHistory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @BelongsProject: projectHouse
 * @ClassName:OrderConnectCommMapper
 * @Author: 刘延琦
 * @CreateTime: 2019-1-24 17:23:03 17:23
 * @Version: 1.0
 */
@Repository
@Mapper
public interface OrderConnectCommMapper extends BaseMapper<OrderConnectComm> {
    OrderConnectComm selectOrderConnectComm(int first,int end);

    OrderConnectComm selectOrderSale(int first,int end);

    int updateSalesHistory(OrderConnectComm orderConnectComm);
}
