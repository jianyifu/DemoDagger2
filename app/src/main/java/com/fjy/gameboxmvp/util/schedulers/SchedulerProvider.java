package com.fjy.gameboxmvp.util.schedulers;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * Provides different types of schedulers.
 */

public class SchedulerProvider {

    @Inject
    public SchedulerProvider() {
    }


    @NonNull
    public Scheduler computation() {
        return Schedulers.computation();
    }


    @NonNull
    public Scheduler io() {
        return Schedulers.io();
    }


    @NonNull
    public Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }
}
