import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CalendarPageComponent } from './calendar-page/calendar-page.component';
import { DoctorDashboardComponent } from './doctor-dashboard/doctor-dashboard.component';
import { DoctorLayoutComponent } from './doctor-layout/doctor-layout.component';
import { PatientsPageComponent } from './patients-page/patients-page.component';

const routes: Routes = [
  {
    path: '',
    component: DoctorLayoutComponent,
    children: [
      {
        path: 'dashboard',
        component: DoctorDashboardComponent,
      },
      {
        path: 'calendar',
        component: CalendarPageComponent,
      },
      {
        path: 'patients',
        component: PatientsPageComponent,
      },
      {
        path: '',
        redirectTo: 'dashboard',
        pathMatch: 'full',
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class DoctorRoutingModule {}
