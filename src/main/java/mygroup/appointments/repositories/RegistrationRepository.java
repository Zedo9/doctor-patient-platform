package mygroup.appointments.repositories;


import mygroup.appointments.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository< User,Long> {
   public User findByEmail(String email);
   public User findByEmailAndPassword(String email,String password);

}
