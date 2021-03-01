import domain.User;

import repo.UserRepoImpl;

public class App {
    public static void main(String[] args) {
        User user = new User(2,"mymail","pass","DOCTOR",true,2);
        UserRepoImpl repo = new UserRepoImpl();
        repo.saveUser(user);
    }
}