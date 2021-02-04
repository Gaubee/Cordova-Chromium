import { Component, OnInit } from '@angular/core';
import { NavController } from 'ionic-angular';
import { LocalNotifications } from "@ionic-native/local-notifications";

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage implements OnInit {

  constructor(public navCtrl: NavController, private localNotifications: LocalNotifications) {
  }

  ngOnInit(): void {
    setTimeout(() => {
      this.showProgress();
    }, 3000);

    setTimeout(() => {
      this.localNotifications.schedule({
        id: 2,
        title: 'sync finished',
        text: '同步完成',
        sticky: false,
        lockscreen: true,
        silent: false,
        priority: 1
      });
    }, 5000);

    setTimeout(() => {
      // this.localNotifications.clear(1);
      this.localNotifications.schedule({
        id: 1,
        title: 'next round vote',
        text: '开启下一轮投票',
        sticky: true,
        lockscreen: true,
        silent: false,
        priority: 1
      });
    }, 20000);
  }

  private timeoutTimer;
  private value: number = 0;

  showProgress(): void {
    clearTimeout(this.timeoutTimer);

    this.localNotifications.schedule({
      id: 1,
      title: 'voting in progress',
      text: '正在进行第78轮投票',
      sticky: true,
      progressBar: {
        value: this.value
      }
    });

    console.log(`local notification schedule with id 1, value ${this.value} in ngOnInit, update with sticky`);

    if (this.value === 100) {
      this.timeoutTimer = setTimeout(() => {
        this.showFinishMessage();
      }, 1000);
    } else {
      this.timeoutTimer = setTimeout(() => {
        this.value += 10;
        this.showProgress();
      }, 1000);
    }
  }

  showFinishMessage(): void {
    this.localNotifications.schedule({
      id: 1,
      title: 'vote finished',
      text: '投票完成',
      sticky: true,
      lockscreen: true,
      silent: false,
      autoClear: true
    });
  }
}
