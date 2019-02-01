import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Profile } from './profile';
import { Skill } from './Skill';
import { Role } from './role';


@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  constructor(private http: HttpClient) { }

  rootURL = "http://localhost:9900/profiles"

  postOptions = {
    headers: new HttpHeaders(
      {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8' })
  }

  getProfile(profileId: number): Observable<Profile> {
    const url = this.rootURL + "/find?profileId=" + profileId
    return this.http.get<Profile>(url)
  }

  getProfileRoles(profileId: number): Observable<Role[]> {
    const url = this.rootURL + "/" + profileId + "/roles"
    return this.http.get<Role[]>(url)
  }

  addRoleToProfile(profileId: number, roleId: number): Observable<Role> {
    const url = this.rootURL + "/role/add"
    const body = "profileId=" + profileId + "&roleId=" + roleId
    return this.http.post<Role>(url, body, this.postOptions)
  }
}
