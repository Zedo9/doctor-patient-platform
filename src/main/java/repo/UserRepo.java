package repo;
import domain.User;

public interface UserRepo {
    User getUserById(int id);
    User saveUser(User d);
    void deleteUser(User d);
}
