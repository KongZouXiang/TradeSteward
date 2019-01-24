package com.yunhe.systemsetup.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import com.yunhe.core.redis.RedisService;
import com.yunhe.systemsetup.dao.EmployMapper;
import com.yunhe.systemsetup.entity.Employ;
import com.yunhe.systemsetup.service.IEmployService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 员工管理 服务实现类
 * </p>
 *
 * @author 刘延奇,heyuji
 * @since 2019-01-02
 */
@Service
public class EmployServiceImpl extends ServiceImpl<EmployMapper, Employ> implements IEmployService {
    @Autowired
    private EmployMapper employMapper;
    @Autowired
    private RedisService redisService;
    @Override
    public List<Employ> selectPageEmploy(Page page, Employ employ) {
        return employMapper.selectPageEmploy(page,employ);

    }

    @Override
    public int insertEmploy(Employ employ) {
        int a=employMapper.insertEmploy(employ);
        return a;
    }

    @Override
    public boolean checkname(Employ employ) {
        Boolean b = false;
        String a  =employMapper.checkemname(employ);
        if (a==null){
            b=true;
        }
        return b;
    }

    @Override
    public Employ selectEmployById(int id) {
        return employMapper.selectById(id);
    }

    /**
     * 修改用户密码
     * @param employ
     * @return employMapper.updatePass(employ)
     */
    @Override
    public int updatePassword(Employ employ) {
        return employMapper.updatePass(employ);
    }

    /**
     * 修改账户信息
     * @param employ
     * @return employMapper.updatemess(employ)
     */

    @Override
    public int updateMessage(Employ employ) {

        return employMapper.updatemess(employ);
    }

    /**
     * 发送验证码的随机数
     * @param phone
     */

    @Override
    public void createSmsCod(String phone) {
        //生成6为随机数（验证码）
        String smscode =(long)(Math.random()*1000000)+"";
        System.out.println("验证码:"+smscode);
        //将验证码存入到redis中
        redisService.set(phone,smscode);
        // 短信应用SDK AppID
        int appid = 1400182121; // 1400开头
        // 短信应用SDK AppKey
        String appkey = "6e6e4d71ce749e28816f733f012e48e6";
        // 需要发送短信的手机号码
        String[] phoneNumbers = {phone, "", ""};
        // 短信模板ID，需要在短信应用中申请
        int templateId = 269927; // NOTE: 这里的模板ID`7839`只是一个示例，真实的模板ID需要在短信控制台中申请
        // 签名

        String smsSign = "刘延琦7思妙想屋"; // NOTE: 这里的签名"腾讯云"只是一个示例，真实的签名需要在短信控制台中申请，另外签名参数使用的是`签名内容`，而不是`签名ID`
        try {
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            SmsSingleSenderResult result = ssender.send(0, "86", phoneNumbers[0],
                    smscode+"为你的验证码，请于"+5+"分钟内填写！", "", "");
            System.out.println(result);
        } catch (HTTPException e) {
            // HTTP响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            // json解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络IO错误
            e.printStackTrace();
        }

    }

    public EmployMapper getEmployMapper() {
        return employMapper;
    }

    public void setEmployMapper(EmployMapper employMapper) {
        this.employMapper = employMapper;
    }
}
