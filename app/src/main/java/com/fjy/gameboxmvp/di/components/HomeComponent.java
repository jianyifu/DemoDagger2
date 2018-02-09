package com.fjy.gameboxmvp.di.components;

import com.fjy.gameboxmvp.di.modules.HomeModule;
import com.fjy.gameboxmvp.di.scope.HomeScope;
import com.fjy.gameboxmvp.modules.home.HomeFragment;

import dagger.Component;

/**
 * Created by fujianyi on 2017/12/11.
 */
@HomeScope
@Component(modules = HomeModule.class,dependencies = ApplicationComponent.class)
public interface HomeComponent {
    void inject(HomeFragment homeFragment);
}
