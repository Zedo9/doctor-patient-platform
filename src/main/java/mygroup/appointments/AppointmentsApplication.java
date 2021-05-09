package mygroup.appointments;

import mygroup.appointments.domain.User;
import mygroup.appointments.domain.UserType;
import mygroup.appointments.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppointmentsApplication  {

	@Autowired
	private UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(AppointmentsApplication.class, args);
	}


}
