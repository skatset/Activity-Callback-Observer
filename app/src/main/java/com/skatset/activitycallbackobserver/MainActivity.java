package com.skatset.activitycallbackobserver;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivityObservable {
    private final PermissionRequestActivityObserver permissionRequestActivityObserver;

    public MainActivity() {
        ToolbarActivityObserver toolbarObservable = new ToolbarActivityObserver(R.id.toolbar);
        permissionRequestActivityObserver =
                new PermissionRequestActivityObserver(createPermissionCallback());
        addObservers(
                new ViewInitializerActivityObserver(R.layout.activity_main),
                toolbarObservable,
                new DrawerActivityObserver(toolbarObservable, R.id.drawer_layout, R.id.nav_view),
                new MenuActionObserver(),
                new FABActionObserver(R.id.fab),
                permissionRequestActivityObserver);
    }

    @NonNull
    private PermissionRequestActivityObserver.PermissionCallback createPermissionCallback() {
        return new PermissionRequestActivityObserver.PermissionCallback() {
            @Override
            public void onPermissionProvided(String permission) {
                Toast.makeText(MainActivity.this, "Permission provided", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onPermissionDenied(String permission) {
                Toast.makeText(MainActivity.this, "Permission denied", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onExplanationDialogShouldShown(String permission) {
                Toast.makeText(MainActivity.this, "Please, provide permission for test",
                        Toast.LENGTH_LONG).show();
            }
        };
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        permissionRequestActivityObserver.requestPermission(Manifest.permission.CAMERA);
        findViewById(R.id.open_extended_example_activity).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(MainActivity.this, ExtendedExampleActivity.class));
                    }
        });
    }
}
