import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './user-auth/component/login/login.component';
import { RegisterComponent } from './user-auth/component/register/register.component';
import { UserComponent } from './user-profile/user/user.component';
import { LoginGuardService } from './route-guard/login-guard.service';
import { HomeComponent } from './home/component/home/home.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'profile', component: UserComponent, canActivate: [LoginGuardService] },
  { path: 'home', component: HomeComponent },
  { path: '**', redirectTo: '/home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
