package com.yunhe.basicdata.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.basicdata.entity.SettlementAccount;
import com.yunhe.basicdata.dao.SettlementAccountMapper;
import com.yunhe.basicdata.service.ISettlementAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 结算帐户 服务实现类
 * </p>
 *
 * @author 李恒奎,唐凯宽
 * @since 2019-01-02
 */
@Service
public class SettlementAccountServiceImpl extends ServiceImpl<SettlementAccountMapper, SettlementAccount> implements ISettlementAccountService {
    @Resource
    SettlementAccountMapper settlementAccountMapper;
    /**
     * 查询账户信息 分页
     * @param current           当前页
     * @param size              每页的条数
     * @param settlementAccount 实体类
     * @return 返回分页查询的信息
     */
    @Override
    public Map selectAllAcountList(int current, int size, SettlementAccount settlementAccount) {
        Page page = new Page(current, size);
        List<SettlementAccount> accountList = settlementAccountMapper.selectAllAccountList(page);
        Map map = new HashMap();
        map.put("total", page.getTotal());
        map.put("pages", page.getPages());
        map.put("accountList", accountList);
        map.put("settlementAccount", settlementAccount);

        return map;
    }
    /**
     * 模糊查询
     * @param data 模糊查询的条件
     * @return 返回模糊查询的信息
     */
    @Override
    public List<SettlementAccount> vagueAccountList(String data) {
        List<SettlementAccount> settlementAccountList = (List<SettlementAccount>) settlementAccountMapper.selectList(new QueryWrapper<SettlementAccount>().like("sa_name", data).or().like("sa_bank", data));
        return settlementAccountList;
    }
    /**
     * 增加账户的信息
     * @param settlementAccount 增加账户的实体类
     * @return 返回增加后的信息
     */
    @Override
    public int insertAccount(SettlementAccount settlementAccount) {
        return settlementAccountMapper.insertAccount(settlementAccount);
    }
    /**
     * 查询账户的详细信息
     * @param id 查询账户的详细信息 的id
     * @return 根据id查询的信息
     */
    @Override
    public SettlementAccount selectAccountById(int id) {
        return settlementAccountMapper.selectAccountById(id);
    }
    /**
     * 修改账户的信息
     * @param settlementAccount 修改账户的实体类
     * @return 返回修改后的信息
     */
    @Override
    public int updateAccount(SettlementAccount settlementAccount) {
        return settlementAccountMapper.updateAccount(settlementAccount);
    }
    /**
     * 删除账户的信息
     * @param settlementAccount 删除账户的实体类
     * @return 无返回
     */
    @Override
    public int deleteAccount(SettlementAccount settlementAccount) {
        return settlementAccountMapper.deleteAccount(settlementAccount);
    }
    /**
     * 检查银行账号是否存在
     * @param settlementAccount
     * @return
     */
    @Override
    public List<Map<String, String>> checkAccount(SettlementAccount settlementAccount) {
        return settlementAccountMapper.checkAccount(settlementAccount);
    }
}
