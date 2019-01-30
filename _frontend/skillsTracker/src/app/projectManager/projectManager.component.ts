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
    const inputID = parseInt(this.route.snapshot.paramMap.get('inputID'))
    this.roleLogService.getRoleLogList(inputID)
  }

  getRoleLog(inputID: number) {
    this.roleLogService.getRoleLogList(inputID)
      .subscribe(res => {
        this.roleLogs = res
      })
  }

}
