package com.nectar.myblog.controller.register;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.nectar.myblog.Component.PhoneRandomBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 注册获得验证码
 */
@Controller
public class GetPhoneCodeControl {
    @PostMapping("/getCode")
    @ResponseBody
    public int getAuthCode(HttpServletRequest request){
        String phone = request.getParameter("phone");
        String sign = request.getParameter("sign");
        String trueMsgCode = PhoneRandomBuilder.randomBuilder();

        request.getSession().setAttribute("trueMsgCode", trueMsgCode);
        System.out.println("msgCode is " + trueMsgCode);

        String msgCode = "SMS_145290261";

        //注册
        if("register".equals(sign)){
            msgCode = "SMS_145290261";
        }
        //改密码
        else {
            msgCode = "SMS_145290261";
        }

        SendSmsResponse sendSmsResponse = null;
        try {
            sendSmsResponse = sendSmsResponse(phone, trueMsgCode, msgCode);
        } catch (ClientException e) {
            e.printStackTrace();
            return 0;
        }

        return 1;
    }
    public static SendSmsResponse sendSmsResponse(String phoneNumber, String code, String msgCode) throws ClientException {

        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        //"***"分别填写自己的AccessKey ID和Secret
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAIE582eWn5Vonv", "WYjHfWIzEmSBnpM1TJCdApBAoBOIij");
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", "Dysmsapi", "dysmsapi.aliyuncs.com");
        IAcsClient acsClient = new DefaultAcsClient(profile);
        SendSmsRequest request = new SendSmsRequest();
        //填写接收方的手机号码
        request.setPhoneNumbers(phoneNumber);
        //此处填写已申请的短信签名
        request.setSignName("夜深人静的风");
        //此处填写获得的短信模版CODE
        request.setTemplateCode(msgCode);
        //短信模版中有${code}, 因此此处对应填写验证码
        request.setTemplateParam("{\"code\":\"" + code + "\"}");
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);

        return sendSmsResponse;
    }
}
