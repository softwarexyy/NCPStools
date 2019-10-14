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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 接收前端请求
 */
@Controller
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(PwdController.class);

    /**
     * 解绑设备
     *
     * @param paramData
     * @return
     */
    @RequestMapping(value = "/unbindDevice", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo unbindDevice(@RequestBody String paramData) {
        LOG.info("unbindDevice, request:" + paramData);
        JSONObject jo = JSON.parseObject(paramData);    // 解析成json对象
        String phone = jo.getString("phone");
        String pwdTyp = jo.getString("pwdTyp");
        String usrId = UserinfoAction.getUsridByPhone(phone);   // 根据手机号查找客户
        if (usrId.equals("")) {
            return new ReturnInfo("EUSR000001", "用户不存在");
        }
        int num = UserinfoAction.unbindDevice(usrId);
        ReturnInfo ri = new ReturnInfo("000000", "解绑成功");
        return ri;
    }

}