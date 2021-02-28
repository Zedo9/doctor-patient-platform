package repo;

import domain.Patient;

import javax.persistence.EntityManager;

public class PatientRepoImpl implements PatientRepo{
    private EntityManager em;

    @Override
    public Patient getPatientById(int id) {
        return em.find(Patient.class,id);
    }

    @Override
    public Patient getPatientByFullName(String fullName) {
        return em.find(Patient.class,fullName);
    }

    @Override
    public Patient savePatient(Patient p) {
        em.persist(p);
        return p;
    }

    @Override
    public void deletePatient(Patient p) {
        if (em.contains(p)) {
            em.remove(p);
        } else {
            em.merge(p);
        }
    }
}
