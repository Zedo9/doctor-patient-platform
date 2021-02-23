import java.util.List;

import domain.Doctor;
import org.hibernate.Session;
import org.hibernate.Transaction;

import domain.Student;
import util.HibernateUtil;

import javax.print.Doc;

public class App {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
    }
}