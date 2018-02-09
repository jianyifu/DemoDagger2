package com.fjy.gameboxmvp.mvp.presenter;

import android.support.annotation.NonNull;

import com.fjy.gameboxmvp.data.source.HomeRepo;
import com.fjy.gameboxmvp.util.schedulers.SchedulerProvider;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import timber.log.Timber;

/**
 * Created by fujianyi on 2017/12/11.
 */

public class HomePresenter implements HomeContract.Presenter {
    @NonNull
    private final HomeRepo mHomeReedsRepo;

    @NonNull
    private final HomeContract.View mView;

    @NonNull
    private final SchedulerProvider mSchedulerProvider;

    private boolean mFirstLoad = true;

    @Inject
    public HomePresenter(@NonNull HomeRepo mHomeReedsRepo, @NonNull HomeContract.View mView, @NonNull SchedulerProvider mSchedulerProvider) {
        this.mHomeReedsRepo = mHomeReedsRepo;
        this.mView = mView;
        this.mSchedulerProvider = mSchedulerProvider;
    }

    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    @Override
    public void subscribe() {
        loadItems(false);
    }

    @Override
    public void loadItems(boolean forceUpdate) {
        loadItems(forceUpdate || mFirstLoad, true);
        mFirstLoad = false;
    }
    /**
     * @param forceUpdate   Pass in true to refresh the data in the {@link HomeRepo}
     * @param showLoadingUI Pass in true to display a loading icon in the UI
     */
    private void loadItems(final boolean forceUpdate, final boolean showLoadingUI) {
        if (showLoadingUI) {
            mView.showLoading();
        }
        if (forceUpdate) {
            mHomeReedsRepo.refreshItems();
        }

        mCompositeDisposable.clear();
        Disposable disposable = mHomeReedsRepo
                .getItems()
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(
                        // onNext
                        items -> {
                            Timber.i("onNext items"+items);
                            processItems(items);
                            mView.hideLoading();
                        },
                        // onError
                        throwable -> {
                            Timber.i("onError items"+throwable.toString());
                            mView.hideLoading();
                            mView.showLoadError();});

        mCompositeDisposable.add(disposable);
    }

    private void processItems(List<Object> items) {
//        Timber.i(items.toString());
        mView.showItems(items);
    }

    @Override
    public void unsubscribe() {
        mCompositeDisposable.clear();
    }
}
