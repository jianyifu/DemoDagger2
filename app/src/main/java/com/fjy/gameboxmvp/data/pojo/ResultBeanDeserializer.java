package com.fjy.gameboxmvp.data.pojo;


import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class ResultBeanDeserializer implements JsonDeserializer<ResultsBean> {
    private static final String TAG = "ResultBeanDeserializer";

    @Override
    public ResultsBean deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        if (json == null || !json.isJsonObject()) {
            return null;
        }
        ResultsBean resultsBean = new ResultsBean();
        try {
            JsonObject resultObj = json.getAsJsonObject();
            int type = resultObj.get("type") == null ? -1 : resultObj.get("type").getAsInt();
            JsonObject obj = resultObj.get("obj") == null ? null : resultObj.get("obj").getAsJsonObject();
            resultsBean.type = type;
            switch (type) {
                case 1:
                    resultsBean.obj = new Gson().fromJson(obj, BigPicBean.class);
                    break;
                case 2:
                    resultsBean.obj = new Gson().fromJson(obj, GameListBean.class);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "deserialize: " + e.getMessage());
        }
        return resultsBean;
    }
}