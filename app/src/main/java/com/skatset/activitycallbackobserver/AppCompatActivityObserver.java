package com.skatset.activitycallbackobserver;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class AppCompatActivityObserver {
    protected AppCompatActivity activityDelegate;

    public void setActivityDelegate(AppCompatActivity activityDelegate) {
        this.activityDelegate = activityDelegate;
    }

    protected void onCreate(Bundle savedInstanceState) {
    }

    protected void onBackPressed() {
    }

    protected boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    protected boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }
}
