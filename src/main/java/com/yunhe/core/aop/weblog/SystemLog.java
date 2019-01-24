package com.yunhe.core.aop.weblog;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 日志实体类
 *
 * @author 孔邹祥
 * @date 2019年1月24日1
 */

@Data
@TableName("system_log")
@EqualsAndHashCode(callSuper = true)
public class SystemLog extends Model<SystemLog> implements Serializable {

    /**
     * 主键
     */
    @TableId(value = "id",type = IdType.AUTO)
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
     * ip地址
     */
    @TableField("ip")
    private String ip;

    /**
     * 操作时间
     */
    @TableField("create_date")
    private String createDate;

}
