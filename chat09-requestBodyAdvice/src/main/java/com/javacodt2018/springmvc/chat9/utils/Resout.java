package com.javacodt2018.springmvc.chat9.utils;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import lombok.Data;

@Data
public class Resout implements Serializable {

    private Map<String, String> head;
    private Body body;
    private List<Object> jiTi;

}
