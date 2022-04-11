package com.javacode2018.springmvcseries.chat04.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    //姓名
    private String name;
    //年龄
    private Integer age;
    //地址
    private String address;
}
