import java.util.List;

import domain.Patient;
import org.hibernate.Session;
import org.hibernate.Transaction;

import domain.Student;
import repo.PatientRepo;
import repo.PatientRepoImpl;
import util.HibernateUtil;




public class App {
    public static void main(String[] args) {

        Student student=new Student("mouwahed","mhadhbi","mouwahed66@gmail.com");
       Transaction transaction=null;
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            session.save(student);
            transaction.commit();
        }catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }

        try(Session sessions=HibernateUtil.getSessionFactory().openSession()) {
            List<Student> students=sessions.createQuery("from Student",Student.class).list();
            students.forEach(s->{
                System.out.println("Student email: "+s.getEmail());
            });
        }
        catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }


    }
}