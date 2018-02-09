package com.fjy.gameboxmvp.modules.activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.fjy.gameboxmvp.R;
import com.fjy.gameboxmvp.base.BaseActivity;
import com.fjy.gameboxmvp.di.components.DaggerMainActivityComponent;
import com.fjy.gameboxmvp.di.modules.MainActivityModule;
import com.fjy.gameboxmvp.modules.fragments.CategoryFragment;
import com.fjy.gameboxmvp.modules.fragments.MineFragment;
import com.fjy.gameboxmvp.modules.fragments.WelfareFragment;
import com.fjy.gameboxmvp.modules.home.HomeFragment;
import com.fjy.gameboxmvp.mvp.presenter.MainContract;
import com.fjy.gameboxmvp.mvp.presenter.MainPresenter;
import com.fjy.gameboxmvp.util.ActivityUtils;
import com.fjy.gameboxmvp.views.BottomNavigationViewHelper;

import javax.inject.Inject;

import butterknife.BindView;
import timber.log.Timber;

public class MainActivity extends BaseActivity implements MainContract.View {
    private static final String CURRENT_TAB_INDEX = "current_tab_index";


    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigationView;

    @BindView(R.id.content)
    FrameLayout mContent;

    @Inject
    MainPresenter presenter;

    HomeFragment homeFragment;
    WelfareFragment welfareFragment;
    CategoryFragment categoryFragment;
    MineFragment mineFragment;


    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void resolveDaggerDependency() {
        DaggerMainActivityComponent.builder()
                .mainActivityModule(new MainActivityModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);



        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener((@NonNull MenuItem item)->{
                        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
                        int index = 0;
                        switch (item.getItemId()) {
                            case R.id.action_home:
                                index = 0;
                                break;
                            case R.id.action_walfare:
                                index = 1;
                                break;
                            case R.id.action_category:
                                index = 2;
                                break;
                            case R.id.action_mine:
                                index = 3;
                                break;
                        }
                        presenter.setTab(index);
                        return true;
                    }
                );


        initFragments(savedInstanceState);
        if (savedInstanceState != null) {
            Integer currentTab =
                    (Integer) savedInstanceState.getSerializable(CURRENT_TAB_INDEX);
            presenter.setTab(currentTab);
        } else {
            presenter.setTab(0);
        }
    }

    private void initFragments(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            homeFragment = new HomeFragment();
            welfareFragment = new WelfareFragment();
            categoryFragment = new CategoryFragment();
            mineFragment = new MineFragment();
        } else {
            homeFragment = (HomeFragment) getSupportFragmentManager().findFragmentByTag(HomeFragment.TAG);
            if (homeFragment == null) {
                homeFragment = new HomeFragment();
            }
            welfareFragment = (WelfareFragment) getSupportFragmentManager().findFragmentByTag(WelfareFragment.TAG);
            if (welfareFragment == null) {
                welfareFragment = new WelfareFragment();
            }

            categoryFragment = (CategoryFragment) getSupportFragmentManager().findFragmentByTag(CategoryFragment.TAG);
            if (categoryFragment == null) {
                categoryFragment = new CategoryFragment();
            }
            mineFragment = (MineFragment) getSupportFragmentManager().findFragmentByTag(MineFragment.TAG);
            if (mineFragment == null) {
                mineFragment = new MineFragment();
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putSerializable(CURRENT_TAB_INDEX, presenter.getSelectedTab());
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the main_menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_msg:
                onShowMsgList();
                return true;
            case R.id.action_search:
                onShowSearchPage();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public void onTabSelected(int index) {
        Timber.i("onTabSelected: %d",index);
        if (presenter.getSelectedTab() != index) {
            switch (index) {
                case 0:
                    ActivityUtils.showFragment(getSupportFragmentManager(),homeFragment,R.id.content,homeFragment.TAG);
                    ActivityUtils.hideFragments(getSupportFragmentManager(),welfareFragment,categoryFragment,mineFragment);
                    break;
                case 1:
                    ActivityUtils.showFragment(getSupportFragmentManager(),welfareFragment,R.id.content,welfareFragment.TAG);
                    ActivityUtils.hideFragments(getSupportFragmentManager(),homeFragment,categoryFragment,mineFragment);
                    break;
                case 2:
                    ActivityUtils.showFragment(getSupportFragmentManager(),categoryFragment,R.id.content,categoryFragment.TAG);
                    ActivityUtils.hideFragments(getSupportFragmentManager(),homeFragment,welfareFragment,mineFragment);
                    break;
                case 3:
                    ActivityUtils.showFragment(getSupportFragmentManager(),mineFragment,R.id.content,mineFragment.TAG);
                    ActivityUtils.hideFragments(getSupportFragmentManager(),homeFragment,welfareFragment,categoryFragment);
                    break;
            }

            presenter.setSelectedTab(index);
        }
    }

    @Override
    public void onShowMsgList() {
        Toast.makeText(this, "Msglist has been selected", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onShowSearchPage() {
        Toast.makeText(this, "Search has been selected", Toast.LENGTH_SHORT).show();
    }
}
