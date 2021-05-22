package mygroup.appointments;

import mygroup.appointments.domain.City;
import mygroup.appointments.domain.DoctorSpeciality;

public class UpdateDoctorRequest {
    private City city;
    private String address;
    private String phone;
    private DoctorSpeciality doctorSpeciality;

    public UpdateDoctorRequest(City city, String address, String phone, DoctorSpeciality doctorSpeciality) {
        this.city = city;
        this.address = address;
        this.phone = phone;
        this.doctorSpeciality = doctorSpeciality;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public DoctorSpeciality getDoctorSpeciality() {
        return doctorSpeciality;
    }

    public void setDoctorSpeciality(DoctorSpeciality doctorSpeciality) {
        this.doctorSpeciality = doctorSpeciality;
    }
}
