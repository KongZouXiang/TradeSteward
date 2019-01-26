package com.yunhe.systemsetup.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunhe.systemsetup.dao.SystemLogMapper;
import com.yunhe.systemsetup.entity.SystemLog;
import com.yunhe.systemsetup.service.ISystemLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 系统日志表 服务实现类
 * </p>
 *
 * @author 孔邹祥
 * @since 2019-01-25
 */
@Service
public class SystemLogServiceImpl extends ServiceImpl<SystemLogMapper, SystemLog> implements ISystemLogService {

    @Resource
    SystemLogMapper systemLogMapper;

    @Override
    public IPage<SystemLog> selectAllSystemLog(Integer current, Integer size, SystemLog systemLog) {
        Page<SystemLog> page = new Page<>(current, size);

        return systemLogMapper.selectPage(page, new QueryWrapper<SystemLog>()
                .orderByDesc("id")
        );
    }

    @Override
    public Integer deleteByIdSystemLog(Integer id) {
        return systemLogMapper.delete(new QueryWrapper<SystemLog>().eq("id",id));
    }

}
