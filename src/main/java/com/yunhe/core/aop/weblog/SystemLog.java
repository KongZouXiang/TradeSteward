package com.yunhe.core.aop.weblog;

import lombok.Data;

import java.io.Serializable;

/**
 * 日志实体类
 * @author 孔邹祥
 * @date 2019年1月24日1
 */
@Data
public class SystemLog implements Serializable {

    private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 操作
     */
    private String operation;

    /**
     * 方法名
     */
    private String method;

    /**
     * 参数
     */
    private String params;

    /**
     * ip地址
     */
    private String ip;

    /**
     * 操作时间
     */
    private String createDate;

}
