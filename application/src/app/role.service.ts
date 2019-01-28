import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '../../node_modules/@angular/common/http';
import { Observable } from '../../node_modules/rxjs';
import { Role } from './role';

@Injectable({
  providedIn: 'root'
})
export class RoleService {

  rootURL: String
  constructor(private httpservice:HttpClient) { 
    this.rootURL="http://localhost:9900/role"
  }

  listRoles():Observable<Role[]>{
    return this.httpservice.get<Role[]>(this.rootURL+"/list")
   }

   
}
