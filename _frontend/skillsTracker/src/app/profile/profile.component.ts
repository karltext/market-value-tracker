import { Component, OnInit } from '@angular/core';
import { ProfileService } from '../profile.service';
import { ActivatedRoute } from '@angular/router';
import { Profile } from '../profile';
import { Skill } from '../Skill';
import { Role } from '../role';
import { RoleService } from '../role.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {

  profile: Profile
  roles: Role[]
  didLoadRoles: boolean = false

  maxSalary: number
  avgSalary: number
  percMarketSalary: number

  addMessage: string

  constructor(private profileService: ProfileService,
              private roleService: RoleService,
              private route: ActivatedRoute) { }

  ngOnInit() {
    const profileId = parseInt(this.route.snapshot.paramMap.get('profileId'))
    this.getProfile(profileId)
    this.getProfileRoles(profileId)
  }

  getProfile(profileId: number) {
    this.profileService.getProfile(profileId)
      .subscribe(res => {
        this.profile = res
      })
  }

  getProfileRoles(profileId: number) {
    this.profileService.getProfileRoles(profileId)
    .subscribe(res => {
      this.roles = res
      this.maxSalary = this.roleMax('median_salary')
      this.avgSalary = this.roleAvg('median_salary')
      this.percMarketSalary = this.salaryPercOfMarketAvg()
      this.didLoadRoles = true
    })
  }

  addRoleToProfileById(profileId: number, roleId: number) {
    this.profileService.addRoleToProfile(profileId, roleId)
      .subscribe(res => {
        console.log(res, "add success")
        this.getProfileRoles(profileId)
      })
  }
  
  roleAvg(column: string): number {
    return this.roleSum(column) / this.roles.length;
  }

  roleSum(column: string): number {
    let sum = 0
    for (let r of this.roles) {
      sum += r[column]
    }
    return sum
  }

  roleMax(column: string): number {
    var max = 0
    for (let r of this.roles) {
      if (max < r[column]) {
        max = r[column]
      }
    }
    return max
  }

  salaryPercOfMarketAvg(): number {
    return Math.floor((this.profile.salary / this.roleAvg('median_salary')) * 100)
  }

}
