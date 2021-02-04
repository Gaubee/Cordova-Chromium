package com.chromium.cordova.webview;

import android.content.Context;
import android.util.AttributeSet;

import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaWebViewEngine;
import org.chromium.chrome.browser.compositor.CompositorViewHolder;

public class ChromiumCordovaView extends CompositorViewHolder implements CordovaWebViewEngine.EngineView {

  private CordovaInterface cordova;
  private ChromiumWebViewEngine parentEngine;

  public ChromiumCordovaView(Context c) {
    super(c);
  }

  public ChromiumCordovaView(Context c, AttributeSet attrs) {
    super(c, attrs);
  }

  // Package visibility to enforce that only SystemWebViewEngine should call this method.
  void init(ChromiumWebViewEngine parentEngine, CordovaInterface cordova) {
    this.cordova = cordova;
    this.parentEngine = parentEngine;
//    if (this.viewClient == null) {
//      setWebViewClient(new SystemWebViewClient(parentEngine));
//    }
//
//    if (this.chromeClient == null) {
//      setWebChromeClient(new SystemWebChromeClient(parentEngine));
//    }
  }



  public void addJavascriptInterface(ChromiumExposedJsApi exposedJsApi, String cordovaNative) {

  }

  public void setNetworkAvailable(boolean value) {

  }

  @Override
  public CordovaWebView getCordovaWebView() {
    return parentEngine == null ? null : parentEngine.getCordovaWebView();
  }
}
