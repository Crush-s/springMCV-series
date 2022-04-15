package com.javacode2018.springmvc.chat8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    /**
     * 首页
     *
     * @return 首页
     */
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    /**
     * 测试异常情况
     *
     * @return 信息
     */
    @RequestMapping("/testError")
    public String testError() {
        System.out.println(10 / 0);
        return "success";
    }
}
