package com.yunhe.cargomanagement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.yunhe.basicdata.entity.CommodityList;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @BelongsProject: projectHouse
 * @ClassName:OrderConnectComm
 * @Author: 刘延琦
 * @CreateTime: 2019-1-10 11:10:15 11:10
 * @Version: 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@TableName("order_connect_comm")
public class OrderConnectComm implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private int id;

    @TableField("order_num")
    private int orderNum;

    @TableField("sell_order_num")
    private int sellOrderNum;

    @TableField("return_num")
    private int returnNum;

    @TableField("cl_id")
    private int clId;

    @TableField("order_count")
    private int orderCount;
    private CommodityList commodityList;
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
