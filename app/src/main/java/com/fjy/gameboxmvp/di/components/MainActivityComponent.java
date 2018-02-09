package com.fjy.gameboxmvp.di.components;

import com.fjy.gameboxmvp.di.modules.MainActivityModule;
import com.fjy.gameboxmvp.di.scope.MainActivityScope;
import com.fjy.gameboxmvp.modules.activities.MainActivity;

import dagger.Component;

/**
 * Created by fujianyi on 2017/12/8.
 */
@MainActivityScope
@Component(modules = MainActivityModule.class)
public interface MainActivityComponent {
    void inject(MainActivity mainActivity);
}
