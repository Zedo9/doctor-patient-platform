package mygroup.appointments.requests;

import mygroup.appointments.domain.City;

public class UpdatePatientRequest {
   private String phone;
   private String address;
   private City city;

   public UpdatePatientRequest(){}

    public UpdatePatientRequest(String phone,String address,City city){
       this.phone=phone;
       this.address=address;
       this.city=city;
    }

    public String getPhone(){
       return phone;
    }
    public String getAddress(){
       return address;
    }
    public City getCity(){
       return city;
    }

    public void setPhone(String Phone){
       phone=Phone;
    }
    public void setAddress(String Address){
       address=Address;
    }
    public void setCity(City cityy){
       city=cityy;
    }

}
