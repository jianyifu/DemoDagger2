package com.fjy.gameboxmvp.application;

import android.app.Application;

import com.fjy.gameboxmvp.di.components.ApplicationComponent;
import com.fjy.gameboxmvp.di.components.DaggerApplicationComponent;
import com.fjy.gameboxmvp.di.modules.ApiServiceModule;
import com.fjy.gameboxmvp.di.modules.ContextModule;

import timber.log.Timber;

/**
 * Created by fujianyi on 2017/12/7.
 */

public class GameBoxMVPApplication extends Application {

    private static final String BASE_URL = "http://yx.sogou.com";
    private static  GameBoxMVPApplication application;
    private ApplicationComponent component;
    @Override
    public void onCreate() {
        super.onCreate();

        application = this;

        Timber.plant(new Timber.DebugTree());

        component = DaggerApplicationComponent.builder()
                .apiServiceModule(new ApiServiceModule(BASE_URL))
                .contextModule(new ContextModule(this))
                .build();

    }

    public static  GameBoxMVPApplication instance() {
        return application;
    }

    public  ApplicationComponent component(){
        return component;
    }

}
