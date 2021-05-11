package mygroup.appointments.repositories;

import mygroup.appointments.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

// JpaSpecificationExecutor : https://attacomsian.com/blog/spring-data-jpa-specifications
@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long>, JpaSpecificationExecutor {
}
