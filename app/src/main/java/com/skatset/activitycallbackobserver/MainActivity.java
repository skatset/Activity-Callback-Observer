package com.skatset.activitycallbackobserver;

public class MainActivity extends AppCompatActivityObservable {

    public MainActivity() {
        super(R.layout.activity_main);
        ToolbarActivityObserver toolbarObservable = new ToolbarActivityObserver(R.id.toolbar);
        addObservers(
                toolbarObservable,
                new DrawerActivityObserver(toolbarObservable, R.id.drawer_layout, R.id.nav_view),
                new MenuActionObserver(),
                new FABActionObserver(R.id.fab));
    }
}
