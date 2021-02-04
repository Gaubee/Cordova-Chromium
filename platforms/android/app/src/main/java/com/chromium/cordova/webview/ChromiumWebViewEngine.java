package com.chromium.cordova.webview;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.webkit.ServiceWorkerClient;
import android.webkit.ServiceWorkerController;
import android.webkit.ValueCallback;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;

import com.ionicframework.cordova.webview.IonicWebView;

import org.apache.cordova.ConfigXmlParser;
import org.apache.cordova.CordovaBridge;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPreferences;
import org.apache.cordova.CordovaResourceApi;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaWebViewEngine;
import org.apache.cordova.ICordovaCookieManager;
import org.apache.cordova.NativeToJsMessageQueue;
import org.apache.cordova.PluginManager;
import org.chromium.base.library_loader.LibraryLoader;
import org.chromium.base.library_loader.LibraryProcessType;
import org.chromium.base.library_loader.ProcessInitException;
import org.chromium.chrome.browser.compositor.layouts.content.TabContentManager;
import org.chromium.chrome.browser.tab.Tab;
import org.chromium.chrome.browser.tab.TabDelegateFactory;
import org.chromium.chrome.browser.tabmodel.TabLaunchType;
import org.chromium.content_public.browser.LoadUrlParams;
import org.chromium.ui.base.PageTransition;

public class ChromiumWebViewEngine implements CordovaWebViewEngine {
  public static final String TAG = "ChromiumWebViewEngine";

  protected final ChromiumCordovaView webView;
  protected final ChromiumCookieManager cookieManager;
  protected CordovaPreferences preferences;
  protected CordovaBridge bridge;
  protected CordovaWebViewEngine.Client client;
  protected CordovaWebView parentWebView;
  protected CordovaInterface cordova;
  protected PluginManager pluginManager;
  protected CordovaResourceApi resourceApi;
  protected NativeToJsMessageQueue nativeToJsMessageQueue;
  private BroadcastReceiver receiver;

  private WebViewLocalServer localServer;
  private String CDV_LOCAL_SERVER;
  private String scheme;
  private static final String LAST_BINARY_VERSION_CODE = "lastBinaryVersionCode";
  private static final String LAST_BINARY_VERSION_NAME = "lastBinaryVersionName";

  public ChromiumWebViewEngine(Context context, CordovaPreferences preferences) {
    this(new ChromiumCordovaView(context), preferences);
  }

  public ChromiumWebViewEngine(ChromiumCordovaView webView) {
    this(webView, null);
  }

  public ChromiumWebViewEngine(ChromiumCordovaView webView, CordovaPreferences preferences) {
    this.preferences = preferences;
    this.webView = webView;
    cookieManager = new ChromiumCookieManager();
  }

  @Override
  public void init(CordovaWebView parentWebView, CordovaInterface cordova, Client client, CordovaResourceApi resourceApi, PluginManager pluginManager, NativeToJsMessageQueue nativeToJsMessageQueue) {
    try {
      LibraryLoader.getInstance().ensureInitialized(LibraryProcessType.PROCESS_BROWSER);
    } catch (ProcessInitException e) {
      e.printStackTrace();
    }

    ConfigXmlParser parser = new ConfigXmlParser();

    if (this.cordova != null) {
      throw new IllegalStateException();
    }
    // Needed when prefs are not passed by the constructor
    if (preferences == null) {
      preferences = parentWebView.getPreferences();
    }
    this.parentWebView = parentWebView;
    this.cordova = cordova;
    this.client = client;
    this.resourceApi = resourceApi;
    this.pluginManager = pluginManager;
    this.nativeToJsMessageQueue = nativeToJsMessageQueue;
    webView.init(this, cordova);

    initWebViewSettings();

    nativeToJsMessageQueue.addBridgeMode(new NativeToJsMessageQueue.OnlineEventsBridgeMode(new NativeToJsMessageQueue.OnlineEventsBridgeMode.OnlineEventsBridgeModeDelegate() {
      @Override
      public void setNetworkAvailable(boolean value) {
        //sometimes this can be called after calling webview.destroy() on destroy()
        //thus resulting in a NullPointerException
        if(webView!=null) {
          webView.setNetworkAvailable(value);
        }
      }
      @Override
      public void runOnUiThread(Runnable r) {
        ChromiumWebViewEngine.this.cordova.getActivity().runOnUiThread(r);
      }
    }));
    nativeToJsMessageQueue.addBridgeMode(new NativeToJsMessageQueue.EvalBridgeMode(this, cordova));
    bridge = new CordovaBridge(pluginManager, nativeToJsMessageQueue);
    exposeJsInterface(webView, bridge);

    parser.parse(cordova.getActivity());

    String hostname = preferences.getString("Hostname", "localhost");
    scheme = preferences.getString("Scheme", "http");
    CDV_LOCAL_SERVER = scheme + "://" + hostname;

    localServer = new WebViewLocalServer(cordova.getActivity(), hostname, true, parser, scheme);
    localServer.hostAssets("www");

//    webView.setWebViewClient(new IonicWebViewEngine.ServerClient(this, parser));

    if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//      final WebSettings settings = webView.getSettings();
//      int mode = preferences.getInteger("MixedContentMode", 0);
//      settings.setMixedContentMode(mode);
    }
    SharedPreferences prefs = cordova.getActivity().getApplicationContext().getSharedPreferences(ChromiumWebView.WEBVIEW_PREFS_NAME, Activity.MODE_PRIVATE);
    String path = prefs.getString(ChromiumWebView.CDV_SERVER_PATH, null);
    if (!isDeployDisabled() && !isNewBinary() && path != null && !path.isEmpty()) {
      setServerBasePath(path);
    }

