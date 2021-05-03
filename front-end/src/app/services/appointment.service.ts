import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Appointment } from '../interfaces/Appointment';
import { Doctor } from '../interfaces/Doctor';
import { Patient } from '../interfaces/Patient';

@Injectable({
  providedIn: 'root',
})
export class AppointmentService {
  API_HOST: string = environment.API_HOST;
  constructor() {}

  getConfirmedFutureAppointmentsByDoctor(doctor: Doctor) {}
  getPendingAppointmentsByDoctor(doctor: Doctor) {}
  getAppointmentsByPatient(patient: Patient) {}

  rejectAppointment(appointment: Appointment) {}
  confirmAppointment(appointment: Appointment) {}
  createAppointment(appointment: Appointment) {}
  updateAppointment(appointment: Appointment) {}
}
