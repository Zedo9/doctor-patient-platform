import {Doctor} from "./Doctor"
import {Patient} from "./Patient"
import {appointmentStatus} from "./AppointmentStatus";
export interface Appointment{
  id : number;
  doctor : Doctor;
  patient : Patient;
  notes : string;
  appointmentStatus : AppointmentStatus;
  dateTime : Date
}
