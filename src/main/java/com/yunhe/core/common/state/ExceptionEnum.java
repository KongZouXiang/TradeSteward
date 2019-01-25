package com.yunhe.core.common.state;

/**
 * <p>
 * 异常信息使用枚举进行管理
 * </P>
 *
 * @author 孔邹祥
 * @date 2019年1月17日
 */
public enum ExceptionEnum {

    /**
     * 成功
     */
    SUCCESS(0, "success"),

    /**
     * 未知异常
     */
    UNKNOW_ERROR(-1, "未知错误"),

    /**
     * 业务异常
     */
    SERVICE_ERROR(100, "业务出现了异常"),

    /**
     * 自己抛出的异常
     */
    SELF_ERROR(103, "自己抛出的异常"),

    /**
     * 日志异常
     */
    LOG_ERROR(500, "日志出现了异常!"),

    /**
     * 未登录账号
     */
    ACCOUNT_UNKNOWN(500, "未登录账号!"),

    /**
     * 没有找到变量
     */
    THFIELD_UNKNOWN(500, "没有找到变量!"),

    /**
     * Request请求异常
     */
    REQUEST_ERROR(500,"请求异常!"),
    ;



    /**
     * 显示错误码
     */
    private Integer code;

    /**
     * 显示错误信息
     */
    private String msg;

    ExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
