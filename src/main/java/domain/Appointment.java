package domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="appointment")
public class Appointment {
    public Appointment(){}

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="appointment_id")
    private int appointmentId;

    @ManyToOne
    @JoinColumn(foreignKey=@ForeignKey(name="patient_id_FK"),name="patient_id", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(foreignKey=@ForeignKey(name="doctor_id_FK"),name="doctor_id" ,nullable = false)
    private Doctor doctor;

    @Column(name="notes")
    private String notes;

    // "PENDING" - "CONFIRMED" - "REJECTED"
    @Column(name="status")
    private String status;

    @Column(name="date_time")
    private Timestamp dateTime;

    public Appointment(int appointmentId, Patient patient, Doctor doctor, String notes, String status, Timestamp dateTime) {
        this.appointmentId = appointmentId;
        this.patient = patient;
        this.doctor = doctor;
        this.notes = notes;
        this.status = status;
        this.dateTime = dateTime;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }
}
