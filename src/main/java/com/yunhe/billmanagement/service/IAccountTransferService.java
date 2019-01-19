package com.yunhe.billmanagement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yunhe.billmanagement.entity.AccountTransfer;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 账户转账表(ymy) 服务类
 * </p>
 *
 * @author 杨明月
 * @since 2019-01-02
 */
public interface IAccountTransferService extends IService<AccountTransfer> {

    /**
     * <P>
     *     账户转账表
     * </P>
     * @param current 当前页数
     * @param size 每页条数
     * @param accountTransfer 查询条件放在对象里
     * @return 账户转账表：分页的结果集
     */
    Map selectAtPage(int current, int size, AccountTransfer accountTransfer);

    /**
     * <P>
     *     查询数据
     * </P>
     * @return 账户转账表：查询的结果集
     */
     List<AccountTransfer> selectAt();

    /**
     * <P>
     *     增加数据
     * </P>
     * @param accountTransfer 查询条件放在对象里
     * @return  账户转账表：增加是否成功
     */
     int insertAt(AccountTransfer accountTransfer);

    /**
     * <P>
     *     数据详情
     * </P>
     * @param id 通过id查询
     * @return  账户转账表：修改是否成功
     */
    AccountTransfer detailById(int id);

    /**
     * <P>
     *     删除数据
     * </P>
     * @param accountTransfer 查询条件放在对象里
     * @return  账户转账表：删除是否成功
     */
     int deleteAt(AccountTransfer accountTransfer);

    /**
     * <p>
     *     账户转账表
     * </p>
     * @return 查询总金额和总手续费
     */
    Map<String,Object> selectAtCountMap();
}
