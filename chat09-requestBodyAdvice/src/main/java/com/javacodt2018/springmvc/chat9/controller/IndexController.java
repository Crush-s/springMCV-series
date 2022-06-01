package com.javacodt2018.springmvc.chat9.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author crush https://blog.csdn.net/HLH_2021/article/details/122785888
 */
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

    @RequestMapping("/user/add")
    public User add(@RequestBody User user) {
        System.out.println("user:" + user);
        return user;
    }

    @RequestMapping("/user/adds")
    public List<User> adds(@RequestBody List<User> userList) {
        System.out.println("userList:" + userList);
        return userList;
    }

    public static class User {

        private String name;
        private Integer age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

}
