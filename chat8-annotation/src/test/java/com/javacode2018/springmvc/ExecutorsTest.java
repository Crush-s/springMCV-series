package com.javacode2018.springmvc;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorsTest {

    @Test
    public void test3() throws Exception {

        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("123", "123");
        System.out.println(stringStringHashMap.getOrDefault("456", "456"));

        // 创建异步执行任务:
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<Double> cf = executorService.submit(() -> {
            System.out.println(Thread.currentThread() + " start,time->" + System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            if (false) {
                throw new RuntimeException("test");
            } else {
                System.out.println(Thread.currentThread() + " exit,time->" + System.currentTimeMillis());
                return 1.2;
            }
        });

        System.out.println("main thread start,time->" + System.currentTimeMillis());
        //等待子任务执行完成,如果已完成则直接返回结果
        //如果执行任务异常，则get方法会把之前捕获的异常重新抛出
        System.out.println("run result->" + cf.get());
        System.out.println("main thread exit,time->" + System.currentTimeMillis());
    }

    @Test
    public void binaryTest1() {
        float a = 1f;
        float b = 0.1f;
        float f = a = b;
        System.out.println(f);
    }
}
