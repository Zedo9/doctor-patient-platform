package mygroup.appointments.services;

import mygroup.appointments.requests.UpdateDoctorRequest;
import mygroup.appointments.domain.Doctor;
import mygroup.appointments.exceptions.DoctorNotFoundException;
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

    @Autowired
    public DoctorService(DoctorRepository doctorRepository, AppointmentRepository appointmentRepository){
        this.doctorRepository = doctorRepository;
    }

    public Page<Doctor> getAllDoctorsBySpec(DoctorSpec doctorSpec, Pageable pageable){
        return doctorRepository.findAll(doctorSpec, pageable);
    }

    public Doctor getDoctorById(Long doctorId) throws DoctorNotFoundException{
        Optional<Doctor> doctor = doctorRepository.findById(doctorId);
        if (doctor.isEmpty()){
            throw new DoctorNotFoundException("No Doctor with ID "+doctorId);
        }
        return doctor.get();
    }

    public Doctor createDoctor(Doctor doctor){
        return doctorRepository.save(doctor);
    }

    public void deleteDoctor(Long doctorId) throws DoctorNotFoundException {
        Doctor doctor = getDoctorById(doctorId);
        doctorRepository.delete(doctor);
    }

    public Doctor patchDoctor(Long doctorId, UpdateDoctorRequest doctorChanges) throws DoctorNotFoundException{
        Doctor doctor = getDoctorById(doctorId);
        if (doctorChanges.getDoctorSpeciality() != null ) doctor.setSpeciality(doctorChanges.getDoctorSpeciality());
        if (doctorChanges.getAddress() != null ) doctor.setAddress(doctorChanges.getAddress());
        if (doctorChanges.getPhone() != null ) doctor.setPhone(doctorChanges.getPhone());
        if (doctorChanges.getCity() != null ) doctor.setCity(doctorChanges.getCity());
        doctorRepository.save(doctor);
        return doctor;
    }
}
