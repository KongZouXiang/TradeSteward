package com.yunhe.basicdata.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.basicdata.entity.WarehouseManagement;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;

/**
 * <p>
 * 仓库管理 Mapper 接口
 * </p>
 *
 * @author 李恒逵, 唐凯宽
 * @since 2019-01-02
 */
public interface WarehouseManagementMapper extends BaseMapper<WarehouseManagement> {
    /**
     * <>
     *     分页查询仓库
     * </>
     * @param page 分页
     * @return 仓库列表数据
     */
    List<WarehouseManagement> selectWareList(String data,Page page);


}
