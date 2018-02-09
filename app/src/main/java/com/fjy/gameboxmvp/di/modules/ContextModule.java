package com.fjy.gameboxmvp.di.modules;

import android.content.Context;

import com.fjy.gameboxmvp.di.qulifiers.ApplicationContext;
import com.fjy.gameboxmvp.di.scope.ApplicationScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by fujianyi on 2017/12/7.
 */
@Module
public class ContextModule {

    private final Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @ApplicationScope
    @ApplicationContext
    public Context context() {
        return context;
    }
}
