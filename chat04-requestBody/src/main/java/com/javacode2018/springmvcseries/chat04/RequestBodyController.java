package com.javacode2018.springmvcseries.chat04;

import com.javacode2018.springmvcseries.chat04.dto.UserDto;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@RestController
public class RequestBodyController {

    @PostMapping("/add.json")
    public ModelAndView add(@RequestBody UserDto userDto) {
        System.out.println("user:" + userDto);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/view/result.jsp");
        modelAndView.addObject("msg", userDto);
        return modelAndView;
    }

    @PostMapping("/m1.json")
    public ModelAndView m1(@RequestBody String body) {
        System.out.println("user:" + body);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/view/result.jsp");
        modelAndView.addObject("msg", body);
        return modelAndView;
    }

    @PostMapping("/m2.json")
    public ModelAndView m2(@RequestBody byte[] body) {
        System.out.println("user:" + body);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/view/result.jsp");
        modelAndView.addObject("msg", body);
        return modelAndView;
    }

    /**
     * 用户列表(用户id->用户信息)
     */
    Map<Long, UserDto> userDtoMap = new ConcurrentHashMap<>();

    {
        userDtoMap.put(1L, new UserDto("1L", 1, "30"));
        userDtoMap.put(2L, new UserDto("2L", 2, "20"));
        userDtoMap.put(3L, new UserDto("3L",3," 18"));
    }

    @GetMapping("/m3.json")
    @ResponseBody
    public Collection<UserDto> list() {
        return this.userDtoMap.values();
    }

    /**
     * 使用springmvc的异步功能，业务处理放在异步线程中执行
     *
     * @param timeout 异步处理超时时间（毫秒）
     * @return
     */
    @RequestMapping("/async/m4/{timeout}.json")
    public DeferredResult<String> m2(@PathVariable("timeout") long timeout) {
        long st = System.currentTimeMillis();
        System.out.println("主线程：" + Thread.currentThread() + "," + st + ",开始");
        /**
         * 1、创建DeferredResult<返回值类型>(超时时间[毫秒],超时回调的代码)
         */
        DeferredResult<String> result = new DeferredResult<String>(timeout, () -> {
            System.out.println("超时了");
            return "timeout";
        });
        //2、异步处理业务，
        new Thread(() -> {
            //开启一个异步线程，在异步线程中进行业务处理操作
            try {
                TimeUnit.SECONDS.sleep(3);
                //3、调用DeferredResult的setResult方法，设置最终返回到客户端的结果，此方法调用以后，客户端将接收到返回值
                result.setResult("ok");
            } catch (InterruptedException e) {
                result.setResult("发生异常了:" + e.getMessage());
            }
        }).start();
        long et = System.currentTimeMillis();
        System.out.println("主线程：" + Thread.currentThread() + "," + st + ",结束,耗时(ms):" + (et - st));
        //3、将DefaultResult作为方法返回值
        return result;
    }
}
