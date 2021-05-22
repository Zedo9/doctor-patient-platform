package mygroup.appointments.requests;

import mygroup.appointments.domain.Appointment;
import mygroup.appointments.domain.AppointmentStatus;

import java.sql.Time;
import java.util.Date;

public class UpdateAppointmentRequest {
    private String notes;
    private AppointmentStatus status;
    private Date date;
    private Time time;

    public UpdateAppointmentRequest(){}

    public UpdateAppointmentRequest(String notes, AppointmentStatus status, Date date, Time time) {
        this.notes = notes;
        this.status = status;
        this.date = date;
        this.time = time;
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

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
