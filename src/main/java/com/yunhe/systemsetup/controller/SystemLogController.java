package com.yunhe.systemsetup.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yunhe.core.common.annotion.WebLog;
import com.yunhe.core.util.RUDResult;
import com.yunhe.core.util.ResultRule;
import com.yunhe.systemsetup.entity.SystemLog;
import com.yunhe.systemsetup.service.ISystemLogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * <p>
 * 系统日志表 前端控制器
 * </p>
 *
 * @author 孔邹祥
 * @since 2019-01-25
 */
@RestController
@RequestMapping("/systemsetup/system-log")
public class SystemLogController {

    /**
     * 系统日志业务层
     */
    @Resource
    ISystemLogService systemLogService;

    /**
     * <p>
     * 跳转到系统日志
     * </p>
     *
     * @param modelAndView
     * @return
     */
    @WebLog("查看系统日志")
    @GetMapping("/toSystemLog")
    public ModelAndView toSystemLog(ModelAndView modelAndView) {
        modelAndView.setViewName("SystemLog");
        return modelAndView;
    }

    /**
     * <p>
     * 跳转到系统日志
     * </p>
     *
     * @return 所有的系统日志
     */
    @GetMapping("/selectAllSystemLog")
    public IPage<SystemLog> selectAllSystemLog(Integer current, Integer size, SystemLog systemLog) {
        System.out.println(size);
        return systemLogService.selectAllSystemLog(current, size, systemLog);
    }


    /**
     * <p>
     * 根据ID删除日志
     * </p>
     *
     * @return 删除日志的数量
     */
    @WebLog("删除了一条日志")
    @GetMapping("/selectAllSystemLog")
    public String deleteByIdSystemLog(Integer id) {
        return RUDResult.ConvertString(systemLogService.deleteByIdSystemLog(id), ResultRule.DELETE);
    }
}
