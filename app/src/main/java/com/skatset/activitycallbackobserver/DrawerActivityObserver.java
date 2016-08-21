package com.skatset.activitycallbackobserver;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;

public class DrawerActivityObserver extends AppCompatActivityObserver
        implements NavigationView.OnNavigationItemSelectedListener {
    private final ToolbarActivityObserver toolbarActivityObserver;
    private final int drawerId;
    private final int navigationViewId;
    private DrawerLayout drawer;

    public DrawerActivityObserver(ToolbarActivityObserver toolbarActivityObserver,
                                  int drawerId,
                                  int navigationViewId) {
        this.toolbarActivityObserver = toolbarActivityObserver;
        this.drawerId = drawerId;
        this.navigationViewId = navigationViewId;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        drawer = (DrawerLayout) activityDelegate.findViewById(drawerId);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                activityDelegate, drawer, toolbarActivityObserver.getToolbar(),
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView =
                (NavigationView) activityDelegate.findViewById(navigationViewId);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            activityDelegate.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
