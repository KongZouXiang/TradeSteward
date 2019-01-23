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

}
