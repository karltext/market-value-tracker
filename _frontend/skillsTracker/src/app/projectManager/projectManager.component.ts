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

    constructor(private roleLogService: RoleLogService,
                private teamMemberService: TeamMemberService,
                private route: ActivatedRoute) { }

    ngOnInit() {
        this.roleLogService.getRoleLog().subscribe(
            res => { this.roleLogs = res }
        ),
        this.teamMemberService.getTeamMember().subscribe(
            res => { this.teamMembers = res }
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
    }

    deleteRoleLog(index: number) {
        this.roleLogService.deleteRoleLog(index).subscribe(
            res => {
                this.roleLogService.getRoleLog().subscribe(
                    res => { this.roleLogs = res }
                )
             }
            )
             }
    
    addNewTeamMember(newTeamMember: TeamMember) {
        this.teamMemberService.addNewTeamMember(newTeamMember).subscribe(
            res => {
                this.teamMemberService.getTeamMember().subscribe(
                    res => { this.teamMembers = res }
                )
            }
        )
    }

    addNewTeamMemberPJ(newTeamMember: TeamMember) {
        this.teamMemberService.addNewTeamMemberPJ(newTeamMember).subscribe(
            res => {
                this.teamMemberService.getTeamMember().subscribe(
                    res => { this.teamMembers = res }
                )
            }
        )
    }
            
    deleteTeamMember(index: number){
        this.teamMemberService.deleteTeamMember(index).subscribe(
             res => {
                  this.teamMemberService.getTeamMember().subscribe(
                   res => { this.teamMembers = res }
               )
            }
       )
    }   

    
}             
                 

