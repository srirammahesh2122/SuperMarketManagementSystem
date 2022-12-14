import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { OwnerDataComponent } from './component/owner-data/owner-data.component';
import { AddItemsComponent } from './component/add-items/add-items.component';
import { LoginComponent } from './component/login/login.component';
import { RegisterComponent } from './component/register/register.component';
import { HomeComponent } from './component/home/home.component';
import { ProfileComponent } from './component/profile/profile.component';
import { RouterGuardService } from './service/router-guard.service';
import {UpdateItemComponent} from "./component/update-item/update-item.component";

const routes: Routes = [
  {path: '', component:HomeComponent},
  {path: 'data', component: OwnerDataComponent},
  {path: 'addItems', component: AddItemsComponent},
  {path: 'login', component:LoginComponent},
  {path: 'register', component:RegisterComponent},
  {path: 'addItems', component:AddItemsComponent},
  {path:'updateItem/:id',component:UpdateItemComponent},
  {path:'updateItem',redirectTo:"data"},
  {path: 'profile', component:ProfileComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
