package chat7.base;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

/**
 * 统一返回数据
 *
 * @param <T>
 * @author crush
 */
@Data
public class ResultDto<T> {

    /**
     * 接口状态（成功还是失败）
     */
    private Boolean success;
    /**
     * 错误码
     */
    private String code;
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 数据
     */
    private T data;

    public static <T> ResultDto<T> success(T data) {
        return success(data, "操作成功!");
    }

    public static <T> ResultDto<T> success(T data, String msg) {
        ResultDto<T> tResultDto = new ResultDto<>();
        tResultDto.setSuccess(Boolean.TRUE);
        tResultDto.setMsg(msg);
        tResultDto.setData(data);
        return tResultDto;
    }

    public static <T> ResultDto<T> error(String msg) {
        return error(null, msg);
    }

    public static <T> ResultDto<T> error(String code, String msg) {
        return error(code, msg, null);
    }

    public static <T> ResultDto<T> error(String code, String msg, T data) {
        ResultDto<T> tResultDto = new ResultDto<>();
        tResultDto.setSuccess(Boolean.FALSE);
        tResultDto.setCode(code);
        tResultDto.setMsg(msg);
        tResultDto.setData(data);
        return tResultDto;
    }

    public static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T objParse(Class<T> returnClass, Object value) {
        try {
            if (value.getClass().equals(returnClass)) {
                return objectMapper.convertValue(value, returnClass);
            }
        } catch (Exception ignored) {
            BusException.throwBusException("类型错误");
        }
        return null;
    }
}
