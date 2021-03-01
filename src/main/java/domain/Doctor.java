package domain;

import javax.persistence.*;
import javax.print.Doc;
import java.util.Set;

@Entity
@Table(name="doctor")
public class Doctor {
    public Doctor(){}
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="doctor_id")
    private int doctorId;

    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name="user_id_FK"), name = "user_id")
    private User user;

    @OneToMany(mappedBy = "doctor")
    private Set<Appointment> appointments;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column (name="phone")
    private String phone;

    @Column (name="address")
    private String address;

    @Column (name="city")
    private String city;

    @Column(name="speciality")
    private String speciality;

}
