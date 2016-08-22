package com.skatset.activitycallbackobserver;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;

public class AppCompatActivityObserver {
    protected AppCompatActivity activityDelegate;

    public void setActivityDelegate(AppCompatActivity activityDelegate) {
        this.activityDelegate = activityDelegate;
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
    }

    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
    }

    protected void onConfigurationChanged(Configuration newConfig) {
    }

    protected void onPostResume() {
    }

    protected void onStart() {
    }

    protected void onStop() {
    }

    protected void onDestroy() {
    }

    protected void onTitleChanged(CharSequence title, int color) {
    }

    protected void onSupportActionModeStarted(@NonNull ActionMode mode) {
    }

    protected void onSupportActionModeFinished(@NonNull ActionMode mode) {
    }

    @Nullable
    protected ActionMode onWindowStartingSupportActionMode(@NonNull ActionMode.Callback callback) {
        return null;
    }

    protected void onCreateSupportNavigateUpTaskStack(@NonNull TaskStackBuilder builder) {
    }

    protected void onPrepareSupportNavigateUpTaskStack(@NonNull TaskStackBuilder builder) {
    }

    protected boolean onSupportNavigateUp() {
        return false;
    }

    protected void onContentChanged() {
    }

    protected boolean onMenuOpened(int featureId, Menu menu) {
        return false;
    }

    protected void onPanelClosed(int featureId, Menu menu) {
    }

    protected void onSaveInstanceState(Bundle outState) {
    }

    protected boolean onBackPressed() {
        return false;
    }

    protected void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                              @NonNull int[] grantResults) {
    }

    protected boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    protected boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }
}