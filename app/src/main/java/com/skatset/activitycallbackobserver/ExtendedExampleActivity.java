package com.skatset.activitycallbackobserver;

public class ExtendedExampleActivity extends ExtendedAppCompatActivityObservable {
    public ExtendedExampleActivity() {
        addObservers(
                new ViewInitializerActivityObserver(R.layout.activity_extended_example),
                new ExtendedExampleActivityObserver());
    }
}
