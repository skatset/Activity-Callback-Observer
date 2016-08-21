package com.skatset.activitycallbackobserver;

import android.support.annotation.StyleRes;
import android.support.v7.app.AppCompatActivity;

public class ExtendedAppCompatActivityObservable<T extends AppCompatActivityObserver> extends AppCompatActivityObservable<T> {
    @Override
    public void setTheme(@StyleRes int resid) {
        super.setTheme(resid);
        for (T observer: observers) {
            if (observer.getClass().equals(ExtendedAppCompatActivityObserver.class)) {
                ((ExtendedAppCompatActivityObserver) observer).setTheme(resid);
            }
        }
    }
}
