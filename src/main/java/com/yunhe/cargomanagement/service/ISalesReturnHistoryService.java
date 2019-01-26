package com.yunhe.cargomanagement.service;

import com.yunhe.cargomanagement.entity.OrderConnectComm;
import com.yunhe.cargomanagement.entity.SalesReturnHistory;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 销售退货历史 服务类
 * </p>
 *
 * @author 刘延琦
 * @since 2019-01-09
 */
public interface ISalesReturnHistoryService extends IService<SalesReturnHistory> {

    /**
     * 增加一条销售退货历史
     * @param salesReturnHistory 要插入的数据
     * @return 插入的条数
     */
    int insertSalesReturnHistory(SalesReturnHistory salesReturnHistory);

    /**
     * 删除一条数据
     * @param id 要删除的数据的id
     * @return 删除的条数
     */
    int deleteSalesReturnHistory(int id);

    /**
     * 修改一条数据
     * @param salesReturnHistory
     * @return 修改的条数
     */
    int updateSalesReturnHistory(SalesReturnHistory salesReturnHistory);

    /**
     * 分页查询
     * @param pageSize 每页条数
     * @param pageNum  当前页
     * @param salesReturnHistory 条件参数
     * @return map
     */
    Map queryLikeSalesReturnHistory(int pageSize,int pageNum,SalesReturnHistory salesReturnHistory);

    SalesReturnHistory selectById(int id);

    List<OrderConnectComm> detailList(int id);
}
