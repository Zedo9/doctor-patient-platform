import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { LoginsuccessComponent } from './loginsuccess/loginsuccess.component';
import { SignupComponent } from './signup/signup.component';
const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'signup', component: SignupComponent },
  { path :'loginsuccess' , component: LoginsuccessComponent},
    
  //{path:'registration', component:SignupComponent},
  {
    path: 'doctor-dashboard',
    loadChildren: () =>
      import(`./doctor/doctor.module`).then((m) => m.DoctorModule),
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
