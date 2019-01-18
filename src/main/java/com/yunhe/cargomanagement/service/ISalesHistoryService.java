package com.yunhe.cargomanagement.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.cargomanagement.entity.SalesHistory;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 销售历史 服务类
 * </p>
 *
 * @author 刘延琦
 * @since 2019-01-09
 */
public interface ISalesHistoryService extends IService<SalesHistory> {


    /*
     * 增加一条销售历史
     * @param salesHistory 增加的数据的实体类
     * @return 插入的条数
     */
    int addSalesHistory(SalesHistory salesHistory);

    /**
     * 根据id删除一条销售历史
     * @param id 要删除的历史的id
     * @return 删除成功的条数
     */
    int deleteSalesHistory(int id);

    /**
     * 根据id修改某一条销售历史
     * @param salesHistory 根据id锁定具体哪一条，根据参数进行修改
     * @return 成功的条数
     */
    int updateSalesHistory(SalesHistory salesHistory);

    SalesHistory selectById(int id);
    /**
     * 分页查询所有的信息
     * @param
     * @return
     */
    Map queryLikeSalesHistory(int pageNum, int pageSize, SalesHistory salesHistory);
}
