package com.fjy.gameboxmvp.data.pojo;

import com.google.gson.Gson;

import java.io.Serializable;

public class DataInfo<T> implements Serializable {


    /**
     * code : 10000
     * message : success
     * datas :
     */

    private int code;
    private String message;
    private String serverTime;
    private T datas;

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

    public T getDatas() {
        return datas;
    }

    public void setDatas(T datas) {
        this.datas = datas;
    }


    public String getServerTime() {
        return serverTime;
    }

    public void setServerTime(String serverTime) {
        this.serverTime = serverTime;
    }


    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
