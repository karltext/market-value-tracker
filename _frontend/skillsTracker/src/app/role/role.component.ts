import { Component, OnInit } from '@angular/core';
import { RoleService } from '../role.service';
import { Role } from '../role';

@Component({
  selector: 'app-role',
  templateUrl: './role.component.html',
  styleUrls: ['./role.component.scss']
})
export class RoleComponent implements OnInit {

  roles: Role[]
  fltRoles: Role[]
  reversed:boolean = false

  constructor(private roleService: RoleService) { }

  ngOnInit() {
    this.getRolesList()
  }

  getRolesList() {
    this.roleService.getRolesList()
      .subscribe(res => {
        this.roles = res.slice(0, 100)
      })
  }

  getRolesByName(role:String) {
    this.roleService.getRolesByName(role)
      .subscribe(res => {
        this.roles = res
      })
  }

  getRolesByOrder(field:number) {
    this.roleService.getRolesByOrder(field)
      .subscribe(res => {
        this.reversed = !this.reversed
        if(this.reversed){
          this.roles = res.reverse().slice(0,100)
        }else{
          this.roles = res.slice(0,100)
        }
      })
  }

}
