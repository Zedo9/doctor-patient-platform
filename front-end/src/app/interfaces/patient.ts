import {City} from "./City"
import {Gender}from "./Gender"

export interface Patient{
  patientId:number;
  firstName:string;
  lastName:string;
  gender:Gender;
  phone:string;
  address:string;
  city:City;
  dateOfBirth:Date;

}
