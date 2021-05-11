package mygroup.appointments.specs;

import mygroup.appointments.domain.Doctor;
import net.kaczmarzyk.spring.data.jpa.domain.EqualIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;


@And({
        @Spec(path="lastname", params="name", spec= Like.class),
        @Spec(path = "city", params = "city", spec= EqualIgnoreCase.class),
        @Spec(path = "doctorSpeciality", params = "speciality", spec= EqualIgnoreCase.class)
})
public interface DoctorSpec extends Specification<Doctor> {
}
