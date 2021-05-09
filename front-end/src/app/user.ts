 import {UserType} from './interfaces/UserType';
export class User {
   
    user_id: number | undefined
    email: String | undefined;
    password:string | undefined;
    type: UserType | undefined;
    confirmed:boolean | undefined ;
    referralId:Number | undefined;

/* Constructor (user_id:number,email:string,password:string,type :UserType,  confirmed:boolean,  referralId:number)
    {
        this.email = email;
       this.password = password;
        this.type = type;
        this.confirmed = confirmed;
        this.referralId = referralId;
    }*/


    constructor(){}
  }


