package com.fjy.gameboxmvp.data.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by fujianyi on 2017/12/19.
 */

public class GameInfos implements Serializable {

    private int count;
    private List<GameInfo> datas;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<GameInfo> getDatas() {
        return datas;
    }

    public void setDatas(List<GameInfo> datas) {
        this.datas = datas;
    }

}
