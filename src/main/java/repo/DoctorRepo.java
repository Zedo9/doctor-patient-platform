package repo;

import domain.Doctor;
import domain.Patient;

public interface DoctorRepo {
    Doctor getDoctorById(int id);
    Doctor saveDoctor(Doctor d);
    void deleteDoctor(Doctor d);
}
