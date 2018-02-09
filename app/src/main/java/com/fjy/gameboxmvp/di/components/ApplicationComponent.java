package com.fjy.gameboxmvp.di.components;

import com.fjy.gameboxmvp.api.ApiService;
import com.fjy.gameboxmvp.di.modules.ApiServiceModule;
import com.fjy.gameboxmvp.di.scope.ApplicationScope;

import dagger.Component;

/**
 * Created by fujianyi on 2017/12/7.
 */
@ApplicationScope
@Component(modules = {ApiServiceModule.class,})
public interface ApplicationComponent {
    ApiService getApiService();
}
