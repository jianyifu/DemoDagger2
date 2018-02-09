package com.fjy.gameboxmvp.mvp.presenter;

import com.fjy.gameboxmvp.mvp.BasePresenter;
import com.fjy.gameboxmvp.mvp.BaseView;

import java.util.List;

public interface HomeContract {

    interface View extends BaseView<Presenter> {

        void showItems(List<Object> tasks);
        void showLoading();
        void hideLoading();
        void showNoItems();
        void showLoadError();
        void onLogin();
    }

    interface Presenter extends BasePresenter {

        void loadItems(boolean forceUpdate);
    }
}
