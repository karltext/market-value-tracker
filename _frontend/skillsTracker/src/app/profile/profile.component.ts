import { Component, OnInit } from '@angular/core';
import { ProfileService } from '../profile.service';
import { ActivatedRoute } from '@angular/router';
import { Profile } from '../profile';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {

  profile: Profile

  constructor(private profileService: ProfileService,
              private route: ActivatedRoute) { }

  ngOnInit() {
    const profileId = parseInt(this.route.snapshot.paramMap.get('profileId'))
    this.getProfile(profileId)
  }

  getProfile(profileId: number) {
    this.profileService.getProfile(profileId)
      .subscribe(res => {
        this.profile = res
      })
  }

}