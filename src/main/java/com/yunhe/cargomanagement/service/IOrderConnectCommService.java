package com.yunhe.cargomanagement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yunhe.cargomanagement.entity.OrderConnectComm;
import com.yunhe.cargomanagement.entity.SalesHistory;
import com.yunhe.cargomanagement.entity.WaitOutWarehouse;

import java.util.Map;

/**
 * <p>
 * 等待出库 服务类
 * </p>
 *
 * @author 刘延琦
 * @since 2019-01-09
 */
public interface IOrderConnectCommService extends IService<OrderConnectComm> {
    int insertConn(OrderConnectComm orderConnectComm);

    OrderConnectComm slectOrderConnectComm(int first, int end);

    OrderConnectComm slectOrderSale(int first, int end);

    int updateOrderConnectComm(OrderConnectComm orderConnectComm);

    int updateSales(OrderConnectComm orderConnectComm);
}
