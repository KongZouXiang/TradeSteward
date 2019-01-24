package com.yunhe.core.aop.weblog;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SystemLogMapper extends BaseMapper<SystemLog> {

}
