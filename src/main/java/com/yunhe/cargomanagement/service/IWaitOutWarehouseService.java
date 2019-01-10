package com.yunhe.cargomanagement.service;

import com.yunhe.cargomanagement.entity.WaitOutWarehouse;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 等待出库 服务类
 * </p>
 *
 * @author 刘延琦
 * @since 2019-01-09
 */
public interface IWaitOutWarehouseService extends IService<WaitOutWarehouse> {


    int insertWaitOutWarehouse(WaitOutWarehouse waitOutWarehouse);

    int deleteWaitOutWarehouse(int id);

    int updateWaitOutWarehouse(WaitOutWarehouse waitOutWarehouse);

    Map queryLikeWaitOutWarehouse(int pageSize, int pageNum,WaitOutWarehouse waitOutWarehouse);
}
