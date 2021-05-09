import { Component, NgZone, OnInit, Renderer2 } from '@angular/core';
import * as moment from 'moment';
import { City } from 'src/app/interfaces/City';
import { Doctor } from 'src/app/interfaces/Doctor';
import { DoctorSpeciality } from 'src/app/interfaces/DoctorSpeciality';

const FORMAT = 'MMMM Do YYYY, hh:mm A';

@Component({
  selector: 'app-doctor-layout',
  templateUrl: './doctor-layout.component.html',
  styleUrls: ['./doctor-layout.component.css'],
})
export class DoctorLayoutComponent implements OnInit {
  time: string = moment().format(FORMAT);
  doctor: Doctor = {
    id: 1,
    firstName: 'firstName',
    lastName: 'lastName',
    address: 'Address',
    city: City.ARIANA,
    speciality: DoctorSpeciality.EMERGENCY,
  };
  constructor() {
    this.refreshTime();
  }

  refreshTime() {
    setInterval(() => {
      this.time = moment().format(FORMAT);
    }, 10000);
  }

  ngOnInit(): void {}
}
