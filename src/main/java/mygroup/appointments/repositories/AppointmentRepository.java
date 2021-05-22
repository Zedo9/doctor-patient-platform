package mygroup.appointments.repositories;

import mygroup.appointments.domain.Appointment;
import mygroup.appointments.domain.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
    Page<Appointment> getByDoctor(Doctor doctor, Pageable pageable);
}
