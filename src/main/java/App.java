import domain.Doctor;
import repo.DoctorRepoImpl;

public class App {
    public static void main(String[] args) {
        Doctor d1 = new Doctor("D1fname","D1lname","D1email","D1pass","D1spec");
        DoctorRepoImpl repo = new DoctorRepoImpl();
        repo.saveDoctor(d1);
    }
}