package domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="patient")
public class Patient {
    public Patient(){}
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="patient_id")
    private int patientId;

    @OneToMany(mappedBy = "patient")
    private Set<Appointment> appointments;

    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name="user_id_FK"), name = "user_id")
    private User user;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="age")
    private String age;

    @Column (name="gender")
    private String gender;

    @Column (name="phone")
    private String phone;

    @Column (name="address")
    private String address;

    @Column (name="city")
    private String city;

    @Column (name="date_of_birth")
    private Date dateOfBirth;

}
