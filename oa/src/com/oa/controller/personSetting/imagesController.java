package com.oa.controller.personSetting;




import org.springframework.web.bind.annotation.RequestMapping;

import com.oa.utils.ValidateCodeUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@org.springframework.stereotype.Controller
public class imagesController{
    

    //    获取验证码
    @RequestMapping("/getVerify")
    public void getVerify(HttpServletRequest request, HttpServletResponse response) {
        try {
            //设置相应类型,告诉浏览器输出的内容为图片
            response.setContentType("image/jpeg");
            //设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            response.setCharacterEncoding("UTF-8");
            request.setCharacterEncoding("UTF-8");
            ValidateCodeUtil randomValidateCode = new ValidateCodeUtil();
            //输出验证码图片方法
            randomValidateCode.getRandcode(request, response);
        } catch (Exception e) {
            e.toString();
        }
    }
}
