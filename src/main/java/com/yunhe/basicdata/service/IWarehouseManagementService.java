package com.yunhe.basicdata.service;

import com.yunhe.basicdata.entity.WarehouseManagement;
import com.baomidou.mybatisplus.extension.service.IService;

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
     *
     * @param pageSize 每页显示数量
     * @param pageNum  当前页
     * @return 仓库列表
     */
    Map selectWareList(String data, int pageSize, int pageNum);

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
    Integer update(WarehouseManagement warehouseManagement);

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
    Map vagueselect1(String data);

    /**
     * 增加仓库
     *
     * @param warehouseManagement 要增加仓库的实体类
     */
    Integer addWarehouse(WarehouseManagement warehouseManagement);

    /**
     * 查询仓库
     *
     * @return
     */
    List<WarehouseManagement> selectware();

    /**
     * 查询所有
     * @author 史江浩
     * @since 2019-01-24 09:45
     * @return 所有仓库信息
     */
    List<WarehouseManagement> selectquanWarList();
}
