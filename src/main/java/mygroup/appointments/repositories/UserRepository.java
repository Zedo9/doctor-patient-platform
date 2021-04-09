package mygroup.appointments.repositories;

import mygroup.appointments.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
