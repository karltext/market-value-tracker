import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { TeamMember } from './teamMember';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TeamMemberService {

  constructor(private httpsvc: HttpClient) { }

  rootURL = "http://localhost:9900/team"

  getTeamMember():Observable<TeamMember[]>{
    return this.httpsvc.get<TeamMember[]>(this.rootURL+"/list")
   }

  addNewTeamMember(newTeamMember:TeamMember):Observable<any>{
    const httpOpts = {
      headers: new HttpHeaders(
        {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8' })
    }
    return this.httpsvc.post<TeamMember>(
      this.rootURL + "/register", {},httpOpts)
  }

  addNewTeamMemberPJ(newTeamMember:TeamMember):Observable<any>{
    const httpOpts = {
      headers: new HttpHeaders(
        {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8' })
    }
    return this.httpsvc.post<TeamMember>(
      this.rootURL + "/registerPJ", {},httpOpts)
  }

  deleteTeamMember(roleId: number): Observable<TeamMember> {
    return this.httpsvc.request<TeamMember>('DELETE', this.rootURL + "/delete",
      {
        headers: new HttpHeaders({ 'Content-Type': 'text/plain' }),
        body: roleId
      })
  }

  deleteAll(): Observable<TeamMember> {
    return this.httpsvc.request<TeamMember>('DELETE', this.rootURL + "/deleteAll",
      {
        headers: new HttpHeaders({ 'Content-Type': 'text/plain' }),
        body:{}
      })
  }


  


}