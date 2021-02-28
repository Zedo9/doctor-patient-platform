package domain;

import javax.persistence.*;

@Entity
@Table(name="consultation")
public class Consultation {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="consultation_id")
    private int id;

    @OneToOne
    @JoinColumn(name="patient_id")
    private Patient patient;

    @OneToOne
    @JoinColumn(name="doctor_id")
    private Doctor doctor;
    @Column(name="date")
    private String date;

    @Column(name="cabinet_id")
    private int CabinetId;


    @Column(name="time")
    private String time;

    public Consultation(int id, Patient patient, Doctor doctor, String date, int cabinetId, String time) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        CabinetId = cabinetId;
        this.time = time;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
