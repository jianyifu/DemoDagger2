package com.fjy.gameboxmvp.di.modules;

import com.fjy.gameboxmvp.api.ApiService;
import com.fjy.gameboxmvp.data.pojo.ResultBeanDeserializer;
import com.fjy.gameboxmvp.data.pojo.ResultsBean;
import com.fjy.gameboxmvp.di.scope.ApplicationScope;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by fujianyi on 2017/12/7.
 */
@Module(includes = NetworkModule.class)
public class ApiServiceModule {
    private String baseUrl;

    public ApiServiceModule(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Provides
    @ApplicationScope
    public ApiService getApiService(Retrofit retrofit){
        return retrofit.create(ApiService.class);
    }
    @Provides
    @ApplicationScope
    public Gson getGson(){
        GsonBuilder gsonBuilder = new GsonBuilder()
                .registerTypeAdapter(ResultsBean.class, new ResultBeanDeserializer());
        return gsonBuilder.create();
    }
    @Provides
    @ApplicationScope
    public Retrofit getRetrofit(OkHttpClient okHttpClient,Gson gson){
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
}
