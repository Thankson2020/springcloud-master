package com.thankson.common.utils.response;

/**
 * 返回结果实体类
 *
 * @author Thankson
 * @date 2020年2月19日
 */
public class Result<T> {
    /**
     * 是否成功
     */
    private boolean flag=true;
    /**
     * 返回码
     */
    private Integer code=200;
    /**
     * 返回消息
     */
    private String message="success";
    /**
     * 返回数据
     */
    private T data;
    public Result() {
    }

    public Result(boolean flag, String message) {
        this.flag = flag;
        this.message = message;
    }
    public Result(boolean flag, Integer code,String message) {
        this.flag = flag;
        this.code=code;
        this.message = message;
    }
    public Result(boolean flag, String message,T data) {
        this.flag = flag;
        this.message=message;
        this.data = data;
    }

    public Result(boolean flag, Integer code, String message, Object data) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = (T)data;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}