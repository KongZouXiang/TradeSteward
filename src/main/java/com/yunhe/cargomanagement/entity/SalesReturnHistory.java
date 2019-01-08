package com.yunhe.cargomanagement.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 销售退货历史
 * </p>
 *
 * @author 史江浩
 * @since 2019-01-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SalesReturnHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 业务处理日期
     */
    private String srhDate;

    /**
     * 单据编号
     */
    private String srhNumber;

    /**
     * 客户id(外键)
     */
    private Integer cusId;

    /**
     * 仓库id(外键)
     */
    private Integer waId;

    /**
     * 入库仓库
     */
    @TableField("srh_Warehouse")
    private String srhWarehouse;

    /**
     * 入库状态
     */
    private Integer srhState;

    /**
     * 纸质单据
     */
    private String srhBill;


}
