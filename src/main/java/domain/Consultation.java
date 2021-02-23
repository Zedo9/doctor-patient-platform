package domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="consultation")
public class Consultation {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="consultation_id")
    private int id;


    @OneToMany
    private List<Patient> patients;
    @JoinColumn(name="patient_id",referencedColumnName = "patients.patient_id")

    private int patient_id;


    @OneToMany
    private List<Doctor> doctors;
    @JoinColumn(name="doctor_id",referencedColumnName = "doctors.doctor_id")

    private int doctor_id;

    @Column(name="date")
    private String date;

    @Column(name="cabinet_id")
    private int CabinetId;


    @Column(name="time")
    private String time;

    public Consultation(int id, int patient_id, int doctor_id, String date, int cabinetId, String time) {
        this.id = id;
        this.patient_id = patient_id;
        this.doctor_id = doctor_id;
        this.date = date;
        CabinetId = cabinetId;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCabinetId() {
        return CabinetId;
    }

    public void setCabinetId(int cabinetId) {
        CabinetId = cabinetId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}