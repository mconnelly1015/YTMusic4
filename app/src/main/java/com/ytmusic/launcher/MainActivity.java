package com.ytmusic.launcher;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class MainActivity extends Activity {

    // Change these two lines to point at a different site / browser.
    private static final String URL = "https://music.youtube.com";
    private static final String BROWSER = "com.brave.browser";

    private boolean wentToBackground = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Open the page as a Custom Tab: a slim, app-like window run by Brave
        // (no address bar, no bottom navigation buttons).
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL));
        Bundle extras = new Bundle();
        extras.putBinder("android.support.customtabs.extra.SESSION", null);
        intent.putExtras(extras);
        intent.putExtra("android.support.customtabs.extra.ENABLE_URLBAR_HIDING", true);
        intent.putExtra("android.support.customtabs.extra.TOOLBAR_COLOR", 0xFF000000);
        intent.setPackage(BROWSER);
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            // Brave not installed: fall back to the default browser.
            intent.setPackage(null);
            startActivity(intent);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        wentToBackground = true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Coming back here means the custom tab was closed: close this launcher too.
        if (wentToBackground) {
            finish();
        }
    }
}
