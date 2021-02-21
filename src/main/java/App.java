import java.util.List;

import domain.Doctor;
import org.hibernate.Session;
import org.hibernate.Transaction;

import domain.Student;
import util.HibernateUtil;

import javax.print.Doc;

public class App {
    public static void main(String[] args) {
        Student student = new Student("Ramesh", "Fadatare","rameshfadatare@javaguides.com");
        Student student1 = new Student("John", "Cena", "john@javaguides.com");
        Doctor doctor=new Doctor("mouwahed","mhadhbi","mouwahed66@gmail.com","AQWZSXEDCrfv101#","teeth");
        Doctor doctor1=new Doctor("abc","def","hij","qsd","qsd");
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student objects
            session.save(doctor);
            session.save(doctor1);
            session.save(student);
            session.save(student1);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            List<Student> students = session.createQuery("from Student", Student.class).list();

            students.forEach(s -> {
                System.out.println("Print student email id :"  + s.getEmail());
            });
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}