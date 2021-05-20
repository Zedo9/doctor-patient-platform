import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PatientRoutingModule } from './patient-routing.module';
import { ListOfDoctorsComponent } from './list-of-doctors/list-of-doctors.component';
import { AppointmentRequestComponent } from './appointment-request/appointment-request.component';
import { SettintgsPageComponent } from './settintgs-page/settintgs-page.component';
import { AppointmentsComponent } from './appointments/appointments.component';



@NgModule({
  declarations: [
   
  
    ListOfDoctorsComponent,
           AppointmentRequestComponent,
           SettintgsPageComponent,
           AppointmentsComponent
  ],
  imports: [
    CommonModule,
    PatientRoutingModule
  ]
})
export class PatientModule { }
