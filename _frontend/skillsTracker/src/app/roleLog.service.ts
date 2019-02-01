import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { RoleLog } from './roleLog';
import { Observable } from 'rxjs';
import {Role} from './role'

@Injectable({
  providedIn: 'root'
})
export class RoleLogService {

  constructor(private httpsvc: HttpClient) { }

  rootURL = "http://localhost:9900/rolehours"

  getRoleLog():Observable<RoleLog[]>{
    return this.httpsvc.get<RoleLog[]>(this.rootURL+"/list")
   }

  addNewRoleLog(newRoleLog:RoleLog):Observable<any>{
    const httpOpts = {
      headers: new HttpHeaders(
        {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8' })
    }
    var reqBody = "role=" + newRoleLog.role + "&hours=" + newRoleLog.hours
    return this.httpsvc.post<RoleLog>(
      this.rootURL + "/register", reqBody, httpOpts)
  }

  deleteRoleLog(inputID: number): Observable<RoleLog> {
    return this.httpsvc.request<RoleLog>('DELETE', this.rootURL + "/delete",
      {
        headers: new HttpHeaders({ 'Content-Type': 'text/plain' }),
        body: inputID
      })
  }

  getSalaryByRole(role:String): Observable<Role[]> {
    const url = this.rootURL + "/findByRole?skill="+role
    return this.httpsvc.get<Role[]>(url)
  }
}
  


