package chat7.handle;

import chat7.base.BusException;
import chat7.base.ResultDto;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 统一异常处理类
 *
 * @author crush
 */
@RestControllerAdvice
public class GlobalExceptionHandle {

    /**
     * 处理其他异常
     *
     * @param e 错误
     * @param <T> 错误数据
     * @return 统一返回
     */
    @ExceptionHandler(BusException.class)
    public <T> ResultDto<T> doBusException(BusException e) {
        return ResultDto.error(e.getCode(), e.getMessage(), (T) e.getData());
    }

    /**
     * 处理其他异常
     *
     * @param e 错误
     * @param <T> 错误数据
     * @return 统一返回
     */
    @ExceptionHandler
    public <T> ResultDto<T> doException(Exception e) {
        return ResultDto.error("系统异常，请联系管理员，错误详情：" + e.getMessage());
    }
}
