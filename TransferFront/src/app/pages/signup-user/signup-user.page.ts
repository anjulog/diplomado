import { NewUser } from './../../models/new-user';
import { Component, OnInit } from '@angular/core';

import { AuthService } from 'src/app/services/auth.service';
import { AlertController, ToastController } from '@ionic/angular';

@Component({
  selector: 'app-signup-user',
  templateUrl: './signup-user.page.html',
  styleUrls: ['./signup-user.page.scss'],
})
export class SignupUserPage implements OnInit {

  form: any = {};
  private usuario: any = {};
  isRegister = false;
  isRegisterFail = false;
  errorMsg = '';
  mensajeOK = '';

  constructor(
    private authService: AuthService,
    private alertController: AlertController,
    private toastController: ToastController
    ) { }

  ngOnInit() {
  }

  onRegister() {
    this.usuario = new NewUser(this.form.nameUser, this.form.login, this.form.email, this.form.password);
    this.authService.registro(this.usuario).subscribe(data => {
      this.isRegister = true;
      this.isRegisterFail = false;
      this.presentToast();
    },
      (error: any) => {
        this.errorMsg = error.error.mensaje;
        this.isRegister = false;
        this.isRegisterFail = true;
        this.presentAlert();
      }
    );
  }

  async presentAlert() {
    const alert = await this.alertController.create({
      header: 'Fail en el registro',
      message: this.errorMsg,
      buttons: ['Aceptar']
    });

    await alert.present();
  }

  async presentToast() {
    const toast = await this.toastController.create({
      message: this.mensajeOK,
      duration: 2000
    });
    toast.present();
  }

}
