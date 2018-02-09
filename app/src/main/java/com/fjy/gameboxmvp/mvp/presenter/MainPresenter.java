package com.fjy.gameboxmvp.mvp.presenter;

import com.fjy.gameboxmvp.di.scope.MainActivityScope;

import javax.inject.Inject;

/**
 * Created by fujianyi on 2017/12/8.
 */
@MainActivityScope
public class MainPresenter implements MainContract.Presenter {
    //Need to maintain a index selected
    private int selectedTab = -1;

    @Inject MainContract.View mainView;

    @Inject
    public MainPresenter() {
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void setTab(int index) {
        mainView.onTabSelected(index);
    }

    public void setSelectedTab(int selectedTab) {
        this.selectedTab = selectedTab;
    }

    public int getSelectedTab() {
        return selectedTab;
    }
}
