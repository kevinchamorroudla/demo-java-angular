import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Clientes } from '../data/clientes';

@Injectable({
  providedIn: 'root'
})
export class GestionContratosService {

  urlbase = 'http://localhost:8080/clientes'

  constructor(private http: HttpClient) { }

  get_clientes() {
    return this.http.get<Clientes[]>(this.urlbase)
  }

}
