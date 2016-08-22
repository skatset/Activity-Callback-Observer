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

import java.util.ArrayList;
import java.util.List;

public class AppCompatActivityObservable extends AppCompatActivity {
    protected List<AppCompatActivityObserver> observers = new ArrayList<>();

    public void addObserver(AppCompatActivityObserver observer) {
        if (observers.contains(observer)) return;
        observers.add(observer);
        observer.setActivityDelegate(this);
    }

    public void addObservers(AppCompatActivityObserver... observers) {
        for (AppCompatActivityObserver observer: observers) {
            if (this.observers.contains(observer)) continue;
            this.observers.add(observer);
            observer.setActivityDelegate(this);
        }
    }

    public void removeObserver(AppCompatActivityObserver observer) {
        observers.remove(observer);
    }

    public void removeObservers(AppCompatActivityObserver... observers) {
        for (AppCompatActivityObserver observer: observers) {
            this.observers.remove(observer);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        for (AppCompatActivityObserver observer: observers) {
            observer.onCreate(savedInstanceState);
        }
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        for (AppCompatActivityObserver observer: observers) {
            observer.onPostCreate(savedInstanceState);
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        for (AppCompatActivityObserver observer: observers) {
            observer.onConfigurationChanged(newConfig);
        }
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        for (AppCompatActivityObserver observer: observers) {
            observer.onPostResume();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        for (AppCompatActivityObserver observer: observers) {
            observer.onStart();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        for (AppCompatActivityObserver observer: observers) {
            observer.onStop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        for (AppCompatActivityObserver observer: observers) {
            observer.onDestroy();
        }
    }

    @Override
    protected void onTitleChanged(CharSequence title, int color) {
        super.onTitleChanged(title, color);
        for (AppCompatActivityObserver observer: observers) {
            observer.onTitleChanged(title, color);
        }
    }

    @Override
    public void onSupportActionModeStarted(@NonNull ActionMode mode) {
        super.onSupportActionModeStarted(mode);
        for (AppCompatActivityObserver observer: observers) {
            observer.onSupportActionModeStarted(mode);
        }
    }

    @Override
    public void onSupportActionModeFinished(@NonNull ActionMode mode) {
        super.onSupportActionModeFinished(mode);
        for (AppCompatActivityObserver observer: observers) {
            observer.onSupportActionModeFinished(mode);
        }
    }

    /**
     * Be careful - this method has different behavior rather then other methods in this class:
     * other methods call super class method in any case (and before observers);
     * this method call super class method only if no observer return ActionMode instance.
     *
     * Also this method will ask observers to return ActionMode instance till first observers
     * return it. Other ones know nothing about windows starting support action mode event
     * (its onWindowStartingSupportActionMode() will not be called).
     */
    @Nullable
    @Override
    public ActionMode onWindowStartingSupportActionMode(@NonNull ActionMode.Callback callback) {
        for (AppCompatActivityObserver observer: observers) {
            ActionMode actionMode = observer.onWindowStartingSupportActionMode(callback);
            if (actionMode != null) return actionMode;
        }
        return super.onWindowStartingSupportActionMode(callback);
    }

    @Override
    public void onCreateSupportNavigateUpTaskStack(@NonNull TaskStackBuilder builder) {
        super.onCreateSupportNavigateUpTaskStack(builder);
        for (AppCompatActivityObserver observer: observers) {
            observer.onCreateSupportNavigateUpTaskStack(builder);
        }
    }

    @Override
    public void onPrepareSupportNavigateUpTaskStack(@NonNull TaskStackBuilder builder) {
        super.onPrepareSupportNavigateUpTaskStack(builder);
        for (AppCompatActivityObserver observer: observers) {
            observer.onPrepareSupportNavigateUpTaskStack(builder);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        boolean isAnyReturnTrue = super.onSupportNavigateUp();
        for (AppCompatActivityObserver observer: observers) {
            isAnyReturnTrue = observer.onSupportNavigateUp() || isAnyReturnTrue;
        }
        return isAnyReturnTrue;
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        for (AppCompatActivityObserver observer: observers) {
            observer.onContentChanged();
        }
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        boolean isAnyReturnTrue = super.onMenuOpened(featureId, menu);
        for (AppCompatActivityObserver observer: observers) {
            isAnyReturnTrue = observer.onMenuOpened(featureId, menu) || isAnyReturnTrue;
        }
        return isAnyReturnTrue;
    }

    @Override
    public void onPanelClosed(int featureId, Menu menu) {
        super.onPanelClosed(featureId, menu);
        for (AppCompatActivityObserver observer: observers) {
            observer.onPanelClosed(featureId, menu);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        for (AppCompatActivityObserver observer: observers) {
            observer.onSaveInstanceState(outState);
        }
    }

    /**
     * Be careful - this method has different behavior rather then other methods in this class:
     * other methods call super class method in any case (and before observers);
     * this method call super class method only if no observer handle back press.
     *
     * Also this method will ask observers to handle back press till first observers handle it.
     * Other ones know nothing about back press (its onBackPressed() will not be called).
     */
    @Override
    public void onBackPressed() {
        for (AppCompatActivityObserver observer: observers) {
            if (observer.onBackPressed()) {
                return;
            }
        }
        super.onBackPressed();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        for (AppCompatActivityObserver observer: observers) {
            observer.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        boolean isAnyReturnTrue = super.onCreateOptionsMenu(menu);
        for (AppCompatActivityObserver observer: observers) {
            isAnyReturnTrue = observer.onCreateOptionsMenu(menu) || isAnyReturnTrue;
        }
        return isAnyReturnTrue;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean isAnyReturnTrue = super.onOptionsItemSelected(item);
        for (AppCompatActivityObserver observer: observers) {
            isAnyReturnTrue = observer.onOptionsItemSelected(item) || isAnyReturnTrue;
        }
        return isAnyReturnTrue;
    }
}
