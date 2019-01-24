package com.yunhe.cargomanagement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yunhe.cargomanagement.entity.PurComm;

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
}
