package com.yunhe.systemsetup.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 日志实体类
 *
 * @author 孔邹祥
 * @date 2019年1月24日1
 */

@Data
@TableName("system_log")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SystemLog implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 账号
     */
    @TableField("account")
    private String account;

    /**
     * 用户名
     */
    @TableField("username")
    private String username;

    /**
     * 操作
     */
    @TableField("operation")
    private String operation;

    /**
     * 方法名
     */
    @TableField(exist = false)
    private String method;

    /**
     * 参数
     */
    @TableField(exist = false)
    private String params;

    /**
     * ip地址
     */
    @TableField("ip")
    private String ip;

    /**
     * 操作时间
     */
    @TableField("create_date")
    private String createDate;

    /**
     * 日志查询开始时间
     */
    @TableField(exist = false)
    private String beginTime;

    /**
     * 日志查询结束时间
     */
    @TableField(exist = false)
    private String endTime;


}
