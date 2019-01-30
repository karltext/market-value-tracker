import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProfileComponent } from './profile/profile.component';
import { RoleComponent } from './role/role.component';
import { ProjectManagerComponent } from './projectManager/projectManager.component';

const routes: Routes = [
  {path: '', component: RoleComponent},
  {path: 'profile/:profileId', component: ProfileComponent},
  {path: 'projectManager', component: ProjectManagerComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
