package mygroup.appointments.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="doctor_id")
    private Long doctorId;

    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name="user_id_FK"), name = "user_id")
    private User user;

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;

    @Column(name="first_name", length = 20)
    private String firstName;

    @Column(name="last_name", length = 20)
    private String lastName;

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

    public Doctor(User user, List<Appointment> appointments, String firstName, String lastName, String phone, String address, City city, DoctorSpeciality speciality) {
        this.user = user;
        this.appointments = appointments;
        this.firstName = firstName;
        this.lastName = lastName;
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

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
}
