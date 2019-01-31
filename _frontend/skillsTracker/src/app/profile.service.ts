import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Profile } from './profile';
import { Skill } from './Skill';
import { Role } from './role';


@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  constructor(private http: HttpClient) { }

  rootURL = "http://localhost:9900/profiles"

  getProfile(profileId: number): Observable<Profile> {
    const url = this.rootURL + "/find?profileId=" + profileId
    return this.http.get<Profile>(url)
  }

  getProfileSkills(profileId: number): Observable<Role[]> {
    const url = this.rootURL + "/" + profileId + "/roles"
    return this.http.get<Skill[]>(url)
  }
}
