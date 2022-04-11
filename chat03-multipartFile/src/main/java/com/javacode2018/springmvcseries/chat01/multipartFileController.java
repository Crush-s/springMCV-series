package com.javacode2018.springmvcseries.chat01;

import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Controller
public class multipartFileController {

    /**
     * 单文件上传
     * 1、MultipartFile用来接收表单中上传的文件
     * 2、每个MultipartFile对应表单中的一个元素
     * 3、@RequestParam("f1")用来自动接受表单中的哪个元素？value用来指定表单元素的名称
     *
     * @param f1
     * @return
     * @throws IOException
     */
    @RequestMapping("/upload1.file")
    public ModelAndView upload1(@RequestParam("file1") MultipartFile f1) throws IOException {
        //获取文件名称
        String originalFilename = f1.getOriginalFilename();
        String destFilePath = String.format("E:\\fct工作文件\\test\\%s", originalFilename);
        File destFile = new File(destFilePath);
        //调用transferTo将上传的文件保存到指定的地址
        f1.transferTo(destFile);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/view/result.jsp");
        modelAndView.addObject("msg", destFile.getAbsolutePath());
        return modelAndView;
    }

    /**
     * 使用MultipartHttpServletRequest处理多文件上传
     * 上传文件的http请求会被转换为MultipartHttpServletRequest类型
     * MultipartHttpServletRequest中提供了很多很多方法用来获取请求中的参数
     *
     * @param request
     * @return
     */
    @RequestMapping("/upload2.file")
    public ModelAndView upload2(MultipartHttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/view/result.jsp");
        modelAndView.addObject("msg", "上传成功");
        return modelAndView;
    }
}
