package com.skatset.activitycallbackobserver;

import android.os.Bundle;

public class ViewInitializerActivityObserver extends AppCompatActivityObserver {
    private final int contentViewLayoutId;

    public ViewInitializerActivityObserver(int contentViewLayoutId) {
        this.contentViewLayoutId = contentViewLayoutId;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        activityDelegate.setContentView(contentViewLayoutId);
    }
}
