package com.fjy.gameboxmvp.di.modules;

import com.fjy.gameboxmvp.data.source.HomeSource;
import com.fjy.gameboxmvp.data.source.local.HomeFeedsLocalSource;
import com.fjy.gameboxmvp.data.source.remote.HomeFeedsRemoteSource;
import com.fjy.gameboxmvp.di.qulifiers.HomeFeedsLocal;
import com.fjy.gameboxmvp.di.qulifiers.HomeFeedsRemote;
import com.fjy.gameboxmvp.di.scope.HomeScope;
import com.fjy.gameboxmvp.mvp.presenter.HomeContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by fujianyi on 2017/12/11.
 */
@Module
public class HomeModule {

    private final HomeContract.View homeView;

    public HomeModule(HomeContract.View homeView) {
        this.homeView = homeView;
    }

    @Provides
    @HomeScope
    HomeContract.View mainView(){
        return homeView;
    }

    @Provides
    @HomeScope
    @HomeFeedsRemote
    HomeSource homeFeedsSourceRemote(){
        return  new HomeFeedsRemoteSource();
    }
    @Provides
    @HomeScope
    @HomeFeedsLocal
    HomeSource homeFeedsSourceLocal(){
        return new HomeFeedsLocalSource();
    }


}
