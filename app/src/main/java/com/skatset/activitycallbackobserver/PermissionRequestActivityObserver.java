package com.skatset.activitycallbackobserver;

import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PermissionRequestActivityObserver extends AppCompatActivityObserver {
    private final int randomRequestId = new Random().nextInt(1000) + 100;
    private final PermissionCallback callback;
    private String permission;

    public PermissionRequestActivityObserver(@NonNull PermissionCallback callback) {
        this.callback = callback;
    }

    public void requestPermission(@NonNull String permission) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M
                || ContextCompat.checkSelfPermission(activityDelegate, permission)
                == PackageManager.PERMISSION_GRANTED) {
            callback.onPermissionProvided(permission);
        } else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(activityDelegate, permission)) {
                callback.onExplanationDialogShouldShown(permission);
            } else {
                this.permission = permission;
                ActivityCompat.requestPermissions(activityDelegate,
                        new String[]{permission},
                        randomRequestId);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[],
                                           int[] grantResults) {
        List<String> permissionList = Arrays.asList(permissions);
        if (requestCode == randomRequestId && permissionList.contains(permission)) {
            int ownPermissionLocation = permissionList.indexOf(permission);
            if (grantResults.length > ownPermissionLocation
                    && grantResults[ownPermissionLocation] == PackageManager.PERMISSION_GRANTED) {
                callback.onPermissionProvided(permission);
            } else {
                callback.onPermissionDenied(permission);
            }
        }
    }

    public interface PermissionCallback {
        public void onPermissionProvided(String permission);
        public void onPermissionDenied(String permission);
        public void onExplanationDialogShouldShown(String permission);
    }
}
