package com.javacode2018.springmvc.chat8.controller;

import com.javacode2018.springmvc.chat8.interceptor.TestDouble;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
    public TestDouble testError() {
        TestDouble testDouble = new TestDouble();
        testDouble.setName("123");
        testDouble.setADouble(null);
        return testDouble;
    }

}
