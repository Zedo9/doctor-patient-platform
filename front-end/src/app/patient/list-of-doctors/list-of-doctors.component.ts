import { Component, OnInit } from '@angular/core';
import { City } from 'src/app/interfaces/City';
import { DoctorSpeciality } from 'src/app/interfaces/DoctorSpeciality';
import { Doctor } from '../../../app/interfaces/Doctor'

@Component({
  selector: 'app-list-of-doctors',
  templateUrl: './list-of-doctors.component.html',
  styleUrls: ['./list-of-doctors.component.css']
})
export class ListOfDoctorsComponent implements OnInit {

  doctor: Doctor = {
    id: 1,
    firstName: 'mouwahed',
    lastName: 'mhadhbi',
    address: 'Tunis, Tunisie',
    city: City.ARIANA,
    speciality:DoctorSpeciality.PSYCHIATRY,
  }

  constructor() { }

  ngOnInit(): void {
  }

  

}
