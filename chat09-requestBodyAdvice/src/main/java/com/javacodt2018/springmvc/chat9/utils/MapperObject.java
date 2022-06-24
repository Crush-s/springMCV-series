package com.javacodt2018.springmvc.chat9.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.javafx.collections.MappingChange.Map;

public class MapperObject {

    public static final ObjectMapper MAPPER = new ObjectMapper();

    public static final String STRING = "{\"result\":{\"head\":{\"request_date\":\"2022/6/22\",\"request_time\":\"15:10\"},\"body\":{\"status\":\"0\",\"message\":\"查询成功\",\"data\":[{\"hdmc\":\"南京市科利华中学2020级初二年级短剧比赛\",\"zbdw\":\"南京市科利华中学\",\"sjjb\":\"校级\",\"hjdate\":\"2021/10/27 0:00:00\",\"locktime\":\"2021/11/16 13:35:57\",\"lb\":\"个人\",\"zsbh\":\"X210200133071000035\",\"hjmc\":\"一等奖\",\"xm\":\"江润琪\",\"sfz\":\"320************027\",\"school\":\"南京市科利华中学\",\"groupinfo\":null,\"LogInfo\":[],\"pdfurl\":\"\"},{\"hdmc\":\"2021-2022学年第一学期期末检测初二进步之星\",\"zbdw\":\"南京市科利华中学\",\"sjjb\":\"校级\",\"hjdate\":\"2022/1/19 0:00:00\",\"locktime\":\"2022/5/7 10:48:02\",\"LB\":\"个人\",\"zsbh\":\"X220200110070000065\",\"hjmc\":\"初二年级组“进步之星”称号\",\"xm\":\"江润琪\",\"sfz\":\"320************027\",\"school\":\"南京市科利华中学\",\"groupinfo\":null,\"loginfo\":[],\"pdfurl\":\"\"}]},\"jiTi\":[],\"brokenLine\":[{\"2018\":0},{\"2019\":0},{\"2020\":0},{\"2021\":1},{\"2022\":1}],\"PDFURLBASE64\":{}},\"message\":null,\"error\":0,\"success\":true}";

    public static void main(String[] args) {

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        System.out.println(gson.fromJson(STRING, Tuiopip.class));


        /*try {
            //System.out.println(MAPPER.readValue(STRING, Tuiopip.class));
            Map<String, Object> stringObjectMap = MAPPER.readValue(STRING,
                    new TypeReference<Map<String, Object>>() {
                    });
            System.out.println(stringObjectMap);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }*/
    }

}
