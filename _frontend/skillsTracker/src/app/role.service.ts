import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Role } from './role';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RoleService {

  constructor(private http: HttpClient) { }

  rootURL = "http://localhost:9900/roles"

  getRolesList(): Observable<Role[]> {
    const url = this.rootURL + "/list"
    return this.http.get<Role[]>(url)
  }
}
