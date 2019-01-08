package com.yunhe.basicdata.controller;


import com.yunhe.basicdata.entity.SettlementAccount;
import com.yunhe.basicdata.service.impl.SettlementAccountServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 结算帐户 前端控制器
 * </p>
 *
 * @author 李恒逵, 唐凯宽
 * @since 2019-01-02
 */
@RestController
@RequestMapping("/basicdata/settlement-account")
public class SettlementAccountController {
    @Resource
    SettlementAccountServiceImpl settlementAccountService;

    /**
     * 查询账户的信息 分页
     *
     * @param current           当前页
     * @param size              每页的条数
     * @param settlementAccount 实体类信息
     * @return 所有账户的信息
     */
    @RequestMapping(value = "/getrAccounlist", method = RequestMethod.POST)
    @ResponseBody
    public Map selectAccountPage(int current, int size, SettlementAccount settlementAccount) {
        return settlementAccountService.selectAllAcountList(current, size, settlementAccount);
    }

    /**
     * 模糊查询
     *
     * @param data 模糊查询的条件
     * @return 根据data返回的数据
     */
    @RequestMapping(value = "/vaguelist", method = RequestMethod.POST)
    @ResponseBody
    public Map vagueAccountList(String data) {
        List vaguelist = settlementAccountService.vagueAccountList(data);
        Map map = new HashMap();
        map.put("data", vaguelist);
        return map;
    }

    /**
     * 增加账户的信息
     *
     * @param saName 账户的名称
     * @param saBank 开户银行
     * @return 无返回
     */
    @RequestMapping(value = "/insertaccount", method = RequestMethod.POST)
    public String insertAccountinfo(@RequestParam("saName") String saName, @RequestParam("saBank") String saBank) {
        SettlementAccount settlementAccount = new SettlementAccount();
        settlementAccount.setSaName(saName);
        settlementAccount.setSaBank(saBank);
        settlementAccountService.insertAccount(settlementAccount);
        return null;
    }

    /**
     * 查询账户的详细信息
     *
     * @param id 查询账户的id
     * @return 根据id返回的信息
     */
    @PostMapping("/selectAccountByid")
    @ResponseBody
    public Map selectAccountById(int id) {
        Map map = new HashMap();
        SettlementAccount selectAccountById = settlementAccountService.selectAccountById(id);
        map.put("selectAccountById", selectAccountById);
        return map;
    }

    /**
     * 修改账户的信息
     *
     * @param saName         账户名称
     * @param saBank         开户银行
     * @param saBalance      账户余额
     * @param saState        状态
     * @param saBankNumber   银行账号
     * @param saBeginBalance 期初余额
     * @param id             账户id
     * @return 修改后的账户信息
     */
    @RequestMapping(value = "/updateAccount", method = RequestMethod.POST)
    @ResponseBody
    public String updateAccountInfo(String saName, String saBank, Double saBalance, Integer saState, String saBankNumber, String saBeginBalance, int id) {
        SettlementAccount settlementAccount = new SettlementAccount();
        settlementAccount.setSaName(saName);
        settlementAccount.setSaBank(saBank);
        settlementAccount.setSaBalance(saBalance);
        settlementAccount.setId(id);
        settlementAccount.setSaBankNumber(saBankNumber);
        settlementAccount.setSaBeginBalance(saBeginBalance);
        settlementAccount.setSaState(saState);
        settlementAccountService.updateAccount(settlementAccount);
        return null;
    }

    /**
     * 删除账户的信息
     *
     * @param id 删除账户的id
     * @return 删除成功
     */
    @PostMapping(value = "/deleteAccount")
    @ResponseBody
    public String deleteAccount(int id) {
        SettlementAccount settlementAccount = new SettlementAccount();
        settlementAccount.setId(id);
        settlementAccountService.deleteAccount(settlementAccount);
        return null;
    }
}
