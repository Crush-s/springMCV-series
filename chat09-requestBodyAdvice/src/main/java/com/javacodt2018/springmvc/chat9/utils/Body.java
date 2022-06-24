package com.javacodt2018.springmvc.chat9.utils;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
public class Body implements Serializable {

    private String status;
    private String message;
    private List<DataZui> data;

}
