package mygroup.appointments.domain;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="doctor")
public class Doctor {
    public Doctor(){

    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="doctor_id")
    private Long doctorId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "doctor",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Appointment> appointments;

    @Column(name="first_name", length = 20)
    private String firstname;

    @Column(name="last_name", length = 20)
    private String lastname;

    @Column (name="phone")
    private String phone;

    @Column (name="address")
    private String address;

    @Column (name="city")
    @Enumerated(EnumType.STRING)
    private City city;

    @Column(name="speciality")
    @Enumerated(EnumType.STRING)
    private DoctorSpeciality speciality;

    public Doctor(
            Long doctorId,
            User user,
            Set<Appointment> appointments,
            String firstname,
            String lastname,
            String phone,
            String address,
            City city,
            DoctorSpeciality speciality) {
        this.doctorId = doctorId;
        this.user = user;
        this.appointments = appointments;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.speciality = speciality;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public DoctorSpeciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(DoctorSpeciality speciality) {
        this.speciality = speciality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(doctorId, doctor.doctorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctorId);
    }
}
