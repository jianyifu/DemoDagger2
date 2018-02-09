package com.fjy.gameboxmvp.data.source;

import com.fjy.gameboxmvp.di.qulifiers.HomeFeedsLocal;
import com.fjy.gameboxmvp.di.qulifiers.HomeFeedsRemote;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Maybe;

/**
 * Created by fujianyi on 2017/12/11.
 */

public class HomeRepo implements HomeSource {


    private final HomeSource mHomeFeedsRemoteSource;
    private final HomeSource mHomeFeedsLocalSource;

    @Inject
    public HomeRepo(@HomeFeedsRemote HomeSource homeFeedsRemoteSource, @HomeFeedsLocal HomeSource homeFeedsLocalSource) {
        this.mHomeFeedsRemoteSource = homeFeedsRemoteSource;
        this.mHomeFeedsLocalSource = homeFeedsLocalSource;
    }

    @Override
    public Maybe<List<Object>> getItems() {
        //TODO use remote data
        return mHomeFeedsRemoteSource.getItems();
    }

    @Override
    public void saveItems(List<Object> items) {

    }

    @Override
    public void deteleItems() {

    }

    @Override
    public void refreshItems() {

    }
}
