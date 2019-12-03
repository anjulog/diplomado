import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Company } from '../models/company';

const cabecera = {headers: new HttpHeaders({'Content-TYpe': 'application/json'})};

@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  companyURL = 'http://18.218.213.52:8080/api/company/';

  constructor(private httpClient: HttpClient) { }

  public list(): Observable<Company[]> {
    return this.httpClient.get<Company[]>(this.companyURL + 'list', cabecera);
  }

  public detail(id: number): Observable<Company> {
    return this.httpClient.get<Company>(this.companyURL + `detail/${id}`, cabecera);
  }

  public new(company: Company): Observable<any> {
    return this.httpClient.post<any>(this.companyURL + 'new', company, cabecera);
  }

  public update(company: Company, id: number): Observable<any> {
    return this.httpClient.put<any>(this.companyURL + `update/${id}`, company, cabecera);
  }

  public delete(id: number): Observable<any> {
    return this.httpClient.delete<any>(this.companyURL + `delete/${id}`, cabecera);
  }
}