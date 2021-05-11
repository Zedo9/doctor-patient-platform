package mygroup.appointments.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="appointment")
public class Appointment {
    public Appointment(){
    }
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="appointment_id")
    private Long appointmentId;

    @ManyToOne
    @JoinColumn(name="patient_id", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name="doctor_id" ,nullable = false)
    private Doctor doctor;

    @Column(name="notes")
    private String notes;

    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;

    @Temporal(TemporalType.DATE)
    @Column(name="date")
    private Date date;

    @Temporal(TemporalType.TIME)
    @Column(name="time")
    private Date time;

    public Appointment(Long appointmentId, Patient patient, Doctor doctor, String notes, AppointmentStatus status, Date date, Date time) {
        this.appointmentId = appointmentId;
        this.patient = patient;
        this.doctor = doctor;
        this.notes = notes;
        this.status = status;
        this.date = date;
        this.time = time;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
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

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return Objects.equals(appointmentId, that.appointmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appointmentId);
    }
}
