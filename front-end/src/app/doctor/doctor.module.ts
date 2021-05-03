import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DoctorRoutingModule } from './doctor-routing.module';
import { DoctorDashboardComponent } from './doctor-dashboard/doctor-dashboard.component';
import { AppointmentCardComponent } from './appointment-card/appointment-card.component';
import { PatientPageComponent } from './patient-page/patient-page.component';
import { DoctorLayoutComponent } from './doctor-layout/doctor-layout.component';

@NgModule({
  declarations: [
    DoctorLayoutComponent,
    DoctorDashboardComponent,
    AppointmentCardComponent,
    PatientPageComponent,
  ],
  imports: [CommonModule, DoctorRoutingModule],
})
export class DoctorModule {}
