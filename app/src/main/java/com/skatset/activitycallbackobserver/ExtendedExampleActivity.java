package com.skatset.activitycallbackobserver;

import android.os.Bundle;
import android.support.annotation.Nullable;

public class ExtendedExampleActivity extends ExtendedAppCompatActivityObservable {
    public ExtendedExampleActivity() {
        ToolbarActivityObserver toolbarObservable = new ToolbarActivityObserver(R.id.toolbar);
        addObservers(
                new ViewInitializerActivityObserver(R.layout.activity_extended_example),
                toolbarObservable,
                new MenuActionObserver(),
                new FABActionObserver(R.id.fab),
                new ExtendedExampleActivityObserver());
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Call it to test callback
        getSupportActionBar();
    }
}
