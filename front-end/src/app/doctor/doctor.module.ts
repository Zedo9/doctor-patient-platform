import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DoctorRoutingModule } from './doctor-routing.module';
import { DoctorDashboardComponent } from './doctor-dashboard/doctor-dashboard.component';
import { AppointmentCardComponent } from './appointment-card/appointment-card.component';
import { PatientPageComponent } from './patient-page/patient-page.component';
import { DoctorLayoutComponent } from './doctor-layout/doctor-layout.component';
import { PatientsPageComponent } from './patients-page/patients-page.component';
import { CalendarPageComponent } from './calendar-page/calendar-page.component';

@NgModule({
  declarations: [
    DoctorLayoutComponent,
    DoctorDashboardComponent,
    AppointmentCardComponent,
    PatientPageComponent,
    PatientsPageComponent,
    CalendarPageComponent,
  ],
  imports: [CommonModule, DoctorRoutingModule],
})
export class DoctorModule {}
