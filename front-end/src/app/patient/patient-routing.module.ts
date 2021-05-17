import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {PatientPageComponent} from '../doctor/patient-page/patient-page.component'
import {ListOfDoctorsComponent} from './list-of-doctors/list-of-doctors.component'
import { AppointmentRequestComponent } from './appointment-request/appointment-request.component'
import { AppointmentsComponent } from './appointments/appointments.component'
import { SettintgsPageComponent } from './settintgs-page/settintgs-page.component'

const routes: Routes = [
  {
    path: '',
    component: PatientPageComponent,
    children: [
      {
        path: 'list-of-doctors',
        component:ListOfDoctorsComponent,
      },
      {
        path: 'appointment-request',
        component:AppointmentRequestComponent,
      },
      {
        path: 'appointments',
        component:AppointmentsComponent,
      },
      {
        path: 'settings-page',
        component:SettintgsPageComponent,
      },
      
        {
          path: '',
          redirectTo: 'dashboard',
          pathMatch: 'full',
        },
      
      
    ]
   
  }
  
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PatientRoutingModule { }
