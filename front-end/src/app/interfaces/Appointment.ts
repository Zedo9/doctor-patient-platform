import { AppointmentStatus } from './AppointmentStatus';
import { Doctor } from './Doctor';
import { Patient } from './Patient';

export interface Appointment {
  id: number;
  doctor: Doctor;
  patient: Patient;
  notes: string;
  appointmentStatus: AppointmentStatus;
  dateTime: Date;
}
