package com.yunhe.cargomanagement.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.cargomanagement.entity.PurComm;
import com.yunhe.cargomanagement.entity.WarehouseReceipt;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 入库历史 Mapper 接口
 * </p>
 *
 * @author 史江浩
 * @since 2019-01-17
 */

@Repository
@Mapper
public interface WarehouseReceiptMapper extends BaseMapper<WarehouseReceipt> {

    /**
     * 查询待入库单分页
     * @param page 分页插件
     * @param warehouseReceipt 入库实体类
     * @return 待入库单数据
     */
    List<WarehouseReceipt> selectwarehouseReceiptByState(Page page,WarehouseReceipt warehouseReceipt);

    /**
     * 查询入库单分页
     * @param page 分页插件
     * @param warehouseReceipt 入库实体类
     * @return 入库单数据
     */
    List<WarehouseReceipt> selectwarehouseReceiptTwoByState(Page page,WarehouseReceipt warehouseReceipt);

    /**
     * 根据ID删除入库单
     * @param warehouseReceipt 入库实体类
     * @return int
     */
    int deletewarehouseReceiptTwoById(WarehouseReceipt warehouseReceipt);

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

    /**
     * 根据订单号查询待入库单详情
     * @param wreNumber
     * @return
     */
    WarehouseReceipt selectWarhouseByNumber(String wreNumber);

    /**
     * 根据id修改入库状态
     * @param wreState 入库状态
     * @param id id
     * @return int
     */
    int updateWareHouseById(String wreState,int id);
}
