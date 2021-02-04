package com.chromium.cordova.webview;

import android.util.Pair;

import org.chromium.chrome.browser.ChromeActivity;
import org.chromium.chrome.browser.tabmodel.TabModelSelector;

public class ChromiumCordovaActivity extends ChromeActivity {

  @Override
  protected TabModelSelector createTabModelSelector() {
    return null;
  }

  @Override
  protected Pair<? extends TabCreator, ? extends TabCreator> createTabCreators() {
    return null;
  }

  @Override
  protected boolean handleBackPressed() {
    return false;
  }
}
