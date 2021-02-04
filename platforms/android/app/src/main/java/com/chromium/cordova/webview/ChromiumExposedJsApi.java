package com.chromium.cordova.webview;

import org.apache.cordova.CordovaBridge;
import org.apache.cordova.ExposedJsApi;
import org.json.JSONException;

public class ChromiumExposedJsApi implements ExposedJsApi {

  public ChromiumExposedJsApi(CordovaBridge bridge) {

  }

  @Override
  public String exec(int bridgeSecret, String service, String action, String callbackId, String arguments) throws JSONException, IllegalAccessException {
    return null;
  }

  @Override
  public void setNativeToJsBridgeMode(int bridgeSecret, int value) throws IllegalAccessException {

  }

  @Override
  public String retrieveJsMessages(int bridgeSecret, boolean fromOnlineEvent) throws IllegalAccessException {
    return null;
  }
}
