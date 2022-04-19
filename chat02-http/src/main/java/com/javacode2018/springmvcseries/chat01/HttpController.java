package com.javacode2018.springmvcseries.chat01;

import com.javacode2018.springmvcseries.dto.UserDto;
import com.javacode2018.springmvcseries.pojo.UserInfoDto;
import com.javacode2018.springmvcseries.pojo.WorkInfoDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class HttpController {

    @RequestMapping("/receiveParam/test1.http")
    public ModelAndView test01(HttpServletRequest request,
                               HttpServletResponse response,
                               HttpSession session) {
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String msg = String.format("name:%s,age:%s", name, age);
        System.out.println(msg);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/view/result.jsp");
        modelAndView.addObject("msg", msg);
        return modelAndView;
    }

    @RequestMapping("/receiveParam/test2.http")
    public ModelAndView test02(String name, Integer age) {
        String msg = String.format("name:%s,age:%s", name, age);
        System.out.println(msg);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/view/result.jsp");
        modelAndView.addObject("msg", msg);
        return modelAndView;
    }

    @RequestMapping("/receiveParam/test3.http")
    public ModelAndView test03(UserInfoDto userInfoDto) {
        String msg = String.format("name:%s,age:%s", userInfoDto.getName(), userInfoDto.getAge());
        System.out.println(msg);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/view/result.jsp");
        modelAndView.addObject("msg", msg);
        return modelAndView;
    }

    @RequestMapping("/receiveParam/test4.http")
    public ModelAndView test04(UserInfoDto userInfoDto, WorkInfoDto workInfoDto) {
        String msg = String.format("name:%s,age:%s,workYears:%s,workAddress:%s",
                userInfoDto.getName(),
                userInfoDto.getAge(),
                workInfoDto.getWorkYears(),
                workInfoDto.getWorkAddress());
        System.out.println(msg);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/view/result.jsp");
        modelAndView.addObject("msg", msg);
        return modelAndView;
    }

    @RequestMapping("/receiveParam/test5.http")
    public ModelAndView test05(UserDto userDto) {
        String msg = String.format("userDto：[%s]", userDto);
        System.out.println(msg);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/view/result.jsp");
        modelAndView.addObject("msg", msg);
        return modelAndView;
    }

}
