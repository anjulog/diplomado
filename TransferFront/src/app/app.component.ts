import { Component , OnInit} from '@angular/core';

import { Platform, MenuController } from '@ionic/angular';
import { SplashScreen } from '@ionic-native/splash-screen/ngx';
import { StatusBar } from '@ionic-native/status-bar/ngx';

import { Router, RouterEvent, NavigationEnd } from '@angular/router';
import { TokenService } from './services/token.service';

import { ScrollDetail } from '@ionic/core';

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.scss']
})
export class AppComponent implements OnInit {


showToolbar = false;
isLogged = false;
isAdmin = false;

constructor(
  private platform: Platform,
  private splashScreen: SplashScreen,
  private statusBar: StatusBar,
  private router: Router,
  private tokenService: TokenService,
  private menuController: MenuController
) {
  this.initializeApp();
}

ngOnInit() {
  if (this.tokenService.getToken()) {
    this.isLogged = true;
    this.menuController.enable(true);
    if (this.tokenService.getAuthorities().indexOf('ROLE_ADMIN') !== -1) {
      this.isAdmin = true;
    } else {
      this.isAdmin = false;
    }
  } else {
    this.isLogged = false;
    this.menuController.enable(false);
  }
}

initializeApp() {
  this.platform.ready().then(() => {
    this.statusBar.styleDefault();
    this.splashScreen.hide();
  });
}

closeMenu() {
  this.menuController.close();
}

logOut() {
  this.tokenService.logOut();
  this.menuController.close();
  this.router.navigate(['']);
  window.location.reload();
}
onScroll($event: CustomEvent<ScrollDetail>) {
  if ($event && $event.detail && $event.detail.scrollTop) {
    const scrollTop = $event.detail.scrollTop;
    this.showToolbar = !(scrollTop >= 225);
  }
}
}
