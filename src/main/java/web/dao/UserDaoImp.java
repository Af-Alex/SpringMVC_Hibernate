package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getUsers() {
        return em.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        em.persist(user);
    }

    @Override
    public User getUser(int id) {
        return em.find(User.class, id);
    }

    @Override
    public User update(User updatedUser) {
        return  em.merge(updatedUser);
    }

    @Override
    public void deleteUser(User user) {
        em.remove(user);
    }

    @Override
    public void deleteById(int id) {
        deleteUser(em.find(User.class, id));
    }
}
