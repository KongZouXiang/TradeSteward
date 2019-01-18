package com.yunhe.cargomanagement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yunhe.cargomanagement.entity.WarehouseReceipt;

import java.util.Map;

/**
 * <p>
 * 入库历史 服务类
 * </p>
 *
 * @author 史江浩
 * @since 2019-01-02
 */
public interface IWarehouseReceiptService extends IService<WarehouseReceipt> {

    /**
     * 分页查询待入库单
     * @param pageNum 当前页
     * @param pageSize 每页条数
     * @param warehouseReceipt 入库历史实体类
     * @return 待入库单分页的数据
     */
    Map selectwarehouseReceiptByState(int pageNum, int pageSize,WarehouseReceipt warehouseReceipt);
}