    boolean setAsServiceWorkerClient = preferences.getBoolean("ResolveServiceWorkerRequests", false);
    ServiceWorkerController controller = null;

    if (setAsServiceWorkerClient && android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
      controller = ServiceWorkerController.getInstance();
      controller.setServiceWorkerClient(new ServiceWorkerClient(){
        @Override
        public WebResourceResponse shouldInterceptRequest(WebResourceRequest request) {
          return localServer.shouldInterceptRequest(request.getUrl(), request);
        }
      });
    }
  }

  private void exposeJsInterface(ChromiumCordovaView webView, CordovaBridge bridge) {
    ChromiumExposedJsApi exposedJsApi = new ChromiumExposedJsApi(bridge);
    webView.addJavascriptInterface(exposedJsApi, "_cordovaNative");
  }

  private void initWebViewSettings() {
  }

  @Override
  public CordovaWebView getCordovaWebView() {
    return null;
  }

  @Override
  public ICordovaCookieManager getCookieManager() {
    return null;
  }

  @Override
  public View getView() {
    return webView;
  }

  @Override
  public void loadUrl(String url, boolean clearNavigationStack) {
    LoadUrlParams loadUrlParams = new LoadUrlParams(url, PageTransition.AUTO_BOOKMARK);
    Tab tab = new Tab(Tab.INVALID_TAB_ID, Tab.INVALID_TAB_ID, false, null,
      TabLaunchType.FROM_CHROME_UI, null, null);
    TabContentManager tabContentManager = new TabContentManager(webView.getContext(), webView, false);

    tab.initialize(null, tabContentManager, new TabDelegateFactory(), false, false);
    tab.loadUrl(loadUrlParams);
  }

  @Override
  public void stopLoading() {

  }

  @Override
  public String getUrl() {
    return null;
  }

  @Override
  public void clearCache() {

  }

  @Override
  public void clearHistory() {

  }

  @Override
  public boolean canGoBack() {
    return false;
  }

  @Override
  public boolean goBack() {
    return false;
  }

  @Override
  public void setPaused(boolean value) {

  }

  @Override
  public void destroy() {

  }

  @Override
  public void evaluateJavascript(String js, ValueCallback<String> callback) {

  }

  private boolean isNewBinary() {
    String versionCode = "";
    String versionName = "";
    SharedPreferences prefs = cordova.getActivity().getApplicationContext().getSharedPreferences(IonicWebView.WEBVIEW_PREFS_NAME, Activity.MODE_PRIVATE);
    String lastVersionCode = prefs.getString(LAST_BINARY_VERSION_CODE, null);
    String lastVersionName = prefs.getString(LAST_BINARY_VERSION_NAME, null);

    try {
      PackageInfo pInfo = this.cordova.getActivity().getPackageManager().getPackageInfo(this.cordova.getActivity().getPackageName(), 0);
      versionCode = Integer.toString(pInfo.versionCode);
      versionName = pInfo.versionName;
    } catch(Exception ex) {
      Log.e(TAG, "Unable to get package info", ex);
    }

    if (!versionCode.equals(lastVersionCode) || !versionName.equals(lastVersionName)) {
      SharedPreferences.Editor editor = prefs.edit();
      editor.putString(LAST_BINARY_VERSION_CODE, versionCode);
      editor.putString(LAST_BINARY_VERSION_NAME, versionName);
      editor.putString(IonicWebView.CDV_SERVER_PATH, "");
      editor.apply();
      return true;
    }
    return false;
  }

  private boolean isDeployDisabled() {
    return preferences.getBoolean("DisableDeploy", false);
  }

  public void setServerBasePath(String path) {
    localServer.hostFiles(path);
//    webView.load(CDV_LOCAL_SERVER, null);
  }

}
