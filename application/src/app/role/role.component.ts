import { Component, OnInit } from '@angular/core';
import { RoleService } from '../role.service';
import { role } from '../role'

@Component({
  selector: 'app-role',
  templateUrl: './role.component.html',
  styleUrls: ['./role.component.css']
})
export class RoleComponent implements OnInit {

  roles: Role[]

  constructor(private roleService:RoleService) {
    this.roles=[]
   }

  addNewAccount(newRole:Role){
    console.log(newRole)
    this.roleService.addAccount(newRole).subscribe(
      res =>{
        this.roleService.listAccounts().subscribe(
          res => {this.roles = res}
        )
      }
    )
   }

  ngOnInit() {
    this.roleService.listAccounts().subscribe(
      res => {this.roles = res
       
      }

    )
  }

}
