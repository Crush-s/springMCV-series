package com.javacode2018.springmvc.chat8.config;

import com.javacode2018.springmvc.chat8.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Scanner;


/**
 * @author crush
 */
@Configuration
@ComponentScan("com.javacode2018.springmvc.chat8")
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

    /**
     * 添加视图解析器（可以添加多个）
     *
     * @param registry registry
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/view/");
        resolver.setSuffix(".jsp");
        resolver.setOrder(Ordered.LOWEST_PRECEDENCE);
        registry.viewResolver(resolver);
    }

    @Autowired
    private MyInterceptor myInterceptor;

    /**
     * 添加拦截器（可以添加多个）
     *
     * @param registry registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.myInterceptor).addPathPatterns("/**");
    }

    /**
     * ④：4、配置静态资源访问处理器
     *
     * @param registry registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }

    /**
     * ⑤：5、配置文件上传解析器
     *
     * @return CommonsMultipartResolver
     */
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        //maxUploadSizePerFile:单个文件大小限制（byte）
        //maxUploadSize：整个请求大小限制（byte）
        commonsMultipartResolver.setMaxUploadSizePerFile(10 * 1024 * 1024);
        commonsMultipartResolver.setMaxUploadSize(100 * 1024 * 1024);
        return commonsMultipartResolver;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.print("请输入年份:");
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        boolean year;
        System.out.print("请输入月份:");
        Scanner s1 = new Scanner(System.in);
        int b = s.nextInt();

        int[] arr = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (((a % 4 == 0) & (a % 100 != 0)) | (a % 400 == 0)) {
            year = true;
            System.out.println("闰年");
            arr[2]++;
        } else {
            year = false;
            System.out.println("平年");
        }
        switch (b) {
            case 1:
                ;
                break;
            case 3:
                System.out.println(a + "年的" + b + "月有" + arr[b] + "天");
                ;
                break;
            case 5:
                ;
                break;
            case 7:
                ;
                break;
            case 8:
                ;
                break;
            case 10:
                ;
                break;
            case 12:
                System.out.println(a + "年的" + b + "月有" + arr[b] + "天");
                ;
                break;
            case 4:
                System.out.println(a + "年的" + b + "月有" + arr[b] + "天");
                ;
                break;
            case 6:
                ;
                break;
            case 9:
                ;
                break;
            case 11:
                System.out.println(a + "年的" + b + "月有" + arr[b] + "天");
                ;
                break;
            case 2:
                System.out.println(a + "年的" + b + "月有" + arr[b] + "天");
                ;
                break;
            default:
                System.out.println("月份出错");
        }
    }

}
