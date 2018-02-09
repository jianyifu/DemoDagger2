package com.fjy.gameboxmvp.data.source;

import java.util.List;

import io.reactivex.Maybe;

/**
 * Created by fujianyi on 2017/12/11.
 */

public interface HomeSource {
    Maybe<List<Object>> getItems();
    void saveItems(List<Object> items);
    void deteleItems();
    void refreshItems();
}
