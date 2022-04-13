package com.javacode2018.springmvcseries.chat06.controller;

import com.javacode2018.springmvcseries.chat06.exception.NameException;
import com.javacode2018.springmvcseries.chat06.exception.PassException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @GetMapping("/login")
    public ModelAndView login(@RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "pass", required = false) Integer pass) throws Exception {

        if ("路人".equals(name)) {
            throw new NameException("用户名有误");
        }

        if (Integer.valueOf(666).equals(pass)) {
            throw new PassException("密码有误");
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", name);
        modelAndView.setViewName("success");
        return modelAndView;
    }
}
