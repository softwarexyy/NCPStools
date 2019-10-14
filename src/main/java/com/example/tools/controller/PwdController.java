/**
 * 处理密码相关请求
 */
package com.example.tools.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.tools.action.PasswordAction;
import com.example.tools.action.UserinfoAction;
import com.example.tools.model.ReturnInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 接收前端请求
 */
@Controller
public class PwdController {

    private static final Logger LOG = LoggerFactory.getLogger(PwdController.class);

    @RequestMapping("/hello")
    @ResponseBody   //ResponseBody注解会返回一个字符串，而不是页面jsp文件名
    public String hello() {
        return "NCPS内管助手！";
    }

    /**
     * 重置密码
     *
     * @param paramData
     * @return
     */
    @RequestMapping(value = "/resetPwd", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo resetPwd(@RequestBody String paramData) {
        LOG.info("resetPwd,request:" + paramData);
        JSONObject jo = JSON.parseObject(paramData);    // 解析成json对象
        String phone = jo.getString("phone");
        String pwdTyp = jo.getString("pwdTyp");
        String usrId = UserinfoAction.getUsridByPhone(phone);   // 根据手机号查找客户
        if (usrId.equals("")) {
            return new ReturnInfo("EUSR000001", "用户不存在");
        }
        int num = PasswordAction.resetPwd(usrId, pwdTyp);    // 重置usrId对应的登录密码
//        if (num == 0) {
//            return new ReturnInfo("ECRT000001", "重置密码失败");
//        }
        ReturnInfo ri = new ReturnInfo("000000", "密码已重置");
        return ri;
    }

    /**
     * 重置密码状态
     *
     * @param paramData
     * @return
     */
    @RequestMapping(value = "/resetPwdStat", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo resetPwdStat(@RequestBody String paramData) {
        LOG.info("resetPwdStat, request:" + paramData);
        JSONObject jo = JSON.parseObject(paramData);    // 解析成json对象
        String phone = jo.getString("phone");
        String pwdTyp = jo.getString("pwdTyp");
        String usrId = UserinfoAction.getUsridByPhone(phone);   // 根据手机号查找客户
        if (usrId.equals("")) {
            return new ReturnInfo("EUSR000001", "用户不存在");
        }
        int num = PasswordAction.resetPwdStat(usrId, pwdTyp);    // 重置usrId对应的登录密码状态
//        if (num == 0) {
//            return new ReturnInfo("ECRT000002", "重置密码状态失败");
//        }
        ReturnInfo ri = new ReturnInfo("000000", "用户已解冻");
        return ri;
    }

}