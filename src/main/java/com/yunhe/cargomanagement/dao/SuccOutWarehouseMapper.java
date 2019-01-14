package com.yunhe.cargomanagement.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.cargomanagement.entity.SuccOutWarehouse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 出库单 Mapper 接口
 * </p>
 *
 * @author 刘延琦
 * @since 2019-01-09
 */
public interface SuccOutWarehouseMapper extends BaseMapper<SuccOutWarehouse> {

    List<SuccOutWarehouse> queryLikeSuccOutWarehouse(Page page,SuccOutWarehouse succOutWarehouse);
}
