package com.fjy.gameboxmvp.data.map;

import com.fjy.gameboxmvp.data.pojo.GameInfo;
import com.fjy.gameboxmvp.data.pojo.GameInfos;
import com.fjy.gameboxmvp.data.pojo.GameListBean;
import com.fjy.gameboxmvp.data.pojo.ResultsBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fujianyi on 2017/12/14.
 */

public class HomeMapper {
    public static List<Object> toItems(List<Object> results){
        List<Object> items = new ArrayList<>();
        for (Object result : results) {
            if(result instanceof ResultsBean){
                ResultsBean bean = (ResultsBean) result;
                if (2 == bean.type && bean.obj instanceof GameListBean) {
                    items.add(bean.obj);
                    for (GameInfo gameInfo :((GameListBean) bean.obj).getH5games()) {
                        items.add(gameInfo);
                    }
                }else{
                    items.add(bean.obj);
                }
            }else if(result instanceof GameInfos){
                items.add(result);
            }

        }
        return  items;
    }
}
