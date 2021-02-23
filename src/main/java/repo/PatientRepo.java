package repo;

import domain.Patient;

public interface PatientRepo {
    Patient getPatientById(int id);
    Patient getPatientByFullName(String fullName);
    Patient savePatient(Patient p);
    void deletePatient(Patient p);
}
