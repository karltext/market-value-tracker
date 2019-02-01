import { Component, OnInit } from '@angular/core';
import { Profile } from '../profile';
import { ProfileService } from '../profile.service';

@Component({
  selector: 'app-leaderboard',
  templateUrl: './leaderboard.component.html',
  styleUrls: ['./leaderboard.component.scss']
})
export class LeaderboardComponent implements OnInit {

  profiles: Profile[]

  constructor(private profileService: ProfileService) { }

  ngOnInit() {
    this.getProfiles()
  }

  getProfiles() {
    this.profileService.listProfiles()
      .subscribe(res => {
        this.profiles = res
      })
  }


}
