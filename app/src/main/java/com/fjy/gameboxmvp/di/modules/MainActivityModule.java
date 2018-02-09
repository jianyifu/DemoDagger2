package com.fjy.gameboxmvp.di.modules;

import com.fjy.gameboxmvp.di.scope.MainActivityScope;
import com.fjy.gameboxmvp.mvp.presenter.MainContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by fujianyi on 2017/12/8.
 */
@Module
public class MainActivityModule {
    private final MainContract.View mainView;

    public MainActivityModule(MainContract.View mainView) {
        this.mainView = mainView;
    }

    @Provides
    @MainActivityScope
    MainContract.View mainView(){
        return mainView;
    }
}
