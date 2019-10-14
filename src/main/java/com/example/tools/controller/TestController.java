/**
 * 测试用的controller
 */
package com.example.tools.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    @ResponseBody
    public String test1(String name) {
        return "test1";
    }

    @RequestMapping(value = "/homepage", method = RequestMethod.GET)
    public String toHomepage() {
        return "hello";
    }
}
