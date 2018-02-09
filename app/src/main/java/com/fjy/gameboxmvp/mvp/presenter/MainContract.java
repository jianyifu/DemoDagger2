package com.fjy.gameboxmvp.mvp.presenter;

import com.fjy.gameboxmvp.mvp.BasePresenter;
import com.fjy.gameboxmvp.mvp.BaseView;

public interface MainContract {

    interface View extends BaseView<Presenter> {



        void onTabSelected(int index);

        void onShowMsgList();

        void onShowSearchPage();
    }

    interface Presenter extends BasePresenter {

        void setTab(int index);
    }
}
