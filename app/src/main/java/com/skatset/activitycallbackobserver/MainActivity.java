package com.skatset.activitycallbackobserver;

public class MainActivity extends AppCompatActivityObservable {

    public MainActivity() {
        ToolbarActivityObserver toolbarObservable = new ToolbarActivityObserver(R.id.toolbar);
        addObservers(
                new ViewInitializerActivityObserver(R.layout.activity_main),
                toolbarObservable,
                new DrawerActivityObserver(toolbarObservable, R.id.drawer_layout, R.id.nav_view),
                new MenuActionObserver(),
                new FABActionObserver(R.id.fab));
    }
}
