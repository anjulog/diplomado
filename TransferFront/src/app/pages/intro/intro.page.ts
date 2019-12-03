import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';

import { TokenService } from 'src/app/services/token.service';


@Component({
  selector: 'app-intro',
  templateUrl: './intro.page.html',
  styleUrls: ['./intro.page.scss'],
})
export class IntroPage implements OnInit {

  bg:string;
  isLogged = false;

  
  constructor(private router: Router, 
    private tokenService: TokenService) {
    this.bg = "'../../../assets/img/login.jpg";
  }

  ngOnInit() {
    if (this.tokenService.getToken()!=null) {

      console.log("Entrando a dashboard-user ");
      this.isLogged= true;
      this.router.navigate(['dashboard-user']);
    }

  }

  onClickEnter()
  {
    this.router.navigate(['login']);
  }
}
