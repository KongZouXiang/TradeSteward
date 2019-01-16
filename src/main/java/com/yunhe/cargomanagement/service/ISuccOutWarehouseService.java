package com.yunhe.cargomanagement.service;

import com.yunhe.cargomanagement.dao.SuccOutWarehouseMapper;
import com.yunhe.cargomanagement.entity.SuccOutWarehouse;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 出库单 服务类
 * </p>
 *
 * @author 刘延琦
 * @since 2019-01-09
 */
public interface ISuccOutWarehouseService extends IService<SuccOutWarehouse> {

    /**
     * 增加一条出库信息
     * @param succOutWarehouse
     * @return
     */
   int insertSuccOutWarehouse(SuccOutWarehouse succOutWarehouse);

    /**
     * 删除一条出库信息
     * @param id
     * @return
     */
   int deleteSuccOutWarehouse(int id);

    /**
     * 修改出库信息
     * @param succOutWarehouse
     * @return
     */
   int updateSuccOutWarehouse(SuccOutWarehouse succOutWarehouse);

    /**
     * 分页查询出库信息
     * @param pageSize
     * @param pageNum
     * @param succOutWarehouse
     * @return
     */
   Map queryLikeSuccOutWarehouse(int pageSize,int pageNum,SuccOutWarehouse succOutWarehouse);
}
