package com.yunhe.basicdata.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.basicdata.entity.WarehouseManagement;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yunhe.cargomanagement.entity.Warehouse;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 仓库管理 服务类
 * </p>
 *
 * @author 李恒逵, 唐凯宽
 * @since 2019-01-02
 */
public interface IWarehouseManagementService extends IService<WarehouseManagement> {
    /**
     * <>
     * 分页查询仓库
     * </>
     * @param pageSize 每页显示数量
     * @param pageNum 当前页
     * @return 仓库列表
     */
    Map selectWareList(int pageSize, int pageNum);

    /**
     * <>
     * 删除仓库
     * </>
     *
     * @param id 仓库ID
     */
    void deleteByid(int id);

    /**
     * 修改仓库
     *
     * @param warehouseManagement 仓库的实体类
     */
    void update(WarehouseManagement warehouseManagement);

    /**
     * 根据id查找仓库
     *
     * @param id 仓库ID
     * @return 根据id返回的仓库信息
     */
    WarehouseManagement selectByid(int id);

    /**
     * <>
     * 模糊查询
     * </>
     *
     * @param data 模糊查询属性
     * @return 根据查询得到的仓库信息
     */
    List<WarehouseManagement> vagueselect1(String data);
}
