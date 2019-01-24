package com.yunhe.systemsetup;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class systemsetup {

    @Test
    public void contextLoads() {
        System.out.println("1");
    }
    @Test
    public void smsSend(){
        // 短信应用SDK AppID
        int appid = 1400182121; // 1400开头
        // 短信应用SDK AppKey
        String appkey = "6e6e4d71ce749e28816f733f012e48e6";
        // 需要发送短信的手机号码
        String[] phoneNumbers = {"18236256555", "", ""};
        // 短信模板ID，需要在短信应用中申请
        int templateId = 269927; // NOTE: 这里的模板ID`7839`只是一个示例，真实的模板ID需要在短信控制台中申请
        // 签名
        String random ="5685";
        String smsSign = "刘延琦7思妙想屋"; // NOTE: 这里的签名"腾讯云"只是一个示例，真实的签名需要在短信控制台中申请，另外签名参数使用的是`签名内容`，而不是`签名ID`
        try {
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            SmsSingleSenderResult result = ssender.send(0, "86", phoneNumbers[0],
                    random+"为你的验证码，请于"+5+"分钟内填写！", "", "");
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


}

