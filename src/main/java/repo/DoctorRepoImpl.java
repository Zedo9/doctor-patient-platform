package repo;

import domain.Doctor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class DoctorRepoImpl implements DoctorRepo{
    private Session session;
    public DoctorRepoImpl(){
        session = HibernateUtil.getSessionFactory().openSession();
    }
    @Override
    public Doctor getDoctorById(int id) {
        return session.find(Doctor.class,id);
    }

    @Override
    public Doctor getDoctorByFullName(String fullName) {
        return session.find(Doctor.class,fullName);
    }

    @Override
    public Doctor saveDoctor(Doctor d) {
        Transaction transaction = session.beginTransaction();
        session.save(d);
        transaction.commit();
        return d;
    }

    @Override
    public void deleteDoctor(Doctor d) {
        if(session.contains(d)){
            session.remove(d);
        }
        else{
            session.merge(d);
        }
    }
}
