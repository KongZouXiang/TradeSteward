package com.yunhe.cargomanagement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yunhe.cargomanagement.entity.PurComm;
import com.yunhe.cargomanagement.entity.WarehouseReceipt;

import java.util.List;
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

    /**
     * 分页查询入库单
     * @param pageNum 当前页
     * @param pageSize 每页条数
     * @param warehouseReceipt 入库历史实体类
     * @return 入库单分页的数据
     */
    Map selectwarehouseReceiptTwoByState(int pageNum, int pageSize,WarehouseReceipt warehouseReceipt);

    /**
     * 根据ID删除入库单
     * @param warehouseReceipt 入库实体类
     * @return int
     */
    int deletewarehouseReceiptTwoById(Map warehouseReceipt);

    /**
     * 待入库单详情
     * @param id 根据id查询
     * @return 待入库单详情
     */
    WarehouseReceipt selectWarhouseXiangList(int id);

    /**
     * 入库单详情
     * @param id 根据id查询
     * @return 入库单详情
     */
    WarehouseReceipt selectWarhouseXiangTwoList(int id);

    /**
     * 一对一
     * @return 商品信息
     */
    List<PurComm> selectWarHouseZhong(int id);

}
