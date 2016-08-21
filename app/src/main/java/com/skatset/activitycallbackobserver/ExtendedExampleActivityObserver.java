package com.skatset.activitycallbackobserver;

import android.support.annotation.StyleRes;
import android.widget.Toast;

public class ExtendedExampleActivityObserver extends ExtendedAppCompatActivityObserver {
    @Override
    protected void setTheme(@StyleRes int resid) {
        Toast.makeText(activityDelegate, "There set method called", Toast.LENGTH_LONG).show();
    }
}
