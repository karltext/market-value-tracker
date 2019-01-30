import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Profile } from './profile';


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
}
