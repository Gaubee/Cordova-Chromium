/*
       Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
 */

package io.ionic.starter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.util.Pair;

import org.apache.cordova.CordovaActivity;
import org.chromium.chrome.browser.ChromeActivity;
import org.chromium.chrome.browser.document.ChromeLauncherActivity;
import org.chromium.chrome.browser.tabmodel.TabModelSelector;
import org.apache.cordova.*;

//public class MainActivity extends CordovaActivity
//{
//    @Override
//    public void onCreate(Bundle savedInstanceState)
//    {
//        super.onCreate(savedInstanceState);
//
//        // enable Cordova apps to be started in the background
//        Bundle extras = getIntent().getExtras();
//        if (extras != null && extras.getBoolean("cdvStartInBackground", false)) {
//            moveTaskToBack(true);
//        }
//
//        // Set by <content src="index.html" /> in config.xml
//        // file:///android_asset/www/index.html
//        launchUrl = "https://amazon.com";
//        loadUrl(launchUrl);
//    }
//}

public class MainActivity extends ChromeLauncherActivity {

}

//public class MainActivity extends Activity {
//  @Override
//  protected void onCreate(@Nullable Bundle savedInstanceState) {
//    super.onCreate(savedInstanceState);
//
//    Intent intentIndex = new Intent(this, ChromeLauncherActivity.class);
//    Intent intentAdvertisement = new Intent(this, CordovaActivity.class);
//    Intent[] intents = new Intent[2];
//    intents[0] = intentIndex;
//    intents[1] = intentAdvertisement;
//    startActivities(intents);
//  }
//
//  class ChromiumCordovaActivity extends CordovaActivity {
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//      super.onCreate(savedInstanceState);
//
//      // enable Cordova apps to be started in the background
//      Bundle extras = getIntent().getExtras();
//      if (extras != null && extras.getBoolean("cdvStartInBackground", false)) {
//        moveTaskToBack(true);
//      }
//
//      // Set by <content src="index.html" /> in config.xml
//      // file:///android_asset/www/index.html
//      launchUrl = "https://amazon.com";
//      loadUrl(launchUrl);
//    }
//  }
//}
