package repo;

import domain.Doctor;

import javax.persistence.EntityManager;

public class DoctorRepoImpl implements DoctorRepo{
    private EntityManager entityManager;
    @Override
    public Doctor getDoctorById(int id) {
        return entityManager.find(Doctor.class,id);
    }

    @Override
    public Doctor getDoctorByFullName(String fullName) {
        return entityManager.find(Doctor.class,fullName);
    }

    @Override
    public Doctor saveDoctor(Doctor d) {
        entityManager.persist(d);
        return d;
    }

    @Override
    public void deleteDoctor(Doctor d) {
        if(entityManager.contains(d)){
            entityManager.remove(d);
        }
        else{
            entityManager.merge(d);
        }
    }
}
