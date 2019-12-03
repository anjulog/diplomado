import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { LoginUser } from '../models/login-user';
import { Observable } from 'rxjs';
import { JwtModel } from '../models/jwt-model';
import { NewUser } from '../models/new-user';


const cabecera = {headers: new HttpHeaders({'Content-Type': 'application/json'})};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private authURL = 'http://18.218.213.52:8080/api/auth/';

  constructor(private httpClient: HttpClient) { }

  public login(usuario: LoginUser): Observable<JwtModel> {
    return this.httpClient.post<JwtModel>(this.authURL + 'login', usuario, cabecera);
  }

  public registro(usuario: NewUser): Observable<any> {
    return this.httpClient.post<any>(this.authURL + 'new', usuario, cabecera);
  }

}