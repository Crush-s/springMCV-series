package com.javacode2018.springmvc;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

public class ExecutorsTest {

    static ThreadPoolExecutor executorService = new ThreadPoolExecutor(5, 5, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));

    @Test
    public void executorTest() throws InterruptedException {

        //用来监控线程池的执行状态，注意初始化用ThreadPoolExecutor，非executorService

        Thread t = new Thread(() -> {
            while (true) {
                try {
                    System.out.println(executorService);
                    TimeUnit.SECONDS.sleep(3);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();

        //记录执行时间
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            int x = i;
            CompletableFuture.runAsync(() -> {
                try {
                    System.out.println("running..." + x);
                    if (x == 7) {
                        TimeUnit.SECONDS.sleep(20);
                    } else {
                        TimeUnit.SECONDS.sleep(5);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, executorService).toCompletableFuture().whenComplete((aVoid, throwable) -> {
                //每个任务执行完成的需要的时间
                System.out.println(System.currentTimeMillis() - start);
            });
        }

        //执行shutdown
        if (!executorService.isShutdown()) {
            executorService.shutdown();
            System.out.println("start shutdown ...");
            //等待执行结束
            executorService.awaitTermination(2, TimeUnit.MINUTES);
        }
    }

    @Test
    public void test3() throws Exception {
        // 创建异步执行任务:
        ExecutorService executorService= Executors.newSingleThreadExecutor();
        Future<Double> cf = executorService.submit(()->{
            System.out.println(Thread.currentThread()+" start,time->"+System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            if(false){
                throw new RuntimeException("test");
            }else{
                System.out.println(Thread.currentThread()+" exit,time->"+System.currentTimeMillis());
                return 1.2;
            }
        });
        System.out.println("main thread start,time->"+System.currentTimeMillis());
        //等待子任务执行完成,如果已完成则直接返回结果
        //如果执行任务异常，则get方法会把之前捕获的异常重新抛出
        System.out.println("run result->"+cf.get());
        System.out.println("main thread exit,time->"+System.currentTimeMillis());
    }
}
