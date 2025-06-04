package com.ww.config.http;

public class ResponseMessage<T> {
    private boolean successState;
    private int code;
    private String message;
    private T data;

    public ResponseMessage(boolean successState, int code, String message, T data) {
        this.successState = successState;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccessState() {
        return successState;
    }

    public void setSuccessState(boolean successState) {
        this.successState = successState;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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

    public static <T> ResponseMessage<T> success(T data) {
        return new ResponseMessage<T>(true, 200, "OK", data);
    }

    public static <T> ResponseMessage<T> created(T data) {
        return new ResponseMessage<T>(true, 201, "created", data);
    }

    public static <T> ResponseMessage<T> error(int code, String message) {
        return new ResponseMessage<T>(false, code, message, null);
    }

    public static <T> ResponseMessage<T> error(int code, String message, T data) {
        return new ResponseMessage<T>(false, code, message, data);
    }

}
