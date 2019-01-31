import { Component, OnInit } from '@angular/core';
import { RoleLogService } from '../roleLog.service';
import { ActivatedRoute } from '@angular/router';
import { RoleLog } from '../roleLog';

@Component({
    selector: 'app-profile',
    templateUrl: './projectManager.component.html',
    styleUrls: ['./projectManager.component.css']
})
export class ProjectManagerComponent implements OnInit {

    roleLogs: RoleLog[]

    constructor(private roleLogService: RoleLogService,
        private route: ActivatedRoute) { }

    ngOnInit() {
        this.roleLogService.getRoleLog().subscribe(
            res => { this.roleLogs = res }
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
          

            calculateCost(){
              
            }
    }
