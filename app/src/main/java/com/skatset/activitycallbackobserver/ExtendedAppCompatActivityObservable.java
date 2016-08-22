package com.skatset.activitycallbackobserver;

import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.v7.app.ActionBar;

public class ExtendedAppCompatActivityObservable extends AppCompatActivityObservable {

    @Nullable
    @Override
    public ActionBar getSupportActionBar() {
        for (AppCompatActivityObserver observer: observers) {
            if (observer.getClass().getSuperclass().equals(ExtendedAppCompatActivityObserver.class)) {
                ((ExtendedAppCompatActivityObserver) observer).onGetSupportActionBar();
            }
        }
        return super.getSupportActionBar();
    }
}
