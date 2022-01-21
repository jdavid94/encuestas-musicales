import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { Formulario } from '../models/formulario';
import { Genero } from '../models/genero';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class FormularioService {

  protected baseEndPoint: string = 'http://localhost:8080/api';

  constructor(protected http: HttpClient) { }

  public list(): Observable<Formulario[]> {
    return this.http.get<Formulario[]>(`${this.baseEndPoint}/formularios`);
  }

  public listPaginada(page: string, size: string): Observable<any> {
    const params = new HttpParams()
      .set('page', page)
      .set('size', size);
    return this.http.get<any>(`${this.baseEndPoint}/formularios/page/`, { params: params });
  }

  public listOpciones(): Observable<Genero[]> {
    return this.http.get<Genero[]>(`${this.baseEndPoint}/formularios/opciones`);
  }

  public create(formulario: Formulario): Observable<Formulario> {
    return this.http.post<Formulario>(`${this.baseEndPoint}/formulario`, formulario);
  }
}
