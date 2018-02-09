package com.fjy.gameboxmvp.modules.fragments;


import android.support.v4.app.Fragment;

import com.fjy.gameboxmvp.R;
import com.fjy.gameboxmvp.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends BaseFragment {


    public static final String TAG = MineFragment.class.getSimpleName();


    public MineFragment() {
        // Required empty public constructor
    }



    @Override
    protected void resolveDaggerDependency() {

    }

    @Override
    protected int getContentView() {
        return R.layout.fragment_mine;
    }

}
