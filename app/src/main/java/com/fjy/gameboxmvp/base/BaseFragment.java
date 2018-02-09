package com.fjy.gameboxmvp.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fjy.gameboxmvp.application.GameBoxMVPApplication;
import com.fjy.gameboxmvp.di.components.ApplicationComponent;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by fujianyi on 2017/12/8.
 */

public abstract class BaseFragment extends Fragment {

    private ProgressDialog mProgressDialog;
    Unbinder unbinder;
    protected View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(getContentView(), container, false);
        }
        unbinder = ButterKnife.bind(this, view);
        onViewReady(savedInstanceState);
        return view;
    }

    @CallSuper
    protected void onViewReady(Bundle savedInstanceState) {
        resolveDaggerDependency();
    }

    protected abstract void resolveDaggerDependency();

    protected abstract int getContentView();

    protected void showDialog(String message) {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(view.getContext());
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            mProgressDialog.setCancelable(true);
        }
        mProgressDialog.setMessage(message);
        mProgressDialog.show();
    }

    protected void hideDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    protected ApplicationComponent getAppComponent() {
        return GameBoxMVPApplication.instance().component();
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }
}
