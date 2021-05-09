import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RegistrationService } from '../registration.service';
import { User } from '../user';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
user = new  User();
msg="";

  constructor(private _service :RegistrationService, private _router : Router) { }

  ngOnInit(): void {
  }
  registerUser()
  {
this._service.registerUserFromRemote(this.user).subscribe(
   data => {
     console.log("response recieved");
     this.msg="Successs";
     },
   error =>{console.log("Exception occured");
   this.msg="Ce compte existe déja !";
   ;

  } 
  );
  }

}
