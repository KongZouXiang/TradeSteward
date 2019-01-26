package com.yunhe.systemsetup.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yunhe.systemsetup.entity.SystemLog;

/**
 * <p>
 * 系统日志表 服务类
 * </p>
 *
 * @author 孔邹祥
 * @since 2019-01-25
 */
public interface ISystemLogService extends IService<SystemLog> {


    /**
     * 查看出所有日志
     *
     * @return 日志结果
     */
    IPage<SystemLog> selectAllSystemLog(Integer current, Integer size);

}
