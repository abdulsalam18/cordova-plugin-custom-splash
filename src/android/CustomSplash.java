package com.custom.splash;

import org.apache.cordova.*;
import org.json.JSONArray;

import android.app.Activity;
import android.os.Handler;
import android.view.WindowManager;

public class CustomSplash extends CordovaPlugin {

    private Activity activity;

    @Override
    protected void pluginInitialize() {
        activity = cordova.getActivity();
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {

        if(action.equals("showSplash")) {
            activity.runOnUiThread(() -> {
                // Full screen splash
                activity.getWindow().setFlags(
                    WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN
                );
            });

            callbackContext.success("Splash shown");
            return true;
        }

        if(action.equals("hideSplash")) {
            activity.runOnUiThread(() -> {
                // Remove full screen flags
                activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            });

            callbackContext.success("Splash hidden");
            return true;
        }

        return false;
    }
}
