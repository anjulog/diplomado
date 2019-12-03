import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-company',
  templateUrl: './company.page.html',
  styleUrls: ['./company.page.scss'],
})
export class CompanyPage implements OnInit {

  isDisplay: boolean= false;

  constructor() { }

  ngOnInit() {
  }

  prueba(){
    console.log("Estw en una pfuba");
    if (this.isDisplay)
    {
      this.isDisplay = false;
    }
    else 
    {
      this.isDisplay = true;
    }
  }
}
