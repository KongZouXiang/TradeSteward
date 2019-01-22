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
 * @program: tradesteward
 * @description: 进货过程中间表
 * @author: 史江浩
 * @create: 2019-01-22 11:06
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@TableName("pur_comm")
public class PurComm implements Serializable {
    private static final long serialVersionUID = 1L;

    public PurComm() {
    }

    /**
     * id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 进货订单id
     */
    @TableField(value = "pu_id")
    private Integer puId;

    /**
     * 商品列表id
     */
    @TableField(value = "com_id")
    private Integer comId;

    /**
     * 进货历史id
     */
    @TableField(value = "puh_id")
    private Integer puhId;

    /**
     * 进货退货历史id
     */
    @TableField(value = "prh_id")
    private Integer prhId;

    /**
     * 商品进货数量
     */
    @TableField(value = "pc_geshu")
    private Integer pcGeshu;

    /**
     * 商品列表实体类
     */
    private CommodityList commodityList;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

}

