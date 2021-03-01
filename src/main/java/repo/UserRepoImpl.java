package repo;

import domain.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class UserRepoImpl implements UserRepo{
    private Session session;
    public UserRepoImpl(){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    @Override
    public User getUserById(int id) {
        return session.find(User.class,id);
    }
    @Override
    public User saveUser(User d) {
        Transaction transaction = session.beginTransaction();
        session.save(d);
        transaction.commit();
        return d;
    }
    @Override
    public void deleteUser(User d) {
        if(session.contains(d)){
            session.remove(d);
        }
        else{
            session.merge(d);
        }
    }
}
