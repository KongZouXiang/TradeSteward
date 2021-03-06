package com.yunhe.cargomanagement.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.Page;
import com.yunhe.cargomanagement.entity.Warehouse;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 库存查询 服务类
 * </p>
 *
 * @author 耿旺
 * @since 2019-01-02
 */
public interface IWarehouseService extends IService<Warehouse> {
    /**
     * <p>
     *     查询出所有warehouse的数据
     * </p>
     * @return 返回一个List集合
     */
     List<Warehouse> selectExcel();

    /**
     * <p>
     * 插入一条记录
     * </p>
     *
     * @param warehouse 实体对象
     * @return 插入成功记录数
     */
    int insertWareHouse(Warehouse warehouse);


    /**
     * <p>
     * 根据 ID 修改
     * </p>
     *
     * @param warehouse 实体对象
     * @return 修改成功记录数
     */
    int updateWareHouse(Warehouse warehouse);

    /**
     * <p>
     * 根据 ID 删除
     * </p>
     *
     * @param id 主键ID
     * @return 删除成功记录数
     */
    int deleteWareHouese(int id);

    /**
     * <p>
     * 根据 ID 查询
     * </p>
     *
     * @param id 主键ID
     * @return 实体对象WareHouse
     */
    Warehouse selectWareHouseById(int id);

    /**
     * <p>
     * 根据 Wrapper 条件，查询总记录数
     * </p>
     *
     * @param warehouse 实体对象
     * @return 满足条件记录数
     */
    /*int selectCount(Warehouse warehouse);*/



    /**
     * <p>
     * 分页
     * </p>
     *
     * @param pageNum  当前页
     * @param pageSize 每页数据条数
     * @return Page
     */
    Map selectWareHousePage(int pageNum,int pageSize);

    /**
     * <p>
     * 模糊查询
     * </p>
     *
     * @param warehouse 实体对象
     * @return list集合
     */
    List<Warehouse> selectWareHouseLike(Warehouse warehouse);


    /**
     * <p>
     *     分页加模糊查询
     * </p>
     *
     * @param pageNum 当前页
     * @param pageSize 每页数据条数
     * @param warehouse 实体对象
     * @return IPage
     */
    IPage<Warehouse> selectPage(int pageNum,int pageSize,Warehouse warehouse);

    /**
     * 根据商品名查询
     * @author 史江浩
     * @since 2019-01-25
     * @param waSpName 商品名
     * @return 库存数据
     */
    Warehouse selectWarehouseByWaSpName(String waSpName);


    /**
     * 根据商品名查询
     * @author 史江浩
     * @since 2019-01-25
     * @param waSpCurrentInventory 库存数量
     * @param waTotalSum 总金额
     * @param waSpName 商品名
     * @return int
     */
    int updateWarehouseByWaSpName(int waSpCurrentInventory,double waTotalSum,String waSpName);


}
