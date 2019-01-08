package com.yunhe.billmanagement.controller;


import com.yunhe.billmanagement.entity.AccountTransfer;
import com.yunhe.billmanagement.service.IAccountTransferService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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

    /**
     * <P>
     *     分页
     * </P>
     * @param current 当前页数
     * @param size 每页条数
     * @return  账户转账表：分页的结果集
     */
    @RequestMapping(value = "/selectAtPage",method = RequestMethod.POST)
    public Map selectAtPage(int current, int size, AccountTransfer accountTransfer){
        return accountTransferService.selectAtPage(current,size,accountTransfer);
    }

    /**
     * <P>
     *     查询数据
     * </P>
     * @return 账户转账表：查询的结果集
     */
    public List<AccountTransfer> selectAt() {
        return accountTransferService.selectAt();
    }
    /**
     * <P>
     *     增加数据
     * </P>
     * @param accountTransfer 查询条件放在对象里
     * @return  账户转账表：增加是否成功
     */
    public int insertAt(AccountTransfer accountTransfer) {
        return accountTransferService.insertAt(accountTransfer);
    }
    /**
     * <P>
     *     修改数据
     * </P>
     * @param accountTransfer 查询条件放在对象里
     * @return  账户转账表：修改是否成功
     */
    public int updateAt(AccountTransfer accountTransfer) {
        return accountTransferService.updateAt(accountTransfer);
    }
    /**
     * <P>
     *     删除数据
     * </P>
     * @param accountTransfer 查询条件放在对象里
     * @return  账户转账表：删除是否成功
     */
    public int deleteAt(AccountTransfer accountTransfer) {
        return accountTransferService.deleteAt(accountTransfer);
    }
}
