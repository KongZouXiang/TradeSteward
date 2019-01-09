package com.yunhe.cargomanagement.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.cargomanagement.entity.WaitOutWarehouse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 等待出库 Mapper 接口
 * </p>
 *
 * @author 刘延琦
 * @since 2019-01-09
 */
public interface WaitOutWarehouseMapper extends BaseMapper<WaitOutWarehouse> {

    List<WaitOutWarehouse> queryLikeWaitOutWarehouse(Page page,WaitOutWarehouse waitOutWarehouse);
}
