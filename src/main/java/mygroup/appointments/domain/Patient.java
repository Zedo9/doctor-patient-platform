package mygroup.appointments.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="patient")
public class Patient {

    public Patient(){
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="patient_id")
    private Long patientId;

    @OneToMany(
            mappedBy = "patient",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Appointment> appointments;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name="first_name", length = 20)
    private String firstname;

    @Column(name="last_name", length = 20)
    private String lastname;

    //@Column(name="age")
    //private Integer age;

    @Column (name="gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column (name="phone")
    private String phone;

    @Column (name="address")
    private String address;

    @Column (name="city")
    @Enumerated(EnumType.STRING)
    private City city;

    @Temporal(TemporalType.DATE)
    @Column (name="date_of_birth")
    private Date dateOfBirth;

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Patient(Long patientId, Set<Appointment> appointments, User user, String firstname, String lastname, Gender gender, String phone, String address, City city, Date dateOfBirth) {
        this.patientId = patientId;
        this.appointments = appointments;
        this.user = user;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(patientId, patient.patientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientId);
    }
}