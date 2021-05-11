package mygroup.appointments.Services;

import mygroup.appointments.domain.Doctor;
import mygroup.appointments.repositories.AppointmentRepository;
import mygroup.appointments.repositories.DoctorRepository;
import mygroup.appointments.specs.DoctorSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final AppointmentRepository appointmentRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository, AppointmentRepository appointmentRepository){
        this.doctorRepository = doctorRepository;
        this.appointmentRepository = appointmentRepository;
    }

    public Page<Doctor> getAllDoctorsBySpec(DoctorSpec doctorSpec, Pageable pageable){
        return doctorRepository.findAll(doctorSpec, pageable);
    }

    public Optional<Doctor> getDoctorById(Long doctorId){
        return doctorRepository.findById(doctorId);
    }

    public Doctor updateDoctor(Doctor doctor){
        return null;
    }

    public Doctor createDoctor(Doctor doctor){
        return doctorRepository.save(doctor);
    }

    public void deleteDoctor(Long doctorId) throws Exception {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(Exception::new);
        doctorRepository.delete(doctor);
    }


}
