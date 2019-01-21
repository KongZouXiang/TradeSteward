package com.yunhe.basicdata.service;

import com.yunhe.basicdata.entity.SettlementAccount;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 结算帐户 服务类
 * </p>
 *
 * @author 李恒逵, 唐凯宽
 * @since 2019-01-02
 */
@Repository
public interface ISettlementAccountService extends IService<SettlementAccount> {
    /**
     * 从数据库中获取账户信息（分页）
     * @param current           当前页
     * @param size              每页的条数
     * @param settlementAccount 实体类
     * @return 分页信息
     */
    Map selectAllAcountList(int current, int size, SettlementAccount settlementAccount);
    /**
     * 模糊查询
     * @param data 模糊查询的条件
     * @return 模糊查询的信息
     */
    List<SettlementAccount> vagueAccountList(String data);
    /**
     * 增加账户的信息
     * @param settlementAccount 增加账户的实体类
     * @return 返回增加的账户信息
     */
    int insertAccount(SettlementAccount settlementAccount);
    /**
     * 查询账户的详细信息
     *
     * @param id 查询账户的id
     * @return 根据id查询的账户信息
     */
    SettlementAccount selectAccountById(int id);
    /**
     * 修改账户的信息
     *
     * @param settlementAccount 修改账户的实体类
     * @return 返回修改后的账户信息
     */
    int updateAccount(SettlementAccount settlementAccount);
    /**
     * 删除账户的信息

     * @param settlementAccount 删除账户的实体类
     * @return 无返回
     */
    int deleteAccount(SettlementAccount settlementAccount);
    List<Map<String,String>> checkAccount(SettlementAccount settlementAccount);
}
