import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Persona } from 'src/model/persona';

@Injectable({
  providedIn: 'root'
})
export class PersonaService {

  baseUrl:string = "http://localhost:8089/consultas";

  constructor(private http:HttpClient) { }

  getAll() : Observable<any>{
    return this.http.get(this.baseUrl + "/producto/view");
  }

  save(persona: Persona): Observable<any>{
    let headers = new HttpHeaders();
    headers = headers.set('Content-Type', 'application/json');
    return this.http.post(this.baseUrl +"/producto/add", JSON.stringify(persona), {headers: headers});
  }

  delete(id: number) : Observable<any>{
    return this.http.get(this.baseUrl +"/producto/delete/"+id);
  }
  update(persona: Persona): Observable<any>{
    let headers = new HttpHeaders();
    headers = headers.set('Content-Type', 'application/json');
    return this.http.put(this.baseUrl +"/producto/update", JSON.stringify(persona), {headers: headers});
  }
  UserDDL(): Observable<any>
  {
    return this.http.get(this.baseUrl+"/view"); 
  }
}
