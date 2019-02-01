import { Component, OnInit } from '@angular/core';
import { RoleLogService } from '../roleLog.service';
import { ActivatedRoute } from '@angular/router';
import { RoleLog } from '../roleLog';
import { TeamMember } from '../teamMember';
import { TeamMemberService } from '../teamMember.service';

@Component({
    selector: 'app-profile',
    templateUrl: './projectManager.component.html',
    styleUrls: ['./projectManager.component.css']
})
export class ProjectManagerComponent implements OnInit {

    roleLogs: RoleLog[]
    teamMembers: TeamMember[]

    totalSalary:number
    monthlySalary:number
    monthlyCharge:number

    constructor(private roleLogService: RoleLogService,
                private teamMemberService: TeamMemberService,
                private route: ActivatedRoute) { }

    ngOnInit() {
        this.roleLogService.getRoleLog().subscribe(
            res => {
                this.roleLogs = res }
        ),
        this.teamMemberService.getTeamMember().subscribe(
            res => { 
                this.teamMembers = res 
                this.totalSalary = this.teamSum('salary')
                this.monthlySalary = this.monthlySalarySum()
                this.monthlyCharge = this.monthlyChargeSum()
            }
        )
    }

    addNewRoleLog(newRoleLog: RoleLog) {
        this.roleLogService.addNewRoleLog(newRoleLog).subscribe(
            res => {
                this.roleLogService.getRoleLog().subscribe(
                    res => { this.roleLogs = res }
                )
            }
        )
        this.ngOnInit();
    }

    deleteRoleLog(index: number) {
        this.roleLogService.deleteRoleLog(index).subscribe(
            res => {
                this.roleLogService.getRoleLog().subscribe(
                    res => { this.roleLogs = res }
                )
             }
        )
        this.ngOnInit();
    }
    
    addNewTeamMember(newTeamMember: TeamMember) {
        this.teamMemberService.addNewTeamMember(newTeamMember).subscribe(
            res => {
                this.teamMemberService.getTeamMember().subscribe(
                    res => { this.teamMembers = res }
                )
            }
        )
        this.ngOnInit();
    }

    addNewTeamMemberPJ(newTeamMember: TeamMember) {
        this.teamMemberService.addNewTeamMemberPJ(newTeamMember).subscribe(
            res => {
                this.teamMemberService.getTeamMember().subscribe(
                    res => { this.teamMembers = res }
                )
            }
        )
        this.ngOnInit();
    }
            
    deleteTeamMember(index: number){
        this.teamMemberService.deleteTeamMember(index).subscribe(
             res => {
                  this.teamMemberService.getTeamMember().subscribe(
                   res => { this.teamMembers = res }
               )
            }
       )
       this.ngOnInit();
    }   

    deleteAll(){
        this.teamMemberService.deleteAll().subscribe(
            res => {
                 this.teamMemberService.getTeamMember().subscribe(
                  res => { this.teamMembers = res }
              )
           }
      )
      this.ngOnInit();
    }

  teamSum(column: string): number {
    let sum = 0
    for (let tm of this.teamMembers) {
      sum += tm[column]
    }
    return sum
  }

  monthlySalarySum(): number {
    return Math.floor(this.totalSalary / 12)
  }

  monthlyChargeSum(): number {
    return Math.floor((this.totalSalary / 12)*1.6)
  }

    
}             
                 

