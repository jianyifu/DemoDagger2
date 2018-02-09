package com.fjy.gameboxmvp.data.pojo;

import com.google.gson.Gson;

import java.io.Serializable;

public class ResultsBean implements Serializable {
    public ObjBean obj;
    public int type;
    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}