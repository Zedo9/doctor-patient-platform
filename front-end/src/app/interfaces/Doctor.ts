import { DoctorSpeciality } from './DoctorSpeciality';
import { City } from './City';
export interface Doctor {
  id: number;
  firstName: string;
  lastName: string;
  address: string;
  city: City;
  speciality: DoctorSpeciality;
}
