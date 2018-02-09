package com.fjy.gameboxmvp.api;

import com.fjy.gameboxmvp.data.pojo.DataInfo;
import com.fjy.gameboxmvp.data.pojo.GameInfos;
import com.fjy.gameboxmvp.data.pojo.ResultsBean;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * Created by fujianyi on 2017/12/7.
 */

public interface ApiService {
    @GET("h5game/index/mixlist")
    Flowable<DataInfo<List<ResultsBean>>> homeFeeds();
//?app_channel=1000&&push_id=0e47900897c7481e2ec077612a0e1471&system=android&appid=60fa5580-06ca-4f5c-8d5c-0fa41a9d0c7e&phone_version=23&versionNum=213&gouzai_id=G-54e0a4f6ffd6caeac01087c88eb3bfdd&product_type=SM-G9006W&openid=&pno=1&net_stat=1&psize=20&gouzaiId=G-54e0a4f6ffd6caeac01087c88eb3bfdd&version=2.1.3-debug&manufacturer=samsung&channel=1000
    @GET("h5game/user/history/list")
    Flowable<DataInfo<GameInfos>> playHistory();
}
