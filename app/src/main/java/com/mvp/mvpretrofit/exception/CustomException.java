package com.mvp.mvpretrofit.exception;

import android.net.ParseException;

import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/**
 * 处理异常，数据异常，解析异常等
 */
public class CustomException {

    /**
     * 未知错误
     */
    public static final int UNKNOWN = 1000;

    /**
     * 解析错误
     */
    public static final int PARSE_ERROR = 1001;

    /**
     * 网络错误
     */
    public static final int NETWORK_ERROR = 1002;

    /**
     * 协议错误
     */
    public static final int HTTP_ERROR = 1003;


    public static ApiException handleException(Throwable e) {
        ApiException apiException;
        if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException) {
            apiException = new ApiException(PARSE_ERROR, e.getMessage());
        } else if (e instanceof ConnectException) {
            apiException = new ApiException(NETWORK_ERROR, e.getMessage());
        } else if (e instanceof UnknownHostException
                || e instanceof SocketTimeoutException) {
            apiException = new ApiException(NETWORK_ERROR, e.getMessage());
        } else {
            apiException = new ApiException(UNKNOWN, e.getMessage());
        }
        return apiException;
    }

}
