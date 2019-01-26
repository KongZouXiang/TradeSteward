package com.yunhe.billmanagement.controller;


import com.yunhe.billmanagement.entity.AccountTransfer;
import com.yunhe.billmanagement.entity.RunningAccounts;
import com.yunhe.billmanagement.service.IAccountTransferService;
import com.yunhe.billmanagement.service.IRunningAccountsService;
import com.yunhe.core.common.annotion.WebLog;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 账户转账表(ymy) 前端控制器
 * </p>
 *
 * @author 杨明月
 * @since 2019-01-02
 */
@RestController
@RequestMapping("/billManagement/account-transfer")
public class AccountTransferController {

    @Resource
    private IAccountTransferService accountTransferService;

    @Resource
    private IRunningAccountsService runningAccountsService;
    /**
     * <P>
     *    进入账户转账页面
     * </P>
     * @return 进入bill-AccountTransfer.html
     */
    @WebLog("进入账户转账页面")
    @RequestMapping("/toAt")
    public ModelAndView toAt(){
        return new ModelAndView("billmanagement/bill-AccountTransfer");
    }
    /**
     * <P>
     *     分页
     * </P>
     * @param current 当前页数
     * @param size 每页条数
     * @return  账户转账表：分页的结果集
     */
    @WebLog("查看账户转账")
    @RequestMapping(value = "/selectAtPage",method = RequestMethod.GET)
    public Map selectAtPage(int current, int size, AccountTransfer accountTransfer){
        return accountTransferService.selectAtPage(current,size,accountTransfer);
    }

    /**
     * <P>
     *     查询数据
     * </P>
     * @return 账户转账表：查询的结果集
     */
    @WebLog("查看账户转账表所有信息")
    public List<AccountTransfer> selectAt() {
        return accountTransferService.selectAt();
    }

    /**
     * <P>
     *    进入增加页面
     * </P>
     * @return 进入FC_add.html
     */
    @WebLog("进入账户转账增加页面")
    @RequestMapping("/toAdd")
    public ModelAndView toAdd(){
        return new ModelAndView("billmanagement/bill-AT-add");
    }
    /**
     * <P>
     *     增加数据
     * </P>
     * @param accountTransfer 查询条件放在对象里
     * @return  账户转账表：增加是否成功
     */
    @WebLog("增加账户转账")
    @RequestMapping("/insertAt")
    public int insertAt(AccountTransfer accountTransfer) {
        int i= accountTransferService.insertAt(accountTransfer);
        if (i==1){
            RunningAccounts runningAccounts = new RunningAccounts();
            runningAccounts.setRaCompanyName("账户转账");//公司名称
            runningAccounts.setRaAccount(accountTransfer.getAtOutAccount());//转出账户
            runningAccounts.setRaOutcome(accountTransfer.getAtMoney()+accountTransfer.getAtCharge());//转出金额
            runningAccounts.setRaTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));//业务日期
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
            System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
            int maxId = runningAccountsService.selectRunningMaxIdMoney().getId();
            runningAccounts.setRaNumList("ZZ"+df.format(new Date())+"00"+maxId);//单据编号
            runningAccounts.setRaPerson(accountTransfer.getAtPerson());//经手人
            runningAccounts.setRaProjectName("转账支出");//收支项目名称
            runningAccounts.setRaCurrentBalance(runningAccountsService.selectRunningMaxIdMoney().getRaCurrentBalance()-(accountTransfer.getAtMoney()+accountTransfer.getAtCharge()));//当前余额
            runningAccountsService.insertRunningAccountsOne(runningAccounts);
        }
        return i;
    }

    /**
     * <P>
     *    进入详情页面
     * </P>
     * @param id 查询详情的id
     * @return 进入FO_detail.html
     */
    @WebLog("进入账户转账详情页面")
    @RequestMapping("/toDetail")
    public AccountTransfer toDetail(int id){
        return accountTransferService.detailById(id);
    }

    /**
     * <P>
     *     删除数据
     * </P>
     * @param accountTransfer 查询条件放在对象里
     * @return  账户转账表：删除是否成功
     */
    @WebLog("删除账户转账记录")
    @RequestMapping("/deleteAt")
    public int deleteAt(AccountTransfer accountTransfer) {
        int i = accountTransferService.deleteAt(accountTransfer);
        return i;
    }
}
