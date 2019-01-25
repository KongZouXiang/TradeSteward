package com.yunhe.cargomanagement.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yunhe.cargomanagement.entity.PurComm;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 进货详情中间表
 * </p>
 *
 * @since 2019-01-23
 * @author 史江浩
 */
@Repository
@Mapper
public interface PurCommMapper extends BaseMapper<PurComm> {

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
