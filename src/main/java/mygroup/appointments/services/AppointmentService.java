package mygroup.appointments.services;

import mygroup.appointments.domain.Appointment;
import mygroup.appointments.domain.Doctor;
import mygroup.appointments.exceptions.DoctorNotFoundException;
import mygroup.appointments.repositories.AppointmentRepository;
import mygroup.appointments.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentService {

    private final DoctorRepository doctorRepository;
    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(DoctorRepository doctorRepository, AppointmentRepository appointmentRepository){
        this.doctorRepository = doctorRepository;
        this.appointmentRepository = appointmentRepository;
    }

    public Page<Appointment> getAppointmentsForDoctor (
            Long doctorId,
            Pageable pageable) throws DoctorNotFoundException {
        Optional<Doctor> doctor = doctorRepository.findById(doctorId);
        if (doctor.isEmpty()) throw new DoctorNotFoundException("No Doctor with such ID");
        return appointmentRepository.getByDoctor(doctor.get(), pageable);
    }

    public Appointment createAppointment(){
        return null;
    }
}
