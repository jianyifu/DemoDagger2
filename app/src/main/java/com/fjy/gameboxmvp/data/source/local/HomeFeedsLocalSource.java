package com.fjy.gameboxmvp.data.source.local;

import com.fjy.gameboxmvp.data.source.HomeSource;

import java.util.List;

import io.reactivex.Maybe;

/**
 * Created by fujianyi on 2017/12/11.
 */

public class HomeFeedsLocalSource implements HomeSource {
    @Override
    public Maybe<List<Object>> getItems() {
        return null;
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
