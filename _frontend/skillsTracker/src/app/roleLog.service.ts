import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaderResponse } from '@angular/common/http';
import { RoleLog } from './roleLog';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RoleLogService {

  constructor(private http: HttpClient) { }

  rootURL = "http://localhost:9900/RoleLog"

  getRoleLogList(inputID): Observable<RoleLog[]> {
    const url = this.rootURL + "/list"
    return this.http.get<RoleLog[]>(url)
  }

}
