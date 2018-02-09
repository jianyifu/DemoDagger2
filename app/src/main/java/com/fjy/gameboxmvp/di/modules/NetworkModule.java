package com.fjy.gameboxmvp.di.modules;

import android.content.Context;

import com.fjy.gameboxmvp.di.qulifiers.ApplicationContext;
import com.fjy.gameboxmvp.di.scope.ApplicationScope;

import java.io.File;
import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

/**
 * Created by fujianyi on 2017/12/7.
 */
@Module(includes = ContextModule.class)
public class NetworkModule {
    @Provides
    @ApplicationScope
    public HttpLoggingInterceptor getHttpLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Timber.i(message);
            }
        });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        return httpLoggingInterceptor;

    }

    @Provides
    @ApplicationScope
    public File cacheFile(@ApplicationContext Context context){
        return  new File(context.getCacheDir(), "okhttp_cache");
    }
    @Provides
    @ApplicationScope
    public Cache getCache(File cacheFile) {
        return new Cache(cacheFile, 10 * 1000 * 1000);//10MB size
    }

    @Provides
    @ApplicationScope
    public OkHttpClient getOkhttpClient(HttpLoggingInterceptor httpLoggingInterceptor,Cache cache) {
        return new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .cache(cache)
                .build();
    }
}
