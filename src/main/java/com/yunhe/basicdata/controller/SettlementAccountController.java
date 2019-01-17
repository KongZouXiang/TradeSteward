package com.yunhe.basicdata.controller;
import com.yunhe.basicdata.entity.SettlementAccount;
import com.yunhe.basicdata.service.impl.SettlementAccountServiceImpl;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * <p>
 * 结算帐户 前端控制器
 * </p>
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
    @RequestMapping(value = "/getrAccounlist", method = RequestMethod.GET)
    @ResponseBody
    public Map selectAccountPage(int current, int size, SettlementAccount settlementAccount) {
        return settlementAccountService.selectAllAcountList(current, size, settlementAccount);
    }
    /**
     * 模糊查询
     * @param keyword 模糊查询的条件
     * @return 根据data返回的数据
     */
    @RequestMapping(value = "/vaguelist", method = RequestMethod.POST)
    @ResponseBody
    public Map vagueAccountList(@RequestParam("keyword") String keyword) {
        List vaguelist = settlementAccountService.vagueAccountList(keyword);
        Map map = new HashMap();
        map.put("data", vaguelist);
        return map;
    }
    /**
     * 增加账户的信息
     *
     * @param zhanghu 账户的名称
     * @param sabanknumber 开户银行
     * @return 无返回
     */
    @RequestMapping(value = "/insertaccount", method = RequestMethod.POST)
    public int insertAccountinfo(@RequestParam("zhanghu") String zhanghu, @RequestParam("sabank") String sabank,
                                    @RequestParam("sabanknumber") String sabanknumber ,@RequestParam("beginbalance") String beginbalance ,
                                    @RequestParam("zhangbalance") double zhangbalance,@RequestParam("zhangstate")int zhangstate) {
        SettlementAccount settlementAccount = new SettlementAccount();
        System.out.println("taiozahung");
        settlementAccount.setSaName(zhanghu);
        settlementAccount.setSaBank(sabank);
        settlementAccount.setSaBankNumber(sabanknumber);
        settlementAccount.setSaBeginBalance(beginbalance);
        settlementAccount.setSaBalance(zhangbalance);
        settlementAccount.setSaState(zhangstate);
        return   settlementAccountService.insertAccount(settlementAccount);
    }
    /**
     * 查询账户的详细信息
     * @param id 查询账户的id
     * @return 根据id返回的信息
     */
    @GetMapping("/selectAccountByid")
    public ModelAndView selectAccountById(@RequestParam("id") Integer id) {
        ModelAndView mv=new ModelAndView();
        SettlementAccount settlementAccountid = settlementAccountService.selectAccountById(id);
        mv.addObject("sellaccount",settlementAccountid);
        mv.setViewName("basicdata/editaccount");
        return mv;
    }

    /**
     * 账户详情
     * @param id 传过来的id
     * @return
     */
    @GetMapping("/detailaccount")
    public ModelAndView deatilaccount(@RequestParam("id") Integer id){
        ModelAndView mv=new ModelAndView();
      SettlementAccount detailaccount=  settlementAccountService.selectAccountById(id);
      mv.addObject("detailaccount",detailaccount);
      mv.setViewName("basicdata/detailaccount");
     return mv;
    }
    /**
     * 修改账户的信息
     * @param zhanghu         账户名称
     * @param sabank         开户银行
     * @param sabanknumber      账户余额
     * @param zhangstate        状态
     * @param sabanknumber   银行账号
     * @param beginbalance 期初余额
     * @param id             账户id
     * @return 修改后的账户信息
     */
    @RequestMapping(value = "/updateAccount", method = RequestMethod.GET)
    @ResponseBody
    public int  updateAccountInfo(@RequestParam("zhanghu") String zhanghu, @RequestParam("sabank") String sabank,
                                          @RequestParam("sabanknumber") String sabanknumber, @RequestParam("beginbalance") String beginbalance,
                                          @RequestParam("zhangbalance") double zhangbalance, @RequestParam("zhangstate") int  zhangstate,
                                          @RequestParam("id") int id) {
        SettlementAccount settlementAccount = new SettlementAccount();
        settlementAccount.setSaName(zhanghu);
        settlementAccount.setSaBank(sabank);
        settlementAccount.setSaBalance(zhangbalance);
        settlementAccount.setId(id);
        settlementAccount.setSaBankNumber(sabanknumber);
        settlementAccount.setSaBeginBalance(beginbalance);
        settlementAccount.setSaState(zhangstate);
        return  settlementAccountService.updateAccount(settlementAccount);
    }
    /**
     * 删除账户的信息
     * @param id 删除账户的id
     * @return 删除成功
     */
    @PostMapping(value = "/deleteAccount")
    @ResponseBody
    public int deleteAccount(@RequestParam("id") int id) {
        SettlementAccount settlementAccount = new SettlementAccount();
        System.out.println(id);
        settlementAccount.setId(id);
        return  settlementAccountService.deleteAccount(settlementAccount);
    }
    @RequestMapping("/addacounthtml")
    public ModelAndView AddAcount(){
        return new ModelAndView("basicdata/addacount");
    }
    @RequestMapping("/jumpaccount")
    public ModelAndView admingaccount(){
        return new ModelAndView("basicdata/adminaccount-list");
    }
   @RequestMapping("/jump")
   @ResponseBody
    public ModelAndView junp(Model model){
        return new ModelAndView("basicdata/edit");
    }
}
