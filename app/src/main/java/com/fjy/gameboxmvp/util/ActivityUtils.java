package com.fjy.gameboxmvp.util;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import static com.google.common.base.Preconditions.checkNotNull;

public class ActivityUtils {

    /**
     * The {@code fragment} is added to the container view with id {@code frameId}. The operation is
     * performed by the {@code fragmentManager}.
     */
    public static void addFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                             @NonNull Fragment fragment, int frameId) {
        checkNotNull(fragmentManager);
        checkNotNull(fragment);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(frameId, fragment);
        transaction.commit();
    }

    public static void replaceFragment(@NonNull FragmentManager fragmentManager,
                                       @NonNull Fragment fragment, int frameId) {
        checkNotNull(fragmentManager);
        checkNotNull(fragment);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(frameId, fragment);
        transaction.commit();
    }

    public static void showFragment(@NonNull FragmentManager fragmentManager,
                                    @NonNull Fragment fragment, int frameId, String tag) {
        checkNotNull(fragmentManager);
        checkNotNull(fragment);
        FragmentTransaction ft = fragmentManager.beginTransaction();
        if (fragment.isAdded()) { // if the fragment is already in container
            ft.show(fragment);
        } else { // fragment needs to be added to frame container
            ft.add(frameId, fragment, tag);
        }
        ft.commit();
    }

    public static void hideFragments(@NonNull FragmentManager fragmentManager,
                                     @NonNull Fragment... fragments) {
        checkNotNull(fragmentManager);
        checkNotNull(fragments);
        if (fragments.length > 0) {
            FragmentTransaction ft = fragmentManager.beginTransaction();
            for (int i = 0; i < fragments.length; i++) {
                Fragment fragment = fragments[i];
                checkNotNull(fragment);
                if (fragment.isAdded()) {
                    ft.hide(fragment);
                }
            }
            ft.commit();
        }
    }
}