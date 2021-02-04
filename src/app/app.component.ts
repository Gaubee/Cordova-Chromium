import { Component } from '@angular/core';
import { Platform } from 'ionic-angular';
import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';

import { TabsPage } from '../pages/tabs/tabs';
import { LocalNotifications } from '@ionic-native/local-notifications';

@Component({
  templateUrl: 'app.html'
})
export class MyApp {
  rootPage: any = TabsPage;

  constructor(platform: Platform, statusBar: StatusBar, splashScreen: SplashScreen, localNotifications: LocalNotifications) {
    platform.ready().then(() => {
      // Okay, so the platform is ready and our plugins are available.
      // Here you can do any higher level native things you might need.
      statusBar.styleDefault();
      splashScreen.hide();
    });
    document.addEventListener('backbutton', (event) => {
      event.stopPropagation()
      console.log(111)
    });

    document.addEventListener('deviceready', function () {
      console.log(localNotifications);
    }, false);

    // function replaceFunctionForFanyi(target: any, key: any) {
    //   const oldKey = Symbol("#fanyi#" + key);
    //   const sourceFun = target[key];
    //   target[oldKey] = sourceFun;
    //   function doFanyiArguments(...args: any[]) {
    //     args = args.map(arg => {
    //       if (arg) {
    //         arg = JSON.parse(
    //           JSON.stringify(arg, (key, value) => {
    //             if (value && value instanceof Array && typeof value[0] === "string" && value[0].startsWith("@@")) {
    //               return value;
    //             }
    //             if (typeof value === "string" && value.startsWith("@@")) {
    //               return value;
    //             }
    //             return value;
    //           })
    //         );
    //       }
    //       return arg;
    //     });
    //     return target[oldKey](args);
    //   }
    //   Object.defineProperty(doFanyiArguments, "sourceFun", { value: sourceFun });
    //   Object.defineProperty(target, key, { value: doFanyiArguments, enumerable: true, configurable: true });
    // }
    // replaceFunctionForFanyi(notifications, "schedule");
    // replaceFunctionForFanyi(notifications, "update");
    // notifications.clearAll();

    // localNotifications.schedule({ id: 2, lockscreen: true, silent: true, sticky: true, text: ["@@BEHIND_HEIGHT_#DIFF#"], title: "@@RESUMING_REPLAY_BLOCK" });
  }
}
