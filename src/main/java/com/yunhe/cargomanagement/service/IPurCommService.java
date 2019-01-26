package com.yunhe.cargomanagement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yunhe.cargomanagement.entity.PurComm;

import java.util.List;

/**
 * <p>
 * 进货详情中间表 服务类
 * </p>
 *
 * @author 史江浩
 * @since 2019-01-23
 */
public interface IPurCommService extends IService<PurComm> {

    /**
     * 增加进货详情中间表
     * @param purComm 进货详情中间表实体类
     * @return int
     */
    int insertPurComm(PurComm purComm);

    /**
     * 根据进货订单历史id修改进货订单历史数据的 进货历史id
     * @param puhId 进货历史id
     * @param puId 进货订单历史id
     * @return int
     */
    int updatePurCommByPuId(int puhId,int puId);

    /**
     * 根据进货历史id修改入库历史数据的 入库历史id
     * @param warhoureId 入库历史id
     * @param puhId 进货历史id
     * @return int
     */
    int updatePurCommByPuhId(int warhoureId,int puhId);

    /**
     * 根据入库id查询商品数量
     * @param id
     * @return
     */
    int[] selectPcGeshuByWId(int id);


    /**
     * 根据入库id查询商品id
     * @param id
     * @return
     */
    int[] selectComIdByWId(int id);
}
