package com.fjy.gameboxmvp.modules.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.fjy.gameboxmvp.R;
import com.fjy.gameboxmvp.application.GameBoxMVPApplication;
import com.fjy.gameboxmvp.base.BaseFragment;
import com.fjy.gameboxmvp.data.map.HomeMapper;
import com.fjy.gameboxmvp.data.pojo.BigPicBean;
import com.fjy.gameboxmvp.data.pojo.GameInfo;
import com.fjy.gameboxmvp.data.pojo.GameInfos;
import com.fjy.gameboxmvp.data.pojo.GameListBean;
import com.fjy.gameboxmvp.di.components.DaggerHomeComponent;
import com.fjy.gameboxmvp.di.modules.HomeModule;
import com.fjy.gameboxmvp.modules.home.viewbinder.BicPicViewBinder;
import com.fjy.gameboxmvp.modules.home.viewbinder.CateGameTitleViewBinder;
import com.fjy.gameboxmvp.modules.home.viewbinder.CateGameViewBinder;
import com.fjy.gameboxmvp.modules.home.viewbinder.HomeHistoryViewBinder;
import com.fjy.gameboxmvp.mvp.presenter.HomeContract;
import com.fjy.gameboxmvp.mvp.presenter.HomePresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment implements HomeContract.View{

    public static final String TAG = HomeFragment.class.getSimpleName();

    @Inject
    HomePresenter presenter;
    @BindView(R.id.my_toolbar)
    Toolbar myToolbar;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private MultiTypeAdapter multiTypeAdapter;
    private Items items = new Items();
    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState) {
        super.onViewReady(savedInstanceState);
        setUpToolBar();
        setUpRecyclerView();
        presenter.subscribe();
    }

    private void setUpToolBar() {
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(myToolbar);

//        //use an icon instead of title
//        //1.remove the title
        activity.getSupportActionBar().setDisplayShowTitleEnabled(false);
//        //2.set the logo drawable
//        myToolbar.setLogo(R.mipmap.avatar_white);
        myToolbar.setNavigationIcon(R.mipmap.avatar_white);

        myToolbar.setNavigationOnClickListener((View v)-> onLogin());
    }

    private void setUpRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(),LinearLayoutManager.VERTICAL,false));
        multiTypeAdapter = new MultiTypeAdapter();
        multiTypeAdapter.register(GameInfos.class, new HomeHistoryViewBinder());
        multiTypeAdapter.register(BigPicBean.class, new BicPicViewBinder());
        multiTypeAdapter.register(GameListBean.class, new CateGameTitleViewBinder());
        multiTypeAdapter.register(GameInfo.class, new CateGameViewBinder());
        recyclerView.setAdapter(multiTypeAdapter);
    }

    @Override
    public void onLogin() {
        Toast.makeText(getContext(), "Avatar has been clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.unsubscribe();
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    protected void resolveDaggerDependency() {
        DaggerHomeComponent.builder()
                .applicationComponent(GameBoxMVPApplication.instance().component())
                .homeModule(new HomeModule(this))
                .build().inject(this);
    }

    @Override
    protected int getContentView() {
        return R.layout.fragment_home;
    }

    @Override
    public void showItems(List<Object> beans) {
        items.clear();
        items.addAll(HomeMapper.toItems(beans));
        multiTypeAdapter.setItems(items);
        multiTypeAdapter.notifyDataSetChanged();
    }

    @Override
    public void showNoItems() {

    }

    @Override
    public void showLoadError() {

    }

    @Override
    public void showLoading() {
        showDialog("loading....");
    }

    @Override
    public void hideLoading() {
        hideDialog();
    }
}
