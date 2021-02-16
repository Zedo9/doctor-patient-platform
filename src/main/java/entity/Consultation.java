package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="consultation")
public class consultation {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="patient_id")
    private int patient_id;

    @Column(name="doctor_id")
    private String doctor_id;

    @Column(name="date")
    private String date;
       @Column(name="time")
    private String time;

    public consultation() {

    }
    
    public consultation(int patient_id, int doctor_id, String date, String time) {
        this.patient_id = patient_id;
        this.doctor_id = doctor_id;
        this.date = date;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patient_id;
    }

    public void setPatientId(int patient_id) {
        this.patient_id= patient_id;
    }

    public int getDoctorId() {
        return doctor_id;
    }

    public void setDoctorId(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
     public String getTime() {
        return time;
    }
       public void setTime(String Time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return " consultation [id=" + id + ", Doctor_ID=" + doctor_id + ", Patient_ID=" + patient_id + ",Date=" + date + ",Time=" + time+ "]";
    }

}