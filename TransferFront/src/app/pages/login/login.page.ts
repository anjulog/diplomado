import { Component, OnInit } from '@angular/core';
import { LoginUser } from 'src/app/models/login-user';
import { AuthService } from 'src/app/services/auth.service';
import { TokenService } from 'src/app/services/token.service';
import { AlertController } from '@ionic/angular';
import { ScrollDetail } from '@ionic/core';
import { Router } from '@angular/router';

import {Storage} from "@ionic/storage";
import { LoadingController } from '@ionic/angular';

@Component({
  selector: 'app-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss'],
})
export class LoginPage implements OnInit {
  form: any = {};
  usuario: LoginUser;
  nombreUser: string;
  isLogged = false;
  isLoginFail = false;
  roles: string[] = [];
  errorMsg = '';
  user: any;
  isLoggedIn: Boolean;
  loaderToShow: any;

  constructor(
    private authService: AuthService,
    private router: Router,
    private tokenService: TokenService,
    private alertController: AlertController,
    private storage: Storage,
    public loadingController: LoadingController
    ) { }

  ngOnInit() {
    
    if (this.tokenService.getToken()!=null) {
    // comprobamos los valores del token
      console.log('Name: ' + this.tokenService.getLogin());
      console.log('Token: ' + this.tokenService.getToken());
      console.log('Roles: ' + this.tokenService.getAuthorities());
      this.nombreUser = this.tokenService.getLogin();
      this.isLogged = true;
      this.isLoginFail = false;
      this.roles = this.tokenService.getAuthorities();

      console.log('Estado del usuario actualmente es -->' + this.isLogged);

      this.router.navigate(['dashboard-user']);
      if (this.isLogged){
        debugger;
        
      }
    }
  }

  onEnter(event){
    console.log(event, event.keyCode, event.keyIdentifier);
  }

  onLogin() {
    debugger;
    this.loaderToShow = this.loadingController.create({
      cssClass:'loading-app'
    }).then((res) => {
      res.present();
    });
    this.usuario = new LoginUser(this.form.login, this.form.password);

    this.authService.login(this.usuario).subscribe(data => {
      this.tokenService.setToken(data.token);
      this.tokenService.setLogin(data.login);
      this.tokenService.setAuthorities(data.authorities);
      this.isLogged = true;
      this.isLoginFail = false;
      this.roles = this.tokenService.getAuthorities();
     // this.tokenService.authenticationState.next(true);
      

      this.storage.set('user', this.form.login).then(() => {
        this.isLoggedIn = true;
        this.user = this.form.login;
      });


      console.log('Abriendo el dashboar-user');

      //this.router.navigate(['admin']);
      this.loadingController.dismiss();

      console.log('Loading dismissed!');

      window.location.reload();
    },
      (err: any) => {
        console.log(err);
        this.isLogged = false;
        this.isLoginFail = true;
        this.errorMsg = err.error.message;
        this.loadingController.dismiss();
        this.presentAlert();
       // this.tokenService.authenticationState.next(false);
      }
    );

  }

  async presentAlert() {
    const alert = await this.alertController.create({
      header: 'Fail en el login',
      message: this.errorMsg,
      buttons: ['Aceptar']
    });

    await alert.present();
  }

onLogout() {
  debugger;
  console.log ("Cerrando session");
  this.tokenService.logOut();
  this.isLogged = false;
  //window.location.reload();
}
showToolbar = false;


onScroll($event: CustomEvent<ScrollDetail>) {
    if ($event && $event.detail && $event.detail.scrollTop) {
      const scrollTop = $event.detail.scrollTop;
      this.showToolbar = scrollTop >= 225;
    }
}

}