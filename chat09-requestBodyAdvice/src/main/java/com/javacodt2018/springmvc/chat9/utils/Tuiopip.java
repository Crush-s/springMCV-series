package com.javacodt2018.springmvc.chat9.utils;

import java.io.Serializable;
import lombok.Data;

@Data
public class Tuiopip implements Serializable {

    private Resout result;

    private String message;

    @Override
    public String toString() {
        return "Tuiopip{" +
                "result=" + result +
                ", message='" + message + '\'' +
                '}';
    }
}
