package com.skatset.activitycallbackobserver;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class ToolbarActivityObserver extends AppCompatActivityObserver {
    private final int toolbarId;
    private Toolbar toolbar;

    public ToolbarActivityObserver(int toolbarId) {
        this.toolbarId = toolbarId;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolbar = (Toolbar) activityDelegate.findViewById(toolbarId);
        activityDelegate.setSupportActionBar(toolbar);
    }

    public Toolbar getToolbar() {
        return toolbar;
    }
}
