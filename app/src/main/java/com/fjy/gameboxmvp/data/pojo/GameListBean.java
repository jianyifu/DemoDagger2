package com.fjy.gameboxmvp.data.pojo;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.List;

public class GameListBean extends ObjBean implements Serializable {

    private String icon;
    private String title;
    private String type;
    private int subType;
    private List<GameInfo> h5games;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSubType() {
        return subType;
    }

    public void setSubType(int subType) {
        this.subType = subType;
    }

    public List<GameInfo> getH5games() {
        return h5games;
    }

    public void setH5games(List<GameInfo> h5games) {
        this.h5games = h5games;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    @Override
    public boolean isValid() {
        if (h5games != null && h5games.size() > 0) {
            return true;
        }
        return false;
    }
}