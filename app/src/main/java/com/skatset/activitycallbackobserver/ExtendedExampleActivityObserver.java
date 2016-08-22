package com.skatset.activitycallbackobserver;

import android.widget.Toast;

public class ExtendedExampleActivityObserver extends ExtendedAppCompatActivityObserver {
    @Override
    protected void onGetSupportActionBar() {
        Toast.makeText(activityDelegate, "Get support activity method called", Toast.LENGTH_LONG).show();
    }
}
