package com.skatset.activitycallbackobserver;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class AppCompatActivityObservable extends AppCompatActivity {
    private List<AppCompatActivityObserver> observers = new ArrayList<>();

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

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        for (AppCompatActivityObserver observer: observers) {
            observer.onCreate(savedInstanceState);
        }
    }

    public void onBackPressed() {
        for (AppCompatActivityObserver observer: observers) {
            observer.onBackPressed();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        boolean isAnyReturnTrue = false;
        for (AppCompatActivityObserver observer: observers) {
            isAnyReturnTrue = observer.onCreateOptionsMenu(menu) || isAnyReturnTrue;
        }
        return isAnyReturnTrue;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        boolean isAnyReturnTrue = false;
        for (AppCompatActivityObserver observer: observers) {
            isAnyReturnTrue = observer.onOptionsItemSelected(item) || isAnyReturnTrue;
        }
        return isAnyReturnTrue;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        for (AppCompatActivityObserver observer: observers) {
            observer.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
}
