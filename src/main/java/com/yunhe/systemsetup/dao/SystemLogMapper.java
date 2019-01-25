package com.yunhe.systemsetup.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.systemsetup.entity.SystemLog;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 系统日志表 Mapper 接口
 * </p>
 *
 * @author 孔邹祥
 * @since 2019-01-25
 */
@Repository
public interface SystemLogMapper extends BaseMapper<SystemLog> {
    List<SystemLog> selectSystemall(Page page);
}
