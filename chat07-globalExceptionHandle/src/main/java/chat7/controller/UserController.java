package chat7.controller;

import chat7.base.BusException;
import chat7.base.ResultDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/getUserName")
    public ResultDto<String> getUserName(@RequestParam("code") Integer code) {
        System.out.println("123");
        if (!Integer.valueOf(6666).equals(code)) {
            //验证码有误的时候，返回4001错误码
            BusException.throwBusException("4001", "验证码有误!");
        }
        return ResultDto.success("路人");
    }

    @RequestMapping("/getUserId")
    public ResultDto<String> getUserId(@RequestParam("code") Integer code) {
        if (!Integer.valueOf(6666).equals(code)) {
            BusException.throwBusException("4001", "验证码有误!");
        }
        return ResultDto.success("8888");
    }

}
