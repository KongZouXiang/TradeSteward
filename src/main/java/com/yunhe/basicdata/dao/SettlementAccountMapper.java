package com.yunhe.basicdata.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.basicdata.entity.SettlementAccount;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 结算帐户 Mapper 接口
 * </p>
 *
 * @author 李恒逵, 唐凯宽
 * @since 2019-01-02
 */
@Repository
@Mapper
public interface SettlementAccountMapper extends BaseMapper<SettlementAccount> {
    /**
     * 从数据库中获得账户信息（分页）
     *
     * @param page 分页信息的插件
     * @return 账户信息
     */
    List<SettlementAccount> selectAllAccountList(Page page);

    /**
     * 增加账户的信息
     *
     * @param settlementAccount 增加账户的实体类
     * @return 增加后的账户信息
     */
    int insertAccount(SettlementAccount settlementAccount);

    /**
     * 查询账户的详细信息
     *
     * @param id 查询账户详细信息的id
     * @return 根据id查询的账户信息
     */
    SettlementAccount selectAccountById(int id);

    /**
     * 修改账户的信息
     *
     * @param settlementAccount 修改账户的实体类
     * @return 修改后的账户信息
     */
    int updateAccount(SettlementAccount settlementAccount);

    /**
     * 删除账户的信息
     *
     * @param settlementAccount 删除账户的实体类
     * @return 无返回
     */
    int deleteAccount(SettlementAccount settlementAccount);
}
