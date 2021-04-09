package mygroup.appointments.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="patient")
public class Patient {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="patient_id")
    private Long patientId;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;

    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name="user_id_FK"), name = "user_id")
    private User user;

    @Column(name="first_name", length = 20)
    private String firstName;

    @Column(name="last_name", length = 20)
    private String lastName;

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

    public Patient(List<Appointment> appointments, User user, String firstName, String lastName, Gender gender, String phone, String address, City city, Date dateOfBirth) {
        this.appointments = appointments;
        this.user = user;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
}