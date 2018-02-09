package com.fjy.gameboxmvp.data.source.remote;

import com.fjy.gameboxmvp.application.GameBoxMVPApplication;
import com.fjy.gameboxmvp.data.pojo.BigPicBean;
import com.fjy.gameboxmvp.data.pojo.GameInfos;
import com.fjy.gameboxmvp.data.pojo.GameListBean;
import com.fjy.gameboxmvp.data.pojo.ResultsBean;
import com.fjy.gameboxmvp.data.source.HomeSource;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;

/**
 * Created by fujianyi on 2017/12/11.
 */

public class HomeFeedsRemoteSource implements HomeSource {

    @Override
    public Maybe<List<Object>> getItems() {
        Maybe<List<ResultsBean>> homeFeedsFlowable = GameBoxMVPApplication.instance().component().getApiService().homeFeeds()
                .filter(listDataInfo -> listDataInfo.getCode() == 10000 && listDataInfo.getDatas() != null)
                .flatMap(listDataInfo -> Flowable.just(listDataInfo.getDatas()))
                .filter(resultsBeans -> resultsBeans.size() > 0)
                .flatMap(Flowable::fromIterable)
                .filter(resultsBean -> {
                    if (resultsBean.obj != null && resultsBean.obj.isValid()) {
                        if ((1 == resultsBean.type && resultsBean.obj instanceof BigPicBean) ||
                                (2 == resultsBean.type && resultsBean.obj instanceof GameListBean)) {
                            return true;
                        }
                    }
                    return false;
                })
                .toList().
                        toMaybe();
        Maybe<GameInfos> playHistoryFlowable = GameBoxMVPApplication.instance().component().getApiService().playHistory()
                .filter(dataInfo -> dataInfo.getCode() == 10000 && dataInfo.getDatas() != null)
                .map(dataInfo -> dataInfo.getDatas())
                .filter(gameInfos -> gameInfos.getCount() > 0 && gameInfos.getDatas() != null && gameInfos.getDatas().size() > 0)
                .firstElement();
        Maybe<List<Object>> resultsFlowable = homeFeedsFlowable.zipWith(playHistoryFlowable, ((resultsBeans, gameInfos) -> {
            List<Object> list = new ArrayList<>();
            if(gameInfos!=null){
                list.add(gameInfos);
            }
            if(resultsBeans!=null&&resultsBeans.size()>0){
                list.addAll(resultsBeans);
            }
            return list;
        }));
        return resultsFlowable;
    }

    @Override
    public void saveItems(List<Object> items) {

    }

    @Override
    public void deteleItems() {

    }

    @Override
    public void refreshItems() {

    }
}
